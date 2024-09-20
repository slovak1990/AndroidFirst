package com.example.androidfirst

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidfirst.ui.theme.AndroidFirstTheme

class MainActivity : ComponentActivity() {
    private val myViewModel: MyViewModel by viewModels()
    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText
    private lateinit var sumResultTextView: TextView
    private lateinit var calcSumButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        number1EditText = findViewById(R.id.number1EditText)
        number2EditText = findViewById(R.id.number2EditText)
        sumResultTextView = findViewById(R.id.sumResultTextView)
        calcSumButton = findViewById(R.id.calcSumButton)

        calcSumButton.setOnClickListener {
            val num1 = number1EditText.text.toString().toIntOrNull() ?: 0
            val num2 = number2EditText.text.toString().toIntOrNull() ?: 0
            myViewModel.setNum1(num1)
            myViewModel.setNum2(num2)
            myViewModel.calculateSum()
        }

        myViewModel.result.observe(this) { result ->
            sumResultTextView.text = result
        }
//        setContent {
//            AndroidFirstTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidFirstTheme {
        Greeting("Android")
    }
}