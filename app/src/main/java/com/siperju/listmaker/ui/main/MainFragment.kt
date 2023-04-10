package com.siperju.listmaker.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.siperju.listmaker.R
import com.siperju.listmaker.models.TaskList
import com.siperju.listmaker.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container,
            false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity(),
            MainViewModelFactory(
                PreferenceManager.getDefaultSharedPreferences(requireActivity()))).get(MainViewModel::class.java)
        val recyclerViewAdapter =
                ListSelectionRecyclerViewAdapter(viewModel.lists)
        binding.listsRecyclerview.adapter = recyclerViewAdapter
        viewModel.onListAdded = {
            recyclerViewAdapter.listsUpdated()
        }
    }
}