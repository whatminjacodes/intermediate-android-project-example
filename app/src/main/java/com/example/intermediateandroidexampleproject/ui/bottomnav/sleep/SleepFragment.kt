package com.example.intermediateandroidexampleproject.ui.bottomnav.sleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.intermediateandroidexampleproject.databinding.FragmentSleepBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SleepFragment : Fragment() {
    private val sleepViewModel: SleepViewModel by viewModel()

    private var _binding: FragmentSleepBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSleepBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}