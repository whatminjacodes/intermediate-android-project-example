package com.example.intermediateandroidexampleproject.ui.login

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.content.edit
import androidx.navigation.fragment.findNavController
import com.example.intermediateandroidexampleproject.R
import com.example.intermediateandroidexampleproject.application.IntermediateAndroidApplication.Companion.PREF_ACCESS_TOKEN
import com.example.intermediateandroidexampleproject.databinding.FragmentLoginWebviewBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginWebViewFragment : Fragment() {

    private lateinit var binding: FragmentLoginWebviewBinding

    private val sharedPreferences: SharedPreferences by inject()
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginWebviewBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            loginWebViewToolbar.title = "Log in"
            loginWebViewToolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }


            //loginViewModel.validateOuraToken()
            loginWebView.settings.javaScriptEnabled = true

            val ouraurl =
                "https://cloud.ouraring.com/oauth/authorize?response_type=code?client_id=${loginViewModel.clientId}&redirect_uri${loginViewModel.redirectUri}#"
//https://cloud.ouraring.com/account/login?next=%2Foauth%2Fauthorize%3Fresponse_type%3Dcode%26client_id%3DDS3NBTQG5D6GTPMC%26redirect_uri%3Diaep%253A%252F%252Fcallback
            // val url =
            //   "https://cloud.ouraring.com/login/oauth/authorize?client_id=${loginViewModel.clientId}&scope=repo&redirect_uri${loginViewModel.redirectUri}"
            /* loginWebView.webViewClient = object : WebViewClient() {
                 override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                     if (url.contains(loginViewModel.redirectUri)) {
                         handleLoginResponse(Uri.parse(url.replaceFirst("#", "?")))
                     } else {
                         view.loadUrl(url)
                     }
                     return true
                 }
             }*/

            loginWebView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    if (url.contains("asmo://frontpage")) {
                        // binding.loginStatus.setText(R.string.login_logging_in)
                        handleLoginResponse(Uri.parse(url.replaceFirst("#", "?")))
                    } else {
                        view.loadUrl(url)
                    }
                    return true
                }
            }

            loginWebView.loadUrl(ouraurl)

            loginViewModel.loginValidity.observe(viewLifecycleOwner, { valid ->
                if (valid) {
                    findNavController().navigate(R.id.action_LoginWebViewFragment_to_BottomNavigationActivity)
                    requireActivity().finish()
                } else {
                    context?.let { context ->
                        MaterialAlertDialogBuilder(context)
                            .setTitle("Error")
                            .setMessage("Something went wrong. Try again")
                            .setPositiveButton("Return to log in page") { _, _ ->
                                findNavController().popBackStack()
                            }
                            .show()
                    }
                }
            })
        }
    }

    private fun handleLoginResponse(uri: Uri) {
        val code = uri.getQueryParameter("code")

        loginViewModel.validateOuraToken()
        if (code != null) {
            sharedPreferences.edit {
                putString(PREF_ACCESS_TOKEN, code)
                commit()
            }

            loginViewModel.validateGithubToken(code)

            //loginViewModel.isLoginValid(true)
        } else {
            loginViewModel.isLoginValid(false)
        }
    }
}