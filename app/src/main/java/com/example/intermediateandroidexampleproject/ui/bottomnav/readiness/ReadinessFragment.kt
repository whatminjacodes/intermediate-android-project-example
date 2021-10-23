package com.example.intermediateandroidexampleproject.ui.bottomnav.readiness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.intermediateandroidexampleproject.databinding.FragmentReadinessBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReadinessFragment : Fragment() {
    private val readinessViewModel: ReadinessViewModel by viewModel()

    private var _binding: FragmentReadinessBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReadinessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        readinessViewModel.testing()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}