package com.example.QuizWittNourGhsaier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.QuizWittNourGhsaier.screen.QuestionsViewModel
import com.example.QuizWittNourGhsaier.screen.QuizEnd
import com.example.QuizWittNourGhsaier.screen.QuizHome
import com.example.QuizWittNourGhsaier.screen.Screens
import com.example.QuizWittNourGhsaier.ui.theme.EnglishQuizTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnglishQuizTheme {
                val viewModel = viewModel<QuestionsViewModel>()
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screens.QuizHome.name
                ) {
                    composable(Screens.QuizHome.name) {
                        QuizHome(
                            navController,
                            viewModel
                        )
                    }

                    composable(
                        Screens.QuizEnd.name + "/{correctAnswer}/{totalQuestion}",
                        arguments = listOf(
                            navArgument("correctAnswer") {
                                type = NavType.IntType
                                defaultValue = 0
                            },
                            navArgument("totalQuestion") {
                                type = NavType.IntType
                                defaultValue = 0
                            }
                        )
                    ) { backStackEntry ->
                        QuizEnd(
                            navController = navController,
                            backStackEntry.arguments?.getInt("correctAnswer") ?: 0,
                            backStackEntry.arguments?.getInt("totalQuestion")?: 0
                        )
                    }
                }
            }
        }
    }
}