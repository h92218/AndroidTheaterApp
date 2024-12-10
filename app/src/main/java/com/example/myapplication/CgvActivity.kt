package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class CgvActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                SelectBoxExample()
            }
        }
    }
}


@Composable
fun SelectBoxExample() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("선택해주세요") }
    var showTextField by remember { mutableStateOf(false) }
    // 텍스트 입력값 상태 변수
    var text by remember { mutableStateOf("") } // 텍스트 상태 초기화
    // 데이터 목록
    val options = listOf("영등포", "용산", "명동")

    Column(modifier = Modifier.padding(16.dp)) {
        // 드롭다운 버튼 (TextField와 드롭다운 메뉴)
        Text(
            text = selectedOptionText,

            modifier = Modifier.width(200.dp)  // 텍스트 필드가 화면에 꽉 차도록 설정
                .clickable { expanded = !expanded }
        )


        if (showTextField) {

        }

        // 드롭다운 메뉴
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(200.dp)
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOptionText = option
                        expanded = false

                    }
                )
            }
        }
    }

    Row(modifier = Modifier.padding(top = 300.dp)) {
        Text(
            text="추가하기",
            modifier = Modifier.padding(top = 13.dp)
        )
        IconButton(
            onClick = { showTextField = true },
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
    }

    if (showTextField) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("텍스트 입력") },
            modifier = Modifier.padding(top = 350.dp)
        )
        Button(onClick = {  },
            modifier = Modifier.padding(top = 350.dp, start = 200.dp)) {
            Text("Save")
        }
    }
}

