package com.example.spannablelanguage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spannablelanguage.databinding.ActivitySpannableBinding

class SpannableActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySpannableBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



    }
}