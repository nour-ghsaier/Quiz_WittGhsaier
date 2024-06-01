package com.example.QuizWittNourGhsaier.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.QuizWittNourGhsaier.ui.theme.MontserratFamily

@Composable
fun QuizEnd(
    navController: NavController,
    correctAnswer: Int?,
    totalQuestions: Int?
) {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.onBackground
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Score: $correctAnswer/$totalQuestions",
                fontFamily = MontserratFamily,
                fontWeight = FontWeight.W900,
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.background
            )
        }
    }
}