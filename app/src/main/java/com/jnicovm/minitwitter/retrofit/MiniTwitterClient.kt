package com.jnicovm.minitwitter.retrofit

import com.jnicovm.minitwitter.dao.AccountDao
import com.jnicovm.minitwitter.repository.AccountRepository

public class MiniTwitterClient{
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