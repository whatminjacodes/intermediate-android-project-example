package com.example.intermediateandroidexampleproject.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.intermediateandroidexampleproject.R
import com.example.intermediateandroidexampleproject.databinding.FragmentLoginWebviewBinding

class LoginWebViewFragment : Fragment() {

    private lateinit var binding: FragmentLoginWebviewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginWebviewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findNavController().navigate(R.id.action_LoginWebViewFragment_to_BottomNavigationActivity)
    }
}