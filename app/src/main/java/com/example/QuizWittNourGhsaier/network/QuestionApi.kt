package com.example.QuizWittNourGhsaier.network

import com.example.QuizWittNourGhsaier.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {

    @GET("quizList.json")
    suspend fun getAllQuestions(): Question
}
