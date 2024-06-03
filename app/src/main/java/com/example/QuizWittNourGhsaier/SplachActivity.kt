package com.example.QuizWittNourGhsaier

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.QuizWittNourGhsaier.ui.theme.QuizWittTheme
import kotlinx.coroutines.delay
import com.example.QuizWittNourGhsaier.pencilLoader.PencilLoader
import com.example.QuizWittNourGhsaier.ui.theme.Montserrat

@SuppressLint("CustomSplachScreen")
class SplachActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizWittTheme{
                SplachScreen()
            }
        }

    }
    @Preview
    @Composable
    private fun SplachScreen(){
        val alpha= remember{
            Animatable(0f)

        }
        LaunchedEffect(key1 = true ) {
            alpha.animateTo(1f,animationSpec= tween(3000,easing= LinearOutSlowInEasing))
            delay(3000)
            startActivity(Intent(this@SplachActivity,MainActivity::class.java))
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF581665)),
            contentAlignment = Alignment.Center){

            Column (horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ){
                Text(text = "Welcome to Quiz Witt",  style = MaterialTheme.typography.bodyLarge,
                    color = Color.White, fontFamily = Montserrat,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp)
                Text(text = "By Nour Ghsaier", color = Color(0xFFEFB8C8))
                Spacer(modifier = Modifier.height(100.dp))

                PencilLoader(
                        strokeWidth = 14.dp,
                        modifier = Modifier
                            .size(100.dp)
                    )


                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "The quiz will start soon...", style = MaterialTheme.typography.labelMedium,
                    color = Color.White)
        }
        }


    }
}