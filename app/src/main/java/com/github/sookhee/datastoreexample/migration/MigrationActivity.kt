package com.github.sookhee.datastoreexample.migration

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.sookhee.datastoreexample.databinding.ActivityMigrationBinding

class MigrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMigrationBinding

    private lateinit var pref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMigrationBinding.inflate(layoutInflater)

        setContentView(binding.root)

        pref = this.getPreferences(0)
        editor = pref.edit()

        getSharedPreference()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnSave.setOnClickListener {
            setSharedPreference()
            getSharedPreference()
        }
    }

    private fun setSharedPreference() {
        editor.putString(KEY_NAME, binding.etName.text.toString()).apply()
    }

    private fun getSharedPreference() {
        val name = pref.getString(KEY_NAME, "")

        binding.tvName.text = name
        binding.etName.text = null
    }

    companion object {
        private const val KEY_NAME = "key_shared_name"
    }
}
