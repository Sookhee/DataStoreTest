package com.github.sookhee.datastoreexample.preference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.github.sookhee.datastoreexample.R
import com.github.sookhee.datastoreexample.databinding.ActivityPreferenceBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PreferenceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPreferenceBinding
    private lateinit var viewModel: PreferenceViewModel

    private var uiMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenceBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(PreferenceViewModel::class.java)

        setContentView(binding.root)

        viewModel.getUiModePreference()

        initView()
        observeData()
    }

    private fun initView() {
        binding.btnUiMode.setOnClickListener {
            viewModel.setUiModePreference(!uiMode)
        }
    }

    private fun observeData() {
        viewModel.uiMode.asLiveData().observe(this) {
            when(it) {
                true -> setDarkMode()
                false -> setLightMode()
            }
        }
    }

    private fun setDarkMode() {
        uiMode = true

        Log.i("민지", "setDarkMode")
        binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
    }

    private fun setLightMode() {
        uiMode = false

        Log.i("민지", "setLightMode")
        binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
    }
}