@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.QuizWittNourGhsaier.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.QuizWittNourGhsaier.R
import com.example.QuizWittNourGhsaier.ui.theme.Montserrat
import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizEnd(
    navController: NavController,
    correctAnswer: Int?,
    totalQuestions: Int?
) {
    //
    val progress = remember { Animatable(0f) }
    LaunchedEffect(correctAnswer) {
        correctAnswer?.let {
            val percentage = (it.toFloat() / (totalQuestions ?: 1))
            progress.animateTo(
                targetValue = percentage,
                animationSpec = tween(durationMillis = 1000)
            )
        }
    }

    //
    Scaffold(
        topBar = { WittTopAppBar() },
        bottomBar = { BottomNavigationBar(navController) },

        content = { paddingValues ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                color = MaterialTheme.colorScheme.primary
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
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.W900,
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Spacer(modifier = Modifier.height(20.dp))


                    Box(contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(
                            progress = progress.value,
                            modifier = Modifier.size(100.dp),
                            color = MaterialTheme.colorScheme.secondary,
                            strokeWidth = 8.dp
                        )
                        Text(
                            text = "${(progress.value * 100).toInt()}%",
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))


                    if (correctAnswer != null) {
                        val resultText = if (correctAnswer >= 5) {
                            "Congrats! You passed the quiz!"
                        } else {
                            "Sorry, you failed the quiz."
                        }
                        val resultColor = if (correctAnswer >= 5) {
                            MaterialTheme.colorScheme.secondary
                        } else {
                            MaterialTheme.colorScheme.error
                        }
                        Text(
                            text = resultText,
                            fontFamily = Montserrat,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = resultColor
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        val resultImage = if (correctAnswer >= 5) {
                            R.drawable.you_win
                        } else {
                            R.drawable.gameover_
                        }
                        Image(
                            painter = painterResource(id = resultImage),
                            contentDescription = null,
                            modifier = Modifier.size(200.dp)
                        )
                    }




                }
            }
        }
    )
}

@Composable
fun WittTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center ) {

                Image(
                    modifier = Modifier
                        .size(80.dp)
                        .padding(10.dp),
                    painter = painterResource(R.drawable.logoquiz),
                    contentDescription = null
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        modifier = modifier
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    androidx.compose.material3.BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        androidx.compose.material3.Button(
            onClick = { navController.navigate(Screens.QuizHome.name) },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()

        ) {
            Text(text = "Retake the quiz", color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}
