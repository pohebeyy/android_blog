// DBhelper.kt
package com.example.blog

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBhelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app", factory, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        // Создание таблицы пользователей
        val userTableQuery = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, pass TEXT)"
        db?.execSQL(userTableQuery)

        // Создание таблицы новостей
        val newsTableQuery =
            "CREATE TABLE news (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT, text TEXT)"
        db?.execSQL(newsTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        db?.execSQL("DROP TABLE IF EXISTS news")
        onCreate(db)
    }

    fun addUser(user: User) {
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("pass", user.pass)

        val db = this.writableDatabase
        db.insert("users", null, values)
        db.close()
    }

    fun getUser(login: String, pass: String): Boolean {
        val db = this.readableDatabase
        val columns = arrayOf("id")
        val selection = "login = ? AND pass = ?"
        val selectionArgs = arrayOf(login, pass)

        val cursor: Cursor = db.query("users", columns, selection, selectionArgs, null, null, null)
        val cursorCount: Int = cursor.count
        cursor.close()

        return cursorCount > 0
    }

    fun addNews(news: News) {
        val values = ContentValues()
        values.put("title", news.title)
        values.put("description", news.desc)
        values.put("text", news.text)

        val db = this.writableDatabase
        db.insert("news", null, values)
        db.close()
    }
}
