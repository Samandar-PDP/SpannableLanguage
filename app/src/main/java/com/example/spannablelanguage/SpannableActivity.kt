package com.example.spannablelanguage

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.BackgroundColorSpan
import android.text.style.BulletSpan
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import androidx.core.text.set
import com.example.spannablelanguage.databinding.ActivitySpannableBinding

class SpannableActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySpannableBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1

        val spannableString = SpannableString("You will learn spannable string in here!")
        spannableString.setSpan(
            ForegroundColorSpan(Color.RED),
            4,
            8,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )
        binding.textView.text = spannableString
        binding.textView.textSize = 22f

        // 2

        val spannableStringBuilder = SpannableStringBuilder("Android")
        spannableStringBuilder.insert(1, "4")
        spannableStringBuilder.insert(4, "6")
        binding.textView2.text = spannableStringBuilder
        binding.textView2.textSize = 20f

        // 3

        val spannable = SpannableString("Java,Kotlin")
        spannable.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            5,
            spannable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.textView3.text = spannable
        binding.textView3.textSize = 18f

        // 4

        val spannable4 = SpannableString("You can start learning Android from Digital City")
        spannable4.setSpan(
            BackgroundColorSpan(Color.BLUE),
            36,
            spannable4.length,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        binding.textView4.text = spannable4

        // 5

        val spannable5 = SpannableString("You can start learning Android from MindOrks")
        spannable5.setSpan(
            RelativeSizeSpan(2f),
            36, // start
            44, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        binding.textView5.text = spannable5

        // 6
        binding.textView6.text = convertList(listOf("Samsung", "RedMi", "RealMe", "LG", "Alcatel"))
        binding.textView6.textSize = 20f
    }
    private fun convertList(stringList: List<String>): CharSequence {
        val spannableStringBuilder = SpannableStringBuilder("Android mobile phones\n")
        stringList.forEachIndexed { index, text ->
            val line: CharSequence = text + if (index < stringList.size -1) "\n" else ""
            val spannableString = SpannableString(line)
            spannableString.setSpan(
                BulletSpan(25, Color.RED),
                0,
                spannableString.length,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE
            )
            spannableStringBuilder.append(spannableString)
        }
        return spannableStringBuilder
    }
}