package com.example.tictactoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Gamedata {
   private var _gameModel : MutableLiveData<GameModel> = MutableLiveData()
   var gameModel : LiveData<GameModel> = _gameModel

    fun saveGameModel(model : GameModel){
        _gameModel.postValue(model)
    }
}
