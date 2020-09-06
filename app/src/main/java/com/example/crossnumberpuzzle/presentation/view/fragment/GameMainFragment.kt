package com.example.crossnumberpuzzle.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TableLayout
import android.widget.TableRow
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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

        val numberPlaceBoard: TableLayout = view.findViewById(R.id.numberPlaceBoard)
        for (i in 0 until numberPlaceBoard.childCount) {
            val child: View = numberPlaceBoard.getChildAt(i)
            val row: TableRow = child as TableRow
            for (j in 0 until row.childCount) {
                row.getChildAt(j).setOnClickListener {
                    viewModel.numberPlaceBoardTapped(i,j)
                }
            }
        }

        val gridLayout: GridLayout = view.findViewById(R.id.buttons)
        for(i in 0 until gridLayout.childCount){
            val child: View = gridLayout.getChildAt(i)
            child.setOnClickListener {
                viewModel.numberButtonTapped(i)
            }
        }
    }
}