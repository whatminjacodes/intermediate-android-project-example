package com.example.intermediateandroidexampleproject.ui.bottomnav.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.intermediateandroidexampleproject.databinding.FragmentActivityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ActivityFragment : Fragment() {
    private val activityViewModel: ActivityViewModel by viewModel()

    private var _binding: FragmentActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}