package com.example.blog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddNews : AppCompatActivity() {

    private lateinit var titleEditText: EditText
    private lateinit var descEditText: EditText
    private lateinit var textEditText: EditText
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_news)

        titleEditText = findViewById(R.id.add_title)
        descEditText = findViewById(R.id.add_desc)
        textEditText = findViewById(R.id.add_text)
        addButton = findViewById(R.id.button_add_news)

        addButton.setOnClickListener {
            val title = titleEditText.text.toString().trim()
            val desc = descEditText.text.toString().trim()
            val text = textEditText.text.toString().trim()

            if (title.isNotEmpty() && desc.isNotEmpty() && text.isNotEmpty()) {
                // Передача данных обратно в BlogMain
                val intent = Intent()
                intent.putExtra("newsTitle", title)
                intent.putExtra("newsDesc", desc)
                intent.putExtra("newsText", text)
                setResult(Activity.RESULT_OK, intent)
                finish() // Закрываем AddNews Activity после добавления новости
            } else {
                // Оповещение пользователя о незаполненных полях
                // Здесь можно использовать Toast или другой способ уведомления
            }
        }
    }
}
