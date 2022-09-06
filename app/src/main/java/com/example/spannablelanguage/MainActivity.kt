package com.example.spannablelanguage

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.spannablelanguage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val localHelper = LocalHelper(this)
        val sharedPref = MySharedPref(this)
        localHelper.setLanguage(sharedPref.getLanguage())
        supportActionBar?.title = this.resources.getString(R.string.app_name)
        binding.textView.text = this.resources.getString(R.string.we_are)
        binding.btn.text = this.resources.getString(R.string.set_lan)
        binding.btnNext.text = this.resources.getString(R.string.go)

        binding.btn.setOnClickListener {
            val languageList = arrayOf("English", "Russian", "Korean")
            AlertDialog.Builder(this).apply {
                setTitle(getString(R.string.change_language))
                setPositiveButton("Ok", null)
                setSingleChoiceItems(languageList, -1) { _: DialogInterface?, lan: Int ->
                    intent()
                    when (lan) {
                        0 -> localHelper.setLanguage("en")
                        1 -> localHelper.setLanguage("ru")
                        2 -> {
                            localHelper.setLanguage("ko")
                        }
                    }
                }
            }.create().show()
        }
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, SpannableActivity::class.java))
        }
    }
    private fun intent() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}