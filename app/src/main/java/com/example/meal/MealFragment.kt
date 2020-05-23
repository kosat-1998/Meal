package com.example.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meal.adapter.MealAdapter
import com.example.meal.viewmodel.MealViewModel
import kotlinx.android.synthetic.main.fragment_meal.*

/**
 * A simple [Fragment] subclass.
 */
class MealFragment : Fragment() {

    private lateinit var mealViewModel :MealViewModel
    private lateinit var mealAdapter: MealAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mealAdapter = MealAdapter()
        recyclerMeal.apply {
            adapter = mealAdapter
            layoutManager = LinearLayoutManager(context)
        }
        obserViewModel()        //getting data from viewModel to adapter

    }

    override fun onResume() {
        super.onResume()

        mealViewModel.loadMeal()
    }

    fun obserViewModel(){

        mealViewModel = ViewModelProvider(this).get(MealViewModel::class.java)

        mealViewModel.getMeal().observe(viewLifecycleOwner,
            Observer {
                mealAdapter.updateList(it)
            }
        )


    }

}
