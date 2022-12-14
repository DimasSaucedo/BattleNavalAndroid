package bds.posicion

import android.provider.BaseColumns

class DBContractPos {
    class PosBarco1: BaseColumns{
        companion object{
            val TABLE_NAME = "barco1"
            val COLUMN_JUGX = "jugx1"
            val COLUMN_JUGY = "jugy1"
            val COLUMN_CONX = "conx"
            val COLUMN_CONY = "cony"
            val COLUMN_PUNCON = "puncon"
            val COLUMN_PUNJUG = "punjug"
        }
    }

    class PosBarco2: BaseColumns{
        companion object{
            val TABLE_NAME = "barco2"
            val COLUMN_JUGX = "jugx1"
            val COLUMN_JUGY = "jugy1"
            val COLUMN_CONX = "conx"
            val COLUMN_CONY = "cony"
            val COLUMN_PUNCON = "puncon"
            val COLUMN_PUNJUG = "punjug"
        }
    }
    class PosBarco3: BaseColumns{
        companion object{
            val TABLE_NAME = "barco3"
            val COLUMN_JUGX = "jugx1"
            val COLUMN_JUGY = "jugy1"
            val COLUMN_CONX = "conx"
            val COLUMN_CONY = "cony"
            val COLUMN_PUNCON = "puncon"
            val COLUMN_PUNJUG = "punjug"
        }
    }
    class PosBarco4: BaseColumns{
        companion object{
            val TABLE_NAME = "barco4"
            val COLUMN_JUGX = "jugx1"
            val COLUMN_JUGY = "jugy1"
            val COLUMN_CONX = "conx"
            val COLUMN_CONY = "cony"
            val COLUMN_PUNCON = "puncon"
            val COLUMN_PUNJUG = "punjug"
        }
    }
    class PosBarco5: BaseColumns{
        companion object{
            val TABLE_NAME = "barco5"
            val COLUMN_JUGX = "jugx1"
            val COLUMN_JUGY = "jugy1"
            val COLUMN_CONX = "conx"
            val COLUMN_CONY = "cony"
            val COLUMN_PUNCON = "puncon"
            val COLUMN_PUNJUG = "punjug"
        }
    }

    class puntosJug: BaseColumns{
        companion object{
            val TABLE_NAME = "puntosJug"
            val COLUMN_PUNTO = "puntoJ"
        }
    }

    class puntosCon: BaseColumns{
        companion object{
            val TABLE_NAME = "puntosCon"
            val COLUMN_PUNTO = "puntoC"
        }
    }

    class toqueJugador: BaseColumns{
        companion object{
            val TABLE_NAME = "ToquesJug"
            val COLUMN_TOQUEX = "toqueX"
            val COLUMN_TOQUEY = "toqueY"
        }
    }

    class toqueConsola: BaseColumns{
        companion object{
            val TABLE_NAME = "ToquesCon"
            val COLUMN_TOQUEX = "toqueX"
            val COLUMN_TOQUEY = "toqueY"
        }
    }
}