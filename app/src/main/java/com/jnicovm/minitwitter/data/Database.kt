package com.jnicovm.minitwitter.data

import com.jnicovm.minitwitter.dao.AccountDao

class Database private constructor() {

    var userDao = AccountDao()
        private set

    companion object{
        @Volatile private var instance: Database? = null

        fun getInstance()=
            instance ?: synchronized(this){
                instance
                    ?: Database()
                        .also { instance = it }
            }
    }
}