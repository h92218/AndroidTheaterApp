package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.myapplication.data.AppDatabase
import com.example.myapplication.data.Theater
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    // Room database 인스턴스 생성
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "theater-database"
        ).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainScreen(db)
            }
        }
    }
}

@Composable
fun MainScreen(db: AppDatabase) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center // 화면 중앙에 정렬
        ) {
            ButtonList()
        }
    }
}

@Composable
fun ButtonList() {
    val context = LocalContext.current // Compose에서 Context 가져오기

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp), // 버튼 간격
        horizontalAlignment = Alignment.CenterHorizontally // 중앙 정렬
    ) {
        Button(onClick = { navigateToActivity(context, CgvActivity::class.java) },
            modifier = Modifier.width(200.dp)) {
            Text("CGV")
        }
        Button(onClick = { showToast(context, "씨네큐 버튼 클릭") },
            modifier = Modifier.width(200.dp)) {
            Text("씨네큐")
        }
        Button(onClick = { showToast(context, "롯데시네마 버튼 클릭") },
            modifier = Modifier.width(200.dp)) {
            Text("롯데시네마")
        }
        Button(onClick = { showToast(context, "메가박스 버튼 클릭") },
            modifier = Modifier.width(200.dp)) {
            Text("메가박스")
        }
    }
}

fun showToast(context: android.content.Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun navigateToActivity(context: android.content.Context, activityClass: Class<*>) {
    val intent = Intent(context, activityClass)
    context.startActivity(intent)
}

