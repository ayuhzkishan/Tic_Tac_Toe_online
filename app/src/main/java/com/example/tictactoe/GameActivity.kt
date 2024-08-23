package com.example.tictactoe

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictactoe.databinding.ActivityGameBinding
import com.example.tictactoe.GameStatus


class GameActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var binding: ActivityGameBinding

    private var gameModel: GameModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button0.setOnClickListener(this)
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)

        binding.startGameButton.setOnClickListener {
            startGame()
        }

        Gamedata().gameModel.observe(this) {
            gameModel = it
            setUI()
        }

    }


     fun setUI() {
        gameModel?.apply {
            // Update button texts based on filled positions
            binding.button0.text = filledPos[0]
            binding.button1.text = filledPos[1]
            binding.button2.text = filledPos[2]
            binding.button3.text = filledPos[3]
            binding.button4.text = filledPos[4]
            binding.button5.text = filledPos[5]
            binding.button6.text = filledPos[6]
            binding.button7.text = filledPos[7]
            binding.button8.text = filledPos[8]



            binding.gameStatusText.text =
                when (gamestatus) {
                    GameStatus.CREATED -> {

                        "Game ID :" + gameId
                    }

                    GameStatus.JOINED -> {
                        "Click on start game"
                    }

                    GameStatus.INPROGRESS -> {

                        currentplayer + " turn"
                    }

                    GameStatus.FINISHED -> {
                        if (winner.isNotEmpty()) winner + " Won"
                        else "DRAW"
                    }
                }

        }
    }


    fun startGame() {

    }

    override fun onClick(v: View?) {

    }

}

