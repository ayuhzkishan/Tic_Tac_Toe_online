package com.example.tictactoe

data class GameModel(
    var gameId: String = "-1",
    var filledPos: MutableList<String> = mutableListOf("", "", "", "", "", "", "", "", ""),
    var winner: String = "",
    var gamestatus: GameStatus = GameStatus.CREATED,
    var currentplayer: String = arrayOf("X", "O").random()
)


enum class GameStatus{
    CREATED,
    JOINED,
    INPROGRESS,
    FINISHED
}