package com.pratthamarora.digitrecognizer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var mClassifier: Classifier? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            mClassifier = Classifier(this)
        } catch (e: IOException) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        }

        btn_detect.setOnClickListener {
            val bitmap = fpv_paint.exportToBitmap(Classifier.IMG_WIDTH, Classifier.IMG_HEIGHT)
            val res = mClassifier!!.classify(bitmap)
            probability.text = "Probability: ${res.probability} "
            prediction.text = "Prediction: ${res.number} "
            timecost.text = "TimeCost: ${res.timeCost} "
        }
        btn_clear.setOnClickListener {
            fpv_paint.clear()
            prediction.text = ""
            probability.text = ""
            timecost.text = ""
        }
    }
}
