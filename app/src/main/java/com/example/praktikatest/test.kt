package com.example.praktikatest

import android.R.array
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Random



class test : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private  lateinit var Answer :TextView
    data class Quest(val que:String,val answ:Boolean)
    private var index=0
    val map = mapOf("Первый признак равенства треугольников-по 2 сторонам и углу между ними" to "правильно", "Второй признак равенства треугольников-по 3 сторонам" to "Не Правильно", "Третий признак равенства треугольников-по 3 сторонам" to "Правильно")
    val key= arrayOf("Первый признак равенства треугольников-по 2 сторонам и углу между ними","Второй признак равенства треугольников-по 3 сторонам","Третий признак равенства треугольников-по 3 сторонам")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val random = Random()
        val randomIndex = random.nextInt(map.size)
        Answer = findViewById(R.id.answ)
        trueButton = findViewById(R.id.true_but)
        falseButton = findViewById(R.id.false_button)
        Answer.setText(key[randomIndex])



        trueButton.setOnClickListener {

            checkAnswer(true)


        }

        falseButton.setOnClickListener {

        /*    val toast = Toast.makeText(this, R.string.incorrect_toast,Toast.LENGTH_SHORT )
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()*/
            checkAnswer(false)
        }
        initializationQuestAndAnswer()
        setQuestion()
    }
    private lateinit var lis:List<Quest>
    private fun initializationQuestAndAnswer(){
        lis= listOf(
            Quest(getString((R.string.q1)),answ = true),
        Quest(getString((R.string.q2)),answ = false),
        Quest(getString((R.string.q3)),answ = true),
        Quest(getString((R.string.q4)),answ = true),
        Quest(getString((R.string.q5)),answ = true)
        )
    }

    private fun setQuestion(){
        val curr=lis[index]
        Answer.text=curr.que
    }

    private fun checkAnswer(userAnswer:Boolean){
        val curr=lis[index]
        if(userAnswer==curr.answ) {
            var toast=Toast.makeText(this,"Верно",Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP,0,0)
            toast.show()
        }
        else{
            var toast=Toast.makeText(this,"Не верно",Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP,,0)
            toast.show()
        }
        index++
        if(index<lis.size) setQuestion()
        else {
            Toast.makeText(this,"end",Toast.LENGTH_SHORT)
            application.onTerminate()
        }

    }



}