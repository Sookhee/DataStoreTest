package com.github.sookhee.datastoreexample.preference

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.sookhee.domain.usecase.GetPreferenceUseCase
import com.github.sookhee.domain.usecase.SetPreferenceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PreferenceViewModel @ViewModelInject constructor(
    private val getPreferenceUseCase: GetPreferenceUseCase,
    private val setPreferenceUseCase: SetPreferenceUseCase
) : ViewModel() {
    private val _uiMode = MutableStateFlow<Boolean>(false)
    val uiMode: StateFlow<Boolean> = _uiMode

    private val _name = MutableStateFlow<String>("")
    val name: StateFlow<String> = _name

    fun getUiModePreference() {
        viewModelScope.launch {
            getPreferenceUseCase(KEY_UI_MODE).collect {
                when (it as? Boolean) {
                    true -> _uiMode.emit(true)
                    else -> _uiMode.emit(false)
                }
            }
        }
    }

    fun setUiModePreference(uiMode: Boolean) {
        viewModelScope.launch {
            setPreferenceUseCase(KEY_UI_MODE, uiMode)
        }
    }

    fun getNamePreference() {
        viewModelScope.launch {
            getPreferenceUseCase(KEY_NAME).collect {
                _name.emit(it.toString())
            }
        }
    }

    fun setNamePreference(name: String) {
        viewModelScope.launch {
            setPreferenceUseCase(KEY_NAME, name)
        }
    }

    companion object {
        private const val KEY_UI_MODE = "ui_mode"
        private const val KEY_NAME = "key_shared_name"
    }
}
