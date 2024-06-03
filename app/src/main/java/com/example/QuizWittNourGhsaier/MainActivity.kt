package com.example.QuizWittNourGhsaier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
import dagger.hilt.android.AndroidEntryPoint
import com.example.QuizWittNourGhsaier.ui.theme.QuizWittTheme
import androidx.compose.material3.Surface

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizWittTheme {




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