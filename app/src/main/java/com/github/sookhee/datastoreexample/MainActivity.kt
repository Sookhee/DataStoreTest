package com.github.sookhee.datastoreexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.sookhee.datastoreexample.databinding.ActivityMainBinding
import com.github.sookhee.datastoreexample.migration.MigrationActivity
import com.github.sookhee.datastoreexample.preference.PreferenceActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnPreference.setOnClickListener {
            startActivity(Intent(this, PreferenceActivity::class.java))
        }

        binding.btnMigration.setOnClickListener {
            startActivity(Intent(this, MigrationActivity::class.java))
        }
    }
}
