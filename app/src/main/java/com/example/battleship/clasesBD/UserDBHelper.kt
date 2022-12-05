package com.example.battleship.clasesBD

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

import java.util.ArrayList

class UserDBHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,
    null, DATABASE_VERSION){

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
        val values = ContentValues()
        values.put(DBContract.UserEntry.COLUMN_NAME, "admin")
        values.put(DBContract.UserEntry.COLUMN_PWD, "123")
        values.put(DBContract.UserEntry.COLUMN_AGE, "22")
//        val newRowId = db.insert(DBContract.UserEntry.TABLE_NAME, null, values)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // En caso de actualizar la version de BD elimina lo anterior, para iniciar otra
        //db.execSQL(SQL_CREATE_ENTRIES)
        db.execSQL(String.format("DROP TABLE IF EXISTS " + DBContract.UserEntry.TABLE_NAME + ""))
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertUser(user: UserModel): Boolean {
        //Obtenemos la base de datos para escribir
        val db = writableDatabase
        // Creamos un ContentValues, para asignar los valores a insertar
        val values = ContentValues()
        values.put(DBContract.UserEntry.COLUMN_NAME, user.name)
        values.put(DBContract.UserEntry.COLUMN_PWD, user.pass)
        values.put(DBContract.UserEntry.COLUMN_AGE, user.age)

        //Insertamos el nuevo registro
        val newRowId = db.insert(DBContract.UserEntry.TABLE_NAME, null, values)

        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun deleteUser(userid: String): Boolean {
        //Obtenemos la base de datos para escribir
        val db = writableDatabase
        // Creamos el query para buscar llave a eliminar
        val selection = DBContract.UserEntry.COLUMN_NAME + " LIKE ?"
        val selectionArgs = arrayOf(userid)
        // Eliminamos el registro
        db.delete(DBContract.UserEntry.TABLE_NAME, selection, selectionArgs)

        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun updateUser(name: String, pass: String): Boolean {
        //Obtenemos la base de datos para escribir
        val db = writableDatabase
        // Creamos el query para buscar llave a modificar
        val registro = ContentValues()
        registro.put("name", name)
        registro.put("age", pass)

        // Modificamos el registro
        db.update(DBContract.UserEntry.TABLE_NAME, registro,
            "name=${name}",null)

        return true
    }

    @SuppressLint("Range")
    fun readUser(name: String): ArrayList<UserModel> {
        val users = ArrayList<UserModel>()
        val db = writableDatabase
        var cursor: Cursor? = null

            cursor = db.rawQuery("select * from " + DBContract.UserEntry.TABLE_NAME
                    + " WHERE " + DBContract.UserEntry.COLUMN_NAME + "='"
                    + name + "'", null)


        var name: String
        var pass: String
        var age: String

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                name = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_NAME))
                pass = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_PWD))
                age = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_AGE))

                users.add(UserModel(name,pass, age))
                cursor.moveToNext()
            }
        }
        return users
    }

    @SuppressLint("Range")
//    fun readAllUsers(): ArrayList<UserModel> {
//        val users = ArrayList<UserModel>()
//        val db = writableDatabase
//        var cursor: Cursor? = null
//        try {
//            cursor = db.rawQuery("select * from " + DBContract.UserEntry.TABLE_NAME, null)
//        } catch (e: SQLiteException) {
//            db.execSQL(SQL_CREATE_ENTRIES)
//            return ArrayList()
//        }
//
//        var name: String
//        var pass: String
//        var age: String
//        if (cursor!!.moveToFirst()) {
//            while (cursor.isAfterLast == false) {
//                name = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_NAME))
//                pass = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_PWD))
//                age = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_AGE))
//
//                users.add(UserModel(name,pass,age))
//                cursor.moveToNext()
//            }
//        }
//        return users
//    }

    fun buscar(name: String): Boolean {

        var encontrado = false
        val db = writableDatabase
        var cursor: Cursor? = null

        cursor = db.rawQuery("select * from " + DBContract.UserEntry.TABLE_NAME
                + " WHERE " + DBContract.UserEntry.COLUMN_NAME + " = '"
                + name + "'", null)

        with(cursor) {
            while (cursor?.moveToNext() == true) {
                encontrado=true
                return encontrado
            }
        }
        return encontrado
    }

    companion object {
        // En caso de modificar la estructura de la BD, incrementar la version en 1.
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "Usuarios.db"

        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBContract.UserEntry.TABLE_NAME + " (" +
                    DBContract.UserEntry.COLUMN_NAME + " TEXT PRIMARY KEY," +
                    DBContract.UserEntry.COLUMN_PWD + " TEXT," +
                    DBContract.UserEntry.COLUMN_AGE + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBContract.UserEntry.TABLE_NAME
    }
}