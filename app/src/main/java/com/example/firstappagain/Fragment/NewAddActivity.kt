package com.example.firstappagain.Fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.firstappagain.R

class NewAddActivity : AppCompatActivity() {

    private lateinit var editAddView:EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_add)
        editAddView = findViewById(R.id.edit_add)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editAddView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val user = editAddView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, user)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}