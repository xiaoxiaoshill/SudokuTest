package com.example.sudokutest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ControlFragment:Fragment() {
    private val sudokulist = ArrayList<sudoku>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*加载布局*/
        return inflater.inflate(R.layout.sudoku_control_frag,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initsudoku()
        val layoutManager = StaggeredGridLayoutManager(3,
            StaggeredGridLayoutManager.VERTICAL)
        val activity = activity as MainActivity
        val recyclerview: RecyclerView = activity.findViewById(R.id.recyclerview)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = SudokuAdapter(sudokulist)
        recyclerview.addItemDecoration(Decoration())
    }

    private fun initsudoku(){
        sudokulist.add(sudoku("空气质量",R.drawable.kqzl))
        sudokulist.add(sudoku("天气预报",R.drawable.tqyb))
        sudokulist.add(sudoku("股票",R.drawable.gphq))
        sudokulist.add(sudoku("全球汇率",R.drawable.hlcx))
        sudokulist.add(sudoku("快递查询",R.drawable.kdcx))
        sudokulist.add(sudoku("油价",R.drawable.yj))
    }
}