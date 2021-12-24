package com.example.chaldeannumerology

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View

import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.stream.IntStream.range


class MainActivity() : AppCompatActivity() {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    var outputText = ""
    var count = 0

    @RequiresApi(Build.VERSION_CODES.N)
    fun calculteChaldeannumerology(view: View) {
        outputText = ""
        count = 0
        val data =
            intArrayOf(1, 2, 3, 4, 5, 8, 3, 5, 1, 1, 2, 3, 4, 5, 7, 8, 1, 2, 3, 4, 6, 6, 6, 5, 1, 7)
        val nameTextView = findViewById<TextView>(R.id.namePlainText) as TextView
        var name = nameTextView.text
        name = name.replace("\\s".toRegex(), "");
        name = name.toUpperCase();
        val value = IntArray(name.length)
        for (item in name.toString()) {
            print("$item ");
            outputText += item + " "
        }
        print("\n")
        outputText += "\n"
        for (i in range(0, name.length)) {
            val temp = data[name[i].code - 65]
            value[i] = (temp);
            print(temp.toString() + " ")
            outputText += temp.toString() + " "
        }
        print("\n");
        outputText += "\n"
        var cn = stepByStep(value)

        val outputTextView = findViewById<TextView>(R.id.outputTextView) as TextView
        val valueTextView = findViewById<TextView>(R.id.valueTextView) as TextView
        outputTextView.setText(outputText)
        valueTextView.setText("Head of Chaldean Numerology Value is " + value.sum().toString() + "\nTail of Chaldean Numerology Value is " + cn[0].toString())
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun stepByStep(arr:IntArray): IntArray {
        for(j in range(0,++count)) {
            print(" ")
            outputText += " "
        }
        var arr1 = IntArray(arr.size - 1)
        for(i in range(0, arr.size-1)){
            arr1[i] = add(arr[i], arr[i+1])
            print(arr1[i].toString() + " ");
            outputText += arr1[i].toString() + " "
        }
        print("\n")
        outputText += "\n"
        if(arr1.size!=1)
            arr1 = stepByStep(arr1);

        return arr1
    }

    private fun add(a:Int, b:Int): Int {
        var `val` = a + b
        if(`val`>9)
            `val` = add(1, `val` % 10)
        return `val`
    }
}