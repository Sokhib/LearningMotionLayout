package com.sokhibdzhon.learningmotionlayout

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**     I ❤ Code:)
╔═══════════════════════════════════════╗
║  Created by Sokhibdzhon Saidmuratov   ║
╠═══════════════════════════════════════╣
║ sokhibsaid@gmail.com                  ║
╚═══════════════════════════════════════╝
 */

class MainViewModel : ViewModel() {
    private val _words = MutableLiveData<MutableList<String>>()
    val words
        get() = _words

    private val _current = MutableLiveData<String>()
    val current
        get() = _current

    init {
        _words.value =
            mutableListOf("1", "2", "3", "4", "5", "1", "2", "3", "4", "5", "1", "2", "3", "4", "5")
    }

    fun nextWord() {
        if (!words.value.isNullOrEmpty()) {
            _current.value = _words.value!!.removeAt(0)
        }
    }

}