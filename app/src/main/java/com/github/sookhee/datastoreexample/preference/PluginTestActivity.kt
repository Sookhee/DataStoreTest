package com.github.sookhee.datastoreexample.preference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.github.sookhee.datastoreexample.databinding.ActivityPluginTestBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PluginTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPluginTestBinding
    private lateinit var viewModel: PreferenceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPluginTestBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(PreferenceViewModel::class.java)

        setContentView(binding.root)

        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)

            val uiMode = intent.getBooleanExtra("ui_mode", false)
            viewModel.setUiModePreference(!uiMode)

            finish()
        }
    }
}