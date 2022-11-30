package com.example.battleship.clasesBD

import android.provider.BaseColumns

class DBContract {
    class UserEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "jugadores"
            val COLUMN_NAME = "name"
            val COLUMN_PWD = "pass"
            val COLUMN_AGE = "age"
        }
    }
}