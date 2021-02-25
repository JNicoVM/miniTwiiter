package com.jnicovm.minitwitter.retrofit

import android.content.Context
import com.jnicovm.minitwitter.dao.AccountDao

class MiniTwitterClient (){

    companion object{
        @Volatile private var instance: MiniTwitterClient? = null

        fun getInstance(accountDao: AccountDao)=
            instance
                ?: synchronized(this){
                    instance
                        ?: MiniTwitterClient()
                            .also { instance = it }
                }
    }
}