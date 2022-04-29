package com.example.kotlin1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin1.Constant.KEI_ONE
import com.example.kotlin1.Constant.KEI_TWO
import com.example.kotlin1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textResult.setText(intent.getStringExtra(KEI_ONE))

        binding.btnTwo.setOnClickListener {
            setResult(
                RESULT_OK, Intent().putExtra(KEI_TWO, binding.textResult.text.toString())
            )
            finish()
        }
    }
}