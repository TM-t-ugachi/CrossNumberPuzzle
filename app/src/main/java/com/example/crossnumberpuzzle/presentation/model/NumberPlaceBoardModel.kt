package com.example.crossnumberpuzzle.presentation.model;

public class NumberPlaceBoardModel {
    private var board:Array<IntArray> = arrayOf(
    intArrayOf(0,1,2,3,4,5,6,7,8),
    intArrayOf(0,1,2,3,4,5,6,7,8),
    intArrayOf(0,1,2,3,4,5,6,7,8),
    intArrayOf(0,1,2,3,4,5,6,7,8),
    intArrayOf(0,1,2,3,4,5,6,7,8),
    intArrayOf(0,1,2,3,4,5,6,7,8),
    intArrayOf(0,1,2,3,4,5,6,7,8),
    intArrayOf(0,1,2,3,4,5,6,7,8),
    intArrayOf(0,1,2,3,4,5,6,7,8)
    )

    fun setNumber(row: Int,line: Int,insertNum: Int){
        board[row][line] = insertNum
    }

    public fun getBoard(): Array<IntArray>{
        return board
    }


}
