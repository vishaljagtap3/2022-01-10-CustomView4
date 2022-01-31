package `in`.bitcode.customview4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var graphView : GraphView
    lateinit  var btnRefresh : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        graphView = findViewById(R.id.graphView)
        graphView.values = arrayOf(50, 80, 60, 90)

        btnRefresh = findViewById(R.id.btnRefresh)
        btnRefresh.setOnClickListener {
            var random = java.util.Random()
            var newArray = Array<Int>(4, { i -> Math.abs(random.nextInt()) % 101});

            graphView.values = newArray
        }
    }
}