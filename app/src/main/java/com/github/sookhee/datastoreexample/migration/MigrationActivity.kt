package com.github.sookhee.datastoreexample.migration

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.github.sookhee.datastoreexample.databinding.ActivityMigrationBinding
import com.github.sookhee.datastoreexample.preference.PreferenceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MigrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMigrationBinding
    private lateinit var viewModel: PreferenceViewModel

    private lateinit var pref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMigrationBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(PreferenceViewModel::class.java)

        pref = this.getPreferences(0)
        editor = pref.edit()

        setContentView(binding.root)

        viewModel.getNamePreference()

        setOnClickListener()
        setObserver()
    }

    private fun setOnClickListener() {
        binding.btnSave.setOnClickListener {
            viewModel.setNamePreference(binding.etName.text.toString())

            binding.etName.text = null
        }
    }

    private fun setObserver() {
        viewModel.name.asLiveData().observe(this) {
            binding.tvName.text = it
        }
    }

    // 마이그레이션 후에는 SharedPreference 사용X
//    private fun setSharedPreference() {
//        editor.putString(KEY_NAME, binding.etName.text.toString()).apply()
//    }
//
//    private fun getSharedPreference() {
//        val name = pref.getString(KEY_NAME, "")
//
//        binding.tvName.text = name
//        binding.etName.text = null
//    }
}
