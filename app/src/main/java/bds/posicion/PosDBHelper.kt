package bds.posicion

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper


class PosDBHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,
null,DATABASE_VERSION) {

    var listaPos = mutableListOf<PosModel>()

    override fun onCreate(db: SQLiteDatabase) {
        //db.execSQL(SQL_CREATE_ENTRIES)

        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.PosBarco1.TABLE_NAME + "(" +
                        DBContractPos.PosBarco1.COLUMN_JUGX + " TEXT," +
                        DBContractPos.PosBarco1.COLUMN_JUGY + " TEXT," +
                        DBContractPos.PosBarco1.COLUMN_PUNJUG + " TEXT," +
                        DBContractPos.PosBarco1.COLUMN_CONX + " TEXT," +
                        DBContractPos.PosBarco1.COLUMN_CONY + " TEXT," +
                        DBContractPos.PosBarco1.COLUMN_PUNCON + " TEXT)"
            )
        )
        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.PosBarco2.TABLE_NAME + "(" +
                        DBContractPos.PosBarco2.COLUMN_JUGX + " TEXT," +
                        DBContractPos.PosBarco2.COLUMN_JUGY + " TEXT," +
                        DBContractPos.PosBarco2.COLUMN_PUNJUG + " TEXT," +
                        DBContractPos.PosBarco2.COLUMN_CONX + " TEXT," +
                        DBContractPos.PosBarco2.COLUMN_CONY + " TEXT," +
                        DBContractPos.PosBarco2.COLUMN_PUNCON + " TEXT)"
            )
        )
        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.PosBarco3.TABLE_NAME + "(" +
                        DBContractPos.PosBarco3.COLUMN_JUGX + " TEXT," +
                        DBContractPos.PosBarco3.COLUMN_JUGY + " TEXT," +
                        DBContractPos.PosBarco3.COLUMN_PUNJUG + " TEXT," +
                        DBContractPos.PosBarco3.COLUMN_CONX + " TEXT," +
                        DBContractPos.PosBarco3.COLUMN_CONY + " TEXT," +
                        DBContractPos.PosBarco3.COLUMN_PUNCON + " TEXT)"
            )
        )
        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.PosBarco4.TABLE_NAME + "(" +
                        DBContractPos.PosBarco4.COLUMN_JUGX + " TEXT," +
                        DBContractPos.PosBarco4.COLUMN_JUGY + " TEXT," +
                        DBContractPos.PosBarco4.COLUMN_PUNJUG + " TEXT," +
                        DBContractPos.PosBarco4.COLUMN_CONX + " TEXT," +
                        DBContractPos.PosBarco4.COLUMN_CONY + " TEXT," +
                        DBContractPos.PosBarco4.COLUMN_PUNCON + " TEXT)"
            )
        )
        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.PosBarco5.TABLE_NAME + "(" +
                        DBContractPos.PosBarco5.COLUMN_JUGX + " TEXT," +
                        DBContractPos.PosBarco5.COLUMN_JUGY + " TEXT," +
                        DBContractPos.PosBarco5.COLUMN_PUNJUG + " TEXT," +
                        DBContractPos.PosBarco5.COLUMN_CONX + " TEXT," +
                        DBContractPos.PosBarco5.COLUMN_CONY + " TEXT," +
                        DBContractPos.PosBarco5.COLUMN_PUNCON + " TEXT)"
            )
        )

        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.puntosJug.TABLE_NAME + "(" +
                        DBContractPos.puntosJug.COLUMN_PUNTO + " TEXT)"
            )
        )

        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.puntosCon.TABLE_NAME + "(" +
                        DBContractPos.puntosCon.COLUMN_PUNTO + " TEXT)"
            )
        )

        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.toqueJugador.TABLE_NAME + "(" +
                        DBContractPos.toqueJugador.COLUMN_TOQUEX + " TEXT," +
                        DBContractPos.toqueJugador.COLUMN_TOQUEY + " TEXT)"
            )
        )

        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.toqueConsola.TABLE_NAME + "(" +
                        DBContractPos.toqueConsola.COLUMN_TOQUEX + " TEXT," +
                        DBContractPos.toqueConsola.COLUMN_TOQUEY + " TEXT)"
            )
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL(String.format("DROP TABLE IF EXISTS " + DBContractPos.PosBarco1.TABLE_NAME + ""))
        db.execSQL(String.format("DROP TABLE IF EXISTS " + DBContractPos.PosBarco2.TABLE_NAME + ""))
        db.execSQL(String.format("DROP TABLE IF EXISTS " + DBContractPos.PosBarco3.TABLE_NAME + ""))
        db.execSQL(String.format("DROP TABLE IF EXISTS " + DBContractPos.PosBarco4.TABLE_NAME + ""))
        db.execSQL(String.format("DROP TABLE IF EXISTS " + DBContractPos.PosBarco5.TABLE_NAME + ""))
        db.execSQL(String.format("DROP TABLE IF EXISTS " + DBContractPos.puntosCon.TABLE_NAME + ""))
        db.execSQL(String.format("DROP TABLE IF EXISTS " + DBContractPos.puntosJug.TABLE_NAME + ""))
        db.execSQL(String.format("DROP TABLE IF EXISTS " + DBContractPos.toqueConsola.TABLE_NAME + ""))
        db.execSQL(String.format("DROP TABLE IF EXISTS " + DBContractPos.toqueJugador.TABLE_NAME + ""))
        onCreate(db)
    }

    fun crearTablas(){
        val db = writableDatabase
        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.PosBarco1.TABLE_NAME + "(" +
                        DBContractPos.PosBarco1.COLUMN_JUGX + " TEXT," +
                        DBContractPos.PosBarco1.COLUMN_JUGY + " TEXT," +
                        DBContractPos.PosBarco1.COLUMN_PUNJUG + " TEXT," +
                        DBContractPos.PosBarco1.COLUMN_CONX + " TEXT," +
                        DBContractPos.PosBarco1.COLUMN_CONY + " TEXT," +
                        DBContractPos.PosBarco1.COLUMN_PUNCON + " TEXT)"
            )
        )
        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.PosBarco2.TABLE_NAME + "(" +
                        DBContractPos.PosBarco2.COLUMN_JUGX + " TEXT," +
                        DBContractPos.PosBarco2.COLUMN_JUGY + " TEXT," +
                        DBContractPos.PosBarco2.COLUMN_PUNJUG + " TEXT," +
                        DBContractPos.PosBarco2.COLUMN_CONX + " TEXT," +
                        DBContractPos.PosBarco2.COLUMN_CONY + " TEXT," +
                        DBContractPos.PosBarco2.COLUMN_PUNCON + " TEXT)"
            )
        )
        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.PosBarco3.TABLE_NAME + "(" +
                        DBContractPos.PosBarco3.COLUMN_JUGX + " TEXT," +
                        DBContractPos.PosBarco3.COLUMN_JUGY + " TEXT," +
                        DBContractPos.PosBarco3.COLUMN_PUNJUG + " TEXT," +
                        DBContractPos.PosBarco3.COLUMN_CONX + " TEXT," +
                        DBContractPos.PosBarco3.COLUMN_CONY + " TEXT," +
                        DBContractPos.PosBarco3.COLUMN_PUNCON + " TEXT)"
            )
        )
        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.PosBarco4.TABLE_NAME + "(" +
                        DBContractPos.PosBarco4.COLUMN_JUGX + " TEXT," +
                        DBContractPos.PosBarco4.COLUMN_JUGY + " TEXT," +
                        DBContractPos.PosBarco4.COLUMN_PUNJUG + " TEXT," +
                        DBContractPos.PosBarco4.COLUMN_CONX + " TEXT," +
                        DBContractPos.PosBarco4.COLUMN_CONY + " TEXT," +
                        DBContractPos.PosBarco4.COLUMN_PUNCON + " TEXT)"
            )
        )
        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.PosBarco5.TABLE_NAME + "(" +
                        DBContractPos.PosBarco5.COLUMN_JUGX + " TEXT," +
                        DBContractPos.PosBarco5.COLUMN_JUGY + " TEXT," +
                        DBContractPos.PosBarco5.COLUMN_PUNJUG + " TEXT," +
                        DBContractPos.PosBarco5.COLUMN_CONX + " TEXT," +
                        DBContractPos.PosBarco5.COLUMN_CONY + " TEXT," +
                        DBContractPos.PosBarco5.COLUMN_PUNCON + " TEXT)"
            )
        )

        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.puntosJug.TABLE_NAME + "(" +
                        DBContractPos.puntosJug.COLUMN_PUNTO + " TEXT)"
            )
        )

        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.puntosCon.TABLE_NAME + "(" +
                        DBContractPos.puntosCon.COLUMN_PUNTO + " TEXT)"
            )
        )

        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.toqueJugador.TABLE_NAME + "(" +
                        DBContractPos.toqueJugador.COLUMN_TOQUEX + " TEXT," +
                        DBContractPos.toqueJugador.COLUMN_TOQUEY + " TEXT)"
            )
        )

        db.execSQL(
            String.format(
                "CREATE TABLE " + DBContractPos.toqueConsola.TABLE_NAME + "(" +
                        DBContractPos.toqueConsola.COLUMN_TOQUEX + " TEXT," +
                        DBContractPos.toqueConsola.COLUMN_TOQUEY + " TEXT)"
            )
        )
    }

    fun borrarToques(){
        val db = writableDatabase
        db.execSQL(String.format("DELETE FROM " + DBContractPos.toqueJugador.TABLE_NAME + ""))
        db.execSQL(String.format("DELETE FROM " + DBContractPos.toqueConsola.TABLE_NAME + ""))
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertBarco(pos: PosModel): Boolean {
        //Obtenemos la base de datos para escribir
        val db = writableDatabase
        // Creamos un ContentValues, para asignar los valores a insertar
        val values = ContentValues()

        try {
            when (pos.noBarco) {
                1 -> {
                    values.put(DBContractPos.PosBarco1.COLUMN_JUGX, pos.jugX)
                    values.put(DBContractPos.PosBarco1.COLUMN_JUGY, pos.jugY)
                    values.put(DBContractPos.PosBarco1.COLUMN_PUNJUG, pos.punJug)
                    values.put(DBContractPos.PosBarco1.COLUMN_CONX, pos.conX1)
                    values.put(DBContractPos.PosBarco1.COLUMN_CONY, pos.conY1)
                    values.put(DBContractPos.PosBarco1.COLUMN_PUNCON, pos.punCon)
                    //Insertamos el nuevo registro
                    val newRowId = db.insert(DBContractPos.PosBarco1.TABLE_NAME, null, values)
                    return true
                }
                2 -> {
                    values.put(DBContractPos.PosBarco2.COLUMN_JUGX, pos.jugX)
                    values.put(DBContractPos.PosBarco2.COLUMN_JUGY, pos.jugY)
                    values.put(DBContractPos.PosBarco2.COLUMN_PUNJUG, pos.punJug)
                    values.put(DBContractPos.PosBarco2.COLUMN_CONX, pos.conX1)
                    values.put(DBContractPos.PosBarco2.COLUMN_CONY, pos.conY1)
                    values.put(DBContractPos.PosBarco2.COLUMN_PUNCON, pos.punCon)
                    //Insertamos el nuevo registro
                    val newRowId = db.insert(DBContractPos.PosBarco2.TABLE_NAME, null, values)
                    return true
                }
                3 -> {
                    values.put(DBContractPos.PosBarco3.COLUMN_JUGX, pos.jugX)
                    values.put(DBContractPos.PosBarco3.COLUMN_JUGY, pos.jugY)
                    values.put(DBContractPos.PosBarco3.COLUMN_PUNJUG, pos.punJug)
                    values.put(DBContractPos.PosBarco3.COLUMN_CONX, pos.conX1)
                    values.put(DBContractPos.PosBarco3.COLUMN_CONY, pos.conY1)
                    values.put(DBContractPos.PosBarco3.COLUMN_PUNCON, pos.punCon)
                    //Insertamos el nuevo registro
                    val newRowId = db.insert(DBContractPos.PosBarco3.TABLE_NAME, null, values)
                    return true
                }
                4 -> {
                    values.put(DBContractPos.PosBarco4.COLUMN_JUGX, pos.jugX)
                    values.put(DBContractPos.PosBarco4.COLUMN_JUGY, pos.jugY)
                    values.put(DBContractPos.PosBarco4.COLUMN_PUNJUG, pos.punJug)
                    values.put(DBContractPos.PosBarco4.COLUMN_CONX, pos.conX1)
                    values.put(DBContractPos.PosBarco4.COLUMN_CONY, pos.conY1)
                    values.put(DBContractPos.PosBarco4.COLUMN_PUNCON, pos.punCon)
                    //Insertamos el nuevo registro
                    val newRowId = db.insert(DBContractPos.PosBarco4.TABLE_NAME, null, values)
                    return true
                }
                5 -> {
                    values.put(DBContractPos.PosBarco5.COLUMN_JUGX, pos.jugX)
                    values.put(DBContractPos.PosBarco5.COLUMN_JUGY, pos.jugY)
                    values.put(DBContractPos.PosBarco5.COLUMN_PUNJUG, pos.punJug)
                    values.put(DBContractPos.PosBarco5.COLUMN_CONX, pos.conX1)
                    values.put(DBContractPos.PosBarco5.COLUMN_CONY, pos.conY1)
                    values.put(DBContractPos.PosBarco5.COLUMN_PUNCON, pos.punCon)
                    //Insertamos el nuevo registro
                    val newRowId = db.insert(DBContractPos.PosBarco5.TABLE_NAME, null, values)
                    return true
                }
            }
        } catch (e: SQLiteException) {
            println(e)
        }
        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun insertPuntoJugador(punto: String): Boolean {
        val db = writableDatabase
        // Creamos un ContentValues, para asignar los valores a insertar
        val values = ContentValues()

        values.put(DBContractPos.puntosJug.COLUMN_PUNTO, punto)
        val newRowId = db.insert(DBContractPos.puntosJug.TABLE_NAME, null, values)
        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun insertPuntoConsola(punto: String): Boolean {
        val db = writableDatabase
        // Creamos un ContentValues, para asignar los valores a insertar
        val values = ContentValues()

        values.put(DBContractPos.puntosCon.COLUMN_PUNTO, punto)
        val newRowId = db.insert(DBContractPos.puntosCon.TABLE_NAME, null, values)
        return true
    }


    @Throws(SQLiteConstraintException::class)
    fun updateJug(jugX: String, jugY: String, noBarco: Int): Boolean {
        //Obtenemos la base de datos para escribir
        val db = writableDatabase
        // Creamos el query para buscar llave a modificar
        val registro = ContentValues()

        try {
            when (noBarco) {
                1 -> {
                    registro.put(DBContractPos.PosBarco1.COLUMN_JUGX, jugX)
                    registro.put(DBContractPos.PosBarco1.COLUMN_JUGY, jugY)

                    // Modificamos el registro
                    db.update(
                        DBContractPos.PosBarco1.TABLE_NAME, registro,
                        null, null
                    )
                    db.close()
                }
                2 -> {
                    registro.put(DBContractPos.PosBarco2.COLUMN_JUGX, jugX)
                    registro.put(DBContractPos.PosBarco2.COLUMN_JUGY, jugY)

                    // Modificamos el registro
                    db.update(
                        DBContractPos.PosBarco2.TABLE_NAME, registro,
                        null, null
                    )
                    db.close()
                }
                3 -> {
                    registro.put(DBContractPos.PosBarco3.COLUMN_JUGX, jugX)
                    registro.put(DBContractPos.PosBarco3.COLUMN_JUGY, jugY)

                    // Modificamos el registro
                    db.update(
                        DBContractPos.PosBarco3.TABLE_NAME, registro,
                        null, null
                    )
                    db.close()
                }
                4 -> {
                    registro.put(DBContractPos.PosBarco4.COLUMN_JUGX, jugX)
                    registro.put(DBContractPos.PosBarco4.COLUMN_JUGY, jugY)

                    // Modificamos el registro
                    db.update(
                        DBContractPos.PosBarco4.TABLE_NAME, registro,
                        null, null
                    )
                    db.close()
                }
                5 -> {
                    registro.put(DBContractPos.PosBarco5.COLUMN_JUGX, jugX)
                    registro.put(DBContractPos.PosBarco5.COLUMN_JUGY, jugY)

                    // Modificamos el registro
                    db.update(
                        DBContractPos.PosBarco5.TABLE_NAME, registro,
                        null, null
                    )
                    db.close()
                }
            }
        } catch (e: SQLiteException) {
            println(e)

            return true
        }
        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun updatePuntosJugador(puntos: String): Boolean {
        //Obtenemos la base de datos para escribir
        val db = writableDatabase
        // Creamos el query para buscar llave a modificar
        val registro = ContentValues()

        registro.put(DBContractPos.puntosJug.COLUMN_PUNTO, puntos)

        // Modificamos el registro
        db.update(
            DBContractPos.puntosJug.TABLE_NAME, registro,
            null, null
        )
        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun updatePuntosConsola(puntos: String) {
        //Obtenemos la base de datos para escribir
        val db = writableDatabase
        // Creamos el query para buscar llave a modificar
        val registro = ContentValues()

        //println("bd:" + puntos)
        registro.put(DBContractPos.puntosCon.COLUMN_PUNTO, puntos)

        // Modificamos el registro
        try {
            db.update(
                DBContractPos.puntosCon.TABLE_NAME, registro,
                null, null
            )
        } catch (e: Exception) {
            println(e)
        }
    }


    @Throws(SQLiteConstraintException::class)
    fun updateCon(conX: String, conY: String, noBarco: Int): Boolean {
        //Obtenemos la base de datos para escribir
        val db = writableDatabase
        // Creamos el query para buscar llave a modificar
        val registro = ContentValues()
        when (noBarco) {
            1 -> {
                registro.put(DBContractPos.PosBarco1.COLUMN_CONX, conX)
                registro.put(DBContractPos.PosBarco1.COLUMN_CONY, conY)

                // Modificamos el registro
                db.update(
                    DBContractPos.PosBarco1.TABLE_NAME, registro,
                    null, null
                )
                db.close()
            }
            2 -> {
                registro.put(DBContractPos.PosBarco2.COLUMN_CONX, conX)
                registro.put(DBContractPos.PosBarco2.COLUMN_CONY, conY)

                // Modificamos el registro
                db.update(
                    DBContractPos.PosBarco2.TABLE_NAME, registro,
                    null, null
                )
                db.close()
            }
            3 -> {
                registro.put(DBContractPos.PosBarco3.COLUMN_CONX, conX)
                registro.put(DBContractPos.PosBarco3.COLUMN_CONY, conY)

                // Modificamos el registro
                db.update(
                    DBContractPos.PosBarco3.TABLE_NAME, registro,
                    null, null
                )
                db.close()
            }
            4 -> {
                registro.put(DBContractPos.PosBarco4.COLUMN_CONX, conX)
                registro.put(DBContractPos.PosBarco4.COLUMN_CONY, conY)

                // Modificamos el registro
                db.update(
                    DBContractPos.PosBarco4.TABLE_NAME, registro,
                    null, null
                )
                db.close()
               // println("${conX} + ${conY}")
            }
            5 -> {
                registro.put(DBContractPos.PosBarco5.COLUMN_CONX, conX)
                registro.put(DBContractPos.PosBarco5.COLUMN_CONY, conY)

                // Modificamos el registro
                db.update(
                    DBContractPos.PosBarco5.TABLE_NAME, registro,
                    null, null
                )
                db.close()
            }
        }
        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun deleteUser(): Boolean {
        //Obtenemos la base de datos para escribir
        val db = writableDatabase
//        // Creamos el query para buscar llave a eliminar
//        val selection = DBContract.UserEntry.COLUMN_USER_ID + " LIKE ?"
//        val selectionArgs = arrayOf(userid)
//        // Eliminamos el registro
//        db.delete(DBContract.UserEntry.TABLE_NAME, selection, selectionArgs)

        db.delete(DBContractPos.PosBarco1.TABLE_NAME, null, null)
        db.delete(DBContractPos.PosBarco2.TABLE_NAME, null, null)
        db.delete(DBContractPos.PosBarco3.TABLE_NAME, null, null)
        db.delete(DBContractPos.PosBarco4.TABLE_NAME, null, null)
        db.delete(DBContractPos.PosBarco5.TABLE_NAME, null, null)

        return true
    }

    @SuppressLint("Range")
    fun obtenerInfoJugador(noBarco: Int): PosModel {
        var pos1 = PosModel("0", "0", "0", "0", "0", "0", 2)
        var pos: PosModel
        val db = writableDatabase
        var cursor: Cursor? = null

        when (noBarco) {
            1 -> {
                cursor = db.rawQuery(
                    "select * from " +
                            DBContractPos.PosBarco1.TABLE_NAME, null
                )
            }
            2 -> {
                cursor = db.rawQuery(
                    "select * from " +
                            DBContractPos.PosBarco2.TABLE_NAME, null
                )
            }
            3 -> {
                cursor = db.rawQuery(
                    "select * from " +
                            DBContractPos.PosBarco3.TABLE_NAME, null
                )
            }
            4 -> {
                cursor = db.rawQuery(
                    "select * from " +
                            DBContractPos.PosBarco4.TABLE_NAME, null
                )
            }
            5 -> {
                cursor = db.rawQuery(
                    "select * from " +
                            DBContractPos.PosBarco5.TABLE_NAME, null
                )
            }
        }

        var jugX: String
        var jugY: String
        var punJug: String
        var conX: String
        var conY: String
        var punCon: String

//        with(cursor) {
//            while (cursor?.moveToNext() == true) {
//                val itemId = this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_JUGX))
//                println(itemId)
//            }
//        }

        when (noBarco) {
            1 -> {
                with(cursor) {
                    while (cursor?.moveToNext() == true) {
                        jugX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_JUGX))
                                .toString()
                        jugY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_JUGY))
                                .toString()
                        punJug =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_PUNJUG))
                                .toString()
                        conX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_CONX))
                                .toString()
                        conY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_CONY))
                                .toString()
                        punCon =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_PUNCON))
                                .toString()
                        pos = PosModel(jugX, jugY, punJug, conX, conY, punCon, noBarco)

                        return pos
                    }
                }
            }
            2 -> {
                with(cursor) {
                    while (cursor?.moveToNext() == true) {
                        jugX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco2.COLUMN_JUGX))
                                .toString()
                        jugY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco2.COLUMN_JUGY))
                                .toString()
                        punJug =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco2.COLUMN_PUNJUG))
                                .toString()
                        conX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco2.COLUMN_CONX))
                                .toString()
                        conY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco2.COLUMN_CONY))
                                .toString()
                        punCon =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco2.COLUMN_PUNCON))
                                .toString()
                        pos = PosModel(jugX, jugY, punJug, conX, conY, punCon, noBarco)

                        return pos
                    }
                }
            }
            3 -> {
                with(cursor) {
                    while (cursor?.moveToNext() == true) {
                        jugX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco3.COLUMN_JUGX))
                                .toString()
                        jugY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco3.COLUMN_JUGY))
                                .toString()
                        punJug =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco3.COLUMN_PUNJUG))
                                .toString()
                        conX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco3.COLUMN_CONX))
                                .toString()
                        conY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco3.COLUMN_CONY))
                                .toString()
                        punCon =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco3.COLUMN_PUNCON))
                                .toString()
                        pos = PosModel(jugX, jugY, punJug, conX, conY, punCon, noBarco)

                        return pos
                    }
                }
            }
            4 -> {
                with(cursor) {
                    while (cursor?.moveToNext() == true) {
                        jugX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco4.COLUMN_JUGX))
                                .toString()
                        jugY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco4.COLUMN_JUGY))
                                .toString()
                        punJug =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco4.COLUMN_PUNJUG))
                                .toString()
                        conX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco4.COLUMN_CONX))
                                .toString()
                        conY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco4.COLUMN_CONY))
                                .toString()
                        punCon =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco4.COLUMN_PUNCON))
                                .toString()
                        pos = PosModel(jugX, jugY, punJug, conX, conY, punCon, noBarco)

                        return pos
                    }
                }
            }
            5 -> {
                with(cursor) {
                    while (cursor?.moveToNext() == true) {
                        jugX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco5.COLUMN_JUGX))
                                .toString()
                        jugY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco5.COLUMN_JUGY))
                                .toString()
                        punJug =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco5.COLUMN_PUNJUG))
                                .toString()
                        conX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco5.COLUMN_CONX))
                                .toString()
                        conY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco5.COLUMN_CONY))
                                .toString()
                        punCon =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco5.COLUMN_PUNCON))
                                .toString()
                        pos = PosModel(jugX, jugY, punJug, conX, conY, punCon, noBarco)

                        return pos
                    }
                }
            }
        }
        return pos1
    }

    fun obtenerListaPos(): MutableList<PosModel> {
        val db = writableDatabase
        var cursor: Cursor? = null

        cursor = db.rawQuery(
            "select * from " +
                    DBContractPos.PosBarco1.TABLE_NAME, null
        )

        listaPos.add(a??adirVista(cursor, 1))

        cursor = null

        cursor = db.rawQuery(
            "select * from " +
                    DBContractPos.PosBarco2.TABLE_NAME, null
        )
        listaPos.add(a??adirVista(cursor, 2))

        cursor = null
        cursor = db.rawQuery(
            "select * from " +
                    DBContractPos.PosBarco3.TABLE_NAME, null
        )
        listaPos.add(a??adirVista(cursor, 3))

        cursor = null
        cursor = db.rawQuery(
            "select * from " +
                    DBContractPos.PosBarco4.TABLE_NAME, null
        )
        listaPos.add(a??adirVista(cursor, 4))
        cursor = null
        cursor = db.rawQuery(
            "select * from " +
                    DBContractPos.PosBarco5.TABLE_NAME, null
        )
        listaPos.add(a??adirVista(cursor, 5))

        return listaPos
    }

    fun a??adirVista(cursor: Cursor, num: Int): PosModel {
        var jugX: String
        var jugY: String
        var punJug: String
        var conX: String
        var conY: String
        var punCon: String

        var pos: PosModel
        var pos1 = PosModel("1", "1", "2", "1", "1", "1", 1)
        with(cursor) {
            while (moveToNext()) {
                when (num) {
                    1 -> {
                        jugX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_JUGX))
                                .toString()

                        jugY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_JUGY))
                                .toString()
                        punJug =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_PUNJUG))
                                .toString()
                        conX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_CONX))
                                .toString()
                        conY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_CONY))
                                .toString()
                        punCon =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco1.COLUMN_PUNCON))
                                .toString()

                        pos = PosModel(jugX, jugY, punJug, conX, conY, punCon, num)
                        return pos
                    }
                    2 -> {
                        jugX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco2.COLUMN_JUGX))
                                .toString()

                        jugY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco2.COLUMN_JUGY))
                                .toString()
                        punJug =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco2.COLUMN_PUNJUG))
                                .toString()
                        conX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco2.COLUMN_CONX))
                                .toString()
                        conY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco2.COLUMN_CONY))
                                .toString()
                        punCon =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco2.COLUMN_PUNCON))
                                .toString()
                        pos = PosModel(jugX, jugY, punJug, conX, conY, punCon, num)

                        return pos
                    }
                    3 -> {
                        jugX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco3.COLUMN_JUGX))
                                .toString()

                        jugY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco3.COLUMN_JUGY))
                                .toString()
                        punJug =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco3.COLUMN_PUNJUG))
                                .toString()
                        conX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco3.COLUMN_CONX))
                                .toString()
                        conY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco3.COLUMN_CONY))
                                .toString()
                        punCon =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco3.COLUMN_PUNCON))
                                .toString()
                        pos = PosModel(jugX, jugY, punJug, conX, conY, punCon, num)

                        return pos
                    }
                    4 -> {
                        jugX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco4.COLUMN_JUGX))
                                .toString()

                        jugY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco4.COLUMN_JUGY))
                                .toString()
                        punJug =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco4.COLUMN_PUNJUG))
                                .toString()
                        conX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco4.COLUMN_CONX))
                                .toString()
                        conY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco4.COLUMN_CONY))
                                .toString()
                        punCon =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco4.COLUMN_PUNCON))
                                .toString()
                        pos = PosModel(jugX, jugY, punJug, conX, conY, punCon, num)

                        return pos
                    }
                    5 -> {
                        jugX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco5.COLUMN_JUGX))
                                .toString()

                        jugY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco5.COLUMN_JUGY))
                                .toString()
                        punJug =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco5.COLUMN_PUNJUG))
                                .toString()
                        conX =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco5.COLUMN_CONX))
                                .toString()
                        conY =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco5.COLUMN_CONY))
                                .toString()
                        punCon =
                            this?.getLong(getColumnIndexOrThrow(DBContractPos.PosBarco5.COLUMN_PUNCON))
                                .toString()
                        pos = PosModel(jugX, jugY, punJug, conX, conY, punCon, num)

                        return pos
                    }
                }
            }
        }
        return pos1
    }

    @SuppressLint("Range")
    fun obtenerPuntosJugador(): String {
        val db = writableDatabase
        var cursor: Cursor? = null
        var dato: String = ""

        cursor = db.rawQuery(
            "select * from " +
                    DBContractPos.puntosJug.TABLE_NAME, null
        )

        with(cursor) {
            while (cursor?.moveToNext() == true) {
                dato =
                    this?.getLong(getColumnIndexOrThrow(DBContractPos.puntosJug.COLUMN_PUNTO))
                        .toString()
            }
        }
        return dato
    }

    @SuppressLint("Range")
    fun obtenerPuntosConsola(): String {
        val db = writableDatabase
        var cursor: Cursor? = null
        var dato: String = ""

        cursor = db.rawQuery(
            "select * from " +
                    DBContractPos.puntosCon.TABLE_NAME, null
        )

        with(cursor) {
            while (cursor?.moveToNext() == true) {
                dato =
                    this?.getLong(getColumnIndexOrThrow(DBContractPos.puntosCon.COLUMN_PUNTO))
                        .toString()
            }
        }
        return dato
    }

    @Throws(SQLiteConstraintException::class)
    fun insertToqueJugador(toques: PosToques) {
        val db = writableDatabase
        // Creamos un ContentValues, para asignar los valores a insertar
        val values = ContentValues()

        values.put(DBContractPos.toqueJugador.COLUMN_TOQUEX, toques.toqX)
        values.put(DBContractPos.toqueJugador.COLUMN_TOQUEY, toques.toqY)
        val newRowId = db.insert(DBContractPos.toqueJugador.TABLE_NAME, null, values)
    }


    @SuppressLint("Range")
    fun obtenerToquesJugador():MutableList<PosToques>{
        val db = writableDatabase
        var cursor: Cursor? = null
        var lista= mutableListOf<PosToques>()

        cursor = db.rawQuery(
            "select * from " +
                    DBContractPos.toqueJugador.TABLE_NAME, null
        )

        var x:String
        var y: String
        with(cursor) {
            while (moveToNext()) {
                x =
                    this?.getLong(getColumnIndexOrThrow(DBContractPos.toqueJugador.COLUMN_TOQUEX)).toString()
                y = this?.getLong(getColumnIndexOrThrow(DBContractPos.toqueJugador.COLUMN_TOQUEY)).toString()
                var toque = PosToques(x,y)
                lista.add(toque)
            }
        }
        return lista
    }


    @Throws(SQLiteConstraintException::class)
    fun insertToqueConsola(toques: PosToques) {
        val db = writableDatabase
        // Creamos un ContentValues, para asignar los valores a insertar
        val values = ContentValues()

        values.put(DBContractPos.toqueConsola.COLUMN_TOQUEX, toques.toqX)
        values.put(DBContractPos.toqueConsola.COLUMN_TOQUEY, toques.toqY)
        val newRowId = db.insert(DBContractPos.toqueConsola.TABLE_NAME, null, values)

        println("Insertando toque")
    }

    @SuppressLint("Range")
    fun obtenerToquesConsola():MutableList<PosToques>{
        val db = writableDatabase
        var cursor: Cursor? = null
        var lista= mutableListOf<PosToques>()

        cursor = db.rawQuery(
            "select * from " +
                    DBContractPos.toqueConsola.TABLE_NAME, null
        )

        var x:String
        var y: String
        println("Obteniendo datos")
        with(cursor) {
            while (moveToNext()) {
                x =
                    this?.getLong(getColumnIndexOrThrow(DBContractPos.toqueConsola.COLUMN_TOQUEX)).toString()
                y = this?.getLong(getColumnIndexOrThrow(DBContractPos.toqueConsola.COLUMN_TOQUEY)).toString()
                var toque = PosToques(x,y)
                lista.add(toque)
            }
        }
        return lista
    }

    companion object {
        // En caso de modificar la estructura de la BD, incrementar la version en 1.
        //val DATABASE_VERSION = 4

        val DATABASE_VERSION = 23
        val DATABASE_NAME = "poss.db"
    }
}