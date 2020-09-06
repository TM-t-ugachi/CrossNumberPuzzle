package com.example.crossnumberpuzzle.presentation.model;

public class GameMainRepository {
    fun fetchText(): Array<Array<String?>> {
        return Array(10,{ arrayOfNulls<String>(10)})
    }
}

