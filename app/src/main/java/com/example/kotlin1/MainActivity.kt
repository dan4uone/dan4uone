package com.example.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin1.Constant.KEI_ONE
import com.example.kotlin1.Constant.KEI_TWO
import com.example.kotlin1.databinding.ActivityMainBinding
import com.example.kotlin1.extentions.showToast


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var register: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.apply {
            btnNext.setOnClickListener() {
                if (editText.text.toString().isEmpty()) {
                    showToast("Empty")
                } else {
                    Intent(this@MainActivity, SecondActivity::class.java).apply {
                        putExtra(KEI_ONE, editText.text.toString())
                        register.launch(this)
                    }
                }
            }
            register = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result ->
                editText.setText(result.data?.getStringExtra(KEI_TWO))

            }
        }
    }
}

