package com.example.crossnumberpuzzle.presentation.viewModel;

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crossnumberpuzzle.presentation.model.GameMainRepository
import com.example.crossnumberpuzzle.presentation.model.NumberPlaceBoardModel

public class GameMainViewModel() : ViewModel() {
    var selectedRow = 0
    var selectedCell = 0
    var board:Array<IntArray> = arrayOf(intArrayOf(0,0,0,0,0,0,0,0,0), intArrayOf(0,0,0,0,0,0,0,0,0,0,0))

    fun initBoard(){
        NumberPlaceBoardModel().getBoard()
    }

    fun numberPlaceBoardTapped(row: Int,line: Int){
        selectedRow = row
        selectedCell = line
    }

    fun numberButtonTapped(num: Int){

    }

}
