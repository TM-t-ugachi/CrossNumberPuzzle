package com.example.crossnumberpuzzle.presentation.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.crossnumberpuzzle.R
import com.example.crossnumberpuzzle.databinding.FragmentSecondBinding
import com.example.crossnumberpuzzle.presentation.viewModel.GameMainViewModel


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class GameMainFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val viewModel: GameMainViewModel by lazy{
        ViewModelProviders.of(this).get(GameMainViewModel::class.java)
    }

    private lateinit var numberPlaceBoard: TableLayout


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater,container,false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.initBoard()

        numberPlaceBoard = view.findViewById(R.id.numberPlaceBoard)
        for (i in 0 until numberPlaceBoard.childCount) {
            val child: View = numberPlaceBoard.getChildAt(i)
            val row: TableRow = child as TableRow
            for (j in 0 until row.childCount) {
                val cell: TextView = row.getChildAt(j) as TextView
                cell.setOnClickListener {
                    viewModel.numberPlaceBoardTapped(i,j)
                    resetCellColor()
                    cell.setBackgroundColor(Color.LTGRAY)
                }
            }
        }

        val gridLayout:androidx.gridlayout.widget.GridLayout = view.findViewById(R.id.buttons)
        for(i in 0 until gridLayout.childCount){
            val child: View = gridLayout.getChildAt(i)
            child.setOnClickListener {
                viewModel.numberButtonTapped(i + 1)

            }
        }
    }

    fun resetCellColor(){
        for (i in 0 until numberPlaceBoard.childCount) {
            val child: View = numberPlaceBoard.getChildAt(i)
            val row: TableRow = child as TableRow
            for (j in 0 until row.childCount) {
                val cell: TextView = row.getChildAt(j) as TextView
                cell.setBackgroundColor(Color.WHITE)
            }
        }
    }

}