package com.example.ex00

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ex00.ui.theme.Ex00Theme

class MainActivity : ComponentActivity() {
//    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
//    }
    fun clickz(): Unit {
        Log.d(">>", "onClicked")
        Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_LONG).show()
        val textView = findViewById<TextView>(R.id.textView)
        textView.setText("you clicked")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // xml로 액티비티를 생성할 때 객체 R에 자동 등록
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        /*button.setOnClickListener(
            View.OnClickListener(
                fun(it: View) {
                    clickz()
                }
            )
        )*/

        // SAM(single abstract method) 인터페이스를 간단하게 사용 위한 기법
        /*button.setOnClickListener {
            clickz()
        }*/

        button.setOnClickListener(MyEventHandler())
        textView.setOnClickListener(MyEventHandler())



        // setContent는 순수하게 자바 소스코드로 액티비티를 생성할 때
        /*setContent {
            Ex00Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }*/
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ex00Theme {
        Greeting("Android")
    }
}

class MyEventHandler : View.OnClickListener{
    override fun onClick(v: View?) {
        /*if (v?.id == R.id.button) {
            MainActivity().clickz()
        } else if(v?.id == R.id.textView) {
            MainActivity().clickz()
        }*/
        when (v?.id){
            R.id.button -> MainActivity().clickz()
            R.id.textView -> MainActivity().clickz()
        }
    }
}