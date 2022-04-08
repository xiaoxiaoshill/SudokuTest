package com.example.sudokutest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.annotation.ColorInt




class SudokuAdapter(val sudokelist: List<sudoku>):RecyclerView.Adapter<SudokuAdapter.ViewHolder>() {
    inner class ViewHolder(view:View) : RecyclerView.ViewHolder(view){
        val sudokuimage:ImageView = view.findViewById(R.id.image)
        val sudokuname:TextView = view.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.picture_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sudoku = sudokelist[position]
        holder.sudokuimage.setImageResource(sudoku.imgid)
        holder.sudokuname.text = sudoku.name
    }

    override fun getItemCount() = sudokelist.size

}

class Decoration : RecyclerView.ItemDecoration(){

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = 5
        if ((parent.getChildAdapterPosition(view)+1)%3 != 0){
            outRect.right = 5

        }
    }
}