package com.example.calculator.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class LogoActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 1
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash)

        supportActionBar?.hide()

        getCurrentThemeFromFirestore()

//        Handler(Looper.getMainLooper()).postDelayed({
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, 1000)
    }

    private fun getCurrentThemeFromFirestore() {
        val themesRef = db.collection("theme")
        themesRef.document("7rGDPSlMyggDXGsYwpnu").get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val theme = document.getLong("current_theme")
                    if (theme != null) {
                        saveTheme(theme.toInt())
                        openMainActivity()
                    }
                }
            }
            .addOnFailureListener { exception ->
                openMainActivity()
            }
    }

    private fun saveTheme(theme: Int) {
        val preferences: SharedPreferences = getSharedPreferences(THEME_PREFERENCES, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putInt(SELECTED_THEME, theme)
        editor.apply()
    }

    private fun openMainActivity() {
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, SPLASH_TIME_OUT)
    }
}
