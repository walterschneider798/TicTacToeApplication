package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentplayer = "x"
    private var gamestate = "playing"
    private lateinit var allFields: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //goback from Activity
        val actionBar = supportActionBar
        actionBar!!.title = "TictacToe"
        actionBar.setDisplayHomeAsUpEnabled(true)


        allFields = arrayOf(f11, f2, f3, f4, f5, f6, f7, f8, f9)

        for(field in allFields){
            field.setOnClickListener {
                onfieldclick(it as TextView)
            }
        }
    }
    private fun onfieldclick(field : TextView){
        if (gamestate != "playing"){
            resetGame()
            return
        }

        if(field.text == "") {
            field.text = currentplayer

            if (checkwin()){
                Titelid.text = "Spieler $currentplayer hat gewonnen"
                gamestate = "won"
            } else if (allFields.all { it.text != "" }){
                gamestate = "brace"
                Titelid.text = "Unentschieden!"
            }

            else {
                currentplayer = if (currentplayer == "x") "o" else "x"
                Titelid.text = "Spieler $currentplayer ist an der Reihe"
            }
        }
    }

    private fun resetGame(){
        currentplayer = "x";
        Titelid.text = "Spieler X ist an der Reihe"
        gamestate = "playing"
        for (field in allFields){
            field.text = ""

        }

    }

    /**private fun checkbrace(): Boolean{
        return (f11.text != ""  && f2.text != ""  && f3.text != ""  && f4.text != ""  && f5.text != ""  && f6.text != ""  && f7.text != ""  && f8.text != ""  && f9.text != ""  )

    }**/

    private fun checkwin(): Boolean{
                //horizontale überprüfung
        return  (f11.text == f2.text && f2.text == f3.text && f11.text != "") ||
                (f4.text == f5.text && f5.text == f6.text && f4.text != "") ||
                (f7.text == f8.text && f8.text == f9.text && f7.text != "") ||
                //vertikale üperfüfung
                (f11.text == f4.text && f4.text == f7.text && f11.text != "") ||
                (f2.text == f5.text && f5.text == f8.text && f2.text != "") ||
                (f3.text == f6.text && f6.text == f9.text && f3.text != "") ||
                //diagonale Überprüfung
                (f11.text == f5.text && f5.text == f9.text && f11.text != "") ||
                (f3.text == f5.text && f5.text == f7.text && f3.text != "")

    }

}