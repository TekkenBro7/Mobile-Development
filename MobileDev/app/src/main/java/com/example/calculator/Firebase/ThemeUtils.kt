package com.example.calculator.Firebase

import android.content.Context
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Build
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.example.calculator.R
import com.example.calculator.activities.MainActivity

const val THEME_PREFERENCES = "ThemePrefs"
const val SELECTED_THEME = "SelectedTheme"
val THEME_DEFAULT = 1
val THEME_ONE = 1
val THEME_TWO = 2
val THEME_THREE = 3
val THEME_FOUR = 4
var currentTheme: Int = THEME_DEFAULT

fun applyTheme(activity: MainActivity, currentTheme: Int) {
    when (currentTheme) {
        THEME_ONE -> {
            activity.setTheme(R.style.AppTheme1)
            setButtonColors(activity,
                R.color.colorPrimary1,
                R.color.colorPrimaryDark1,
                R.color.textColorPrimary1,
                R.color.backgroundColor1
            )
            setStatusBarColor(activity, R.color.colorPrimaryDark1)
            setNavigationBarColor(activity, R.color.colorPrimaryDark1)
            ViewCompat.setBackgroundTintList(activity.findViewById(R.id.linearLayout2), ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.btn)))
            activity.findViewById<TextView>(R.id.title_bar)?.let { titleBar ->
                titleBar.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimaryDark1))
            }
            activity.findViewById<LinearLayout>(R.id.buttonRow)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.colorPrimary1)
            )
            activity.findViewById<View>(R.id.main).setBackgroundColor(
                ContextCompat.getColor(activity, R.color.backgroundColor1)
            )
            activity.findViewById<TextView>(R.id.expression).setTextColor(
                ContextCompat.getColor(activity, R.color.textColorPrimary1)
            )
            activity.findViewById<View>(R.id.result).setBackgroundColor(
                ContextCompat.getColor(activity, R.color.backgroundColor1)
            )
            activity.findViewById<TextView>(R.id.result).setTextColor(
                ContextCompat.getColor(activity, R.color.textColorPrimary1)
            )
            activity.findViewById<View>(R.id.view)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.black)
            )
            activity.findViewById<LinearLayout>(R.id.linearLayout2)?.let { layout ->
                ViewCompat.setBackgroundTintList(
                    layout,
                    ColorStateList.valueOf(
                        ContextCompat.getColor(
                            activity,
                            R.color.colorPrimary1
                        )
                    )
                )
            }
            activity.findViewById<LinearLayout>(R.id.col963)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.colorPrimary1)
            )
        }
        THEME_TWO -> {
            activity.setTheme(R.style.AppTheme2)
            setButtonColors(activity,
                R.color.colorPrimary2,
                R.color.colorPrimaryDark2,
                R.color.textColorPrimary2,
                R.color.backgroundColor2
            )
            setStatusBarColor(activity, R.color.colorPrimaryDark2)
            setNavigationBarColor(activity, R.color.colorPrimaryDark2)
            ViewCompat.setBackgroundTintList(activity.findViewById(R.id.linearLayout2), ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.backgroundColor2)))
            activity.findViewById<TextView>(R.id.title_bar)?.let { titleBar ->
                titleBar.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimaryDark2))
            }
            activity.findViewById<LinearLayout>(R.id.buttonRow)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.colorPrimary2)
            )
            activity.findViewById<View>(R.id.main).setBackgroundColor(
                ContextCompat.getColor(activity, R.color.backgroundColor2)
            )
            activity.findViewById<TextView>(R.id.expression).setTextColor(
                ContextCompat.getColor(activity, R.color.textColorPrimary2)
            )
            activity.findViewById<View>(R.id.result).setBackgroundColor(
                ContextCompat.getColor(activity, R.color.backgroundColor2)
            )
            activity.findViewById<TextView>(R.id.result).setTextColor(
                ContextCompat.getColor(activity, R.color.textColorPrimary2)
            )
            activity.findViewById<View>(R.id.view)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.black)
            )
            activity.findViewById<LinearLayout>(R.id.linearLayout2)?.let { layout ->
                ViewCompat.setBackgroundTintList(
                    layout,
                    ColorStateList.valueOf(
                        ContextCompat.getColor(
                            activity,
                            R.color.colorPrimary2
                        )
                    )
                )
            }
            activity.findViewById<LinearLayout>(R.id.col963)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.colorPrimary2)
            )
        }
        THEME_THREE -> {
            activity.setTheme(R.style.AppTheme3)
            setButtonColors(activity,
                R.color.colorPrimary3,
                R.color.colorPrimaryDark3,
                R.color.textColorPrimary3,
                R.color.backgroundColor3
            )
            setStatusBarColor(activity, R.color.colorPrimaryDark3)
            setNavigationBarColor(activity, R.color.colorPrimaryDark3)
            ViewCompat.setBackgroundTintList(activity.findViewById(R.id.linearLayout2), ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.backgroundColor3)))
            activity.findViewById<TextView>(R.id.title_bar)?.let { titleBar ->
                titleBar.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimaryDark3))
            }
            activity.findViewById<LinearLayout>(R.id.buttonRow)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.colorPrimary3)
            )
            activity.findViewById<View>(R.id.main).setBackgroundColor(
                ContextCompat.getColor(activity, R.color.backgroundColor3)
            )
            activity.findViewById<TextView>(R.id.expression).setTextColor(
                ContextCompat.getColor(activity, R.color.textColorPrimary3)
            )
            activity.findViewById<View>(R.id.result).setBackgroundColor(
                ContextCompat.getColor(activity, R.color.backgroundColor3)
            )
            activity.findViewById<TextView>(R.id.result).setTextColor(
                ContextCompat.getColor(activity, R.color.textColorPrimary3)
            )
            activity.findViewById<View>(R.id.view)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.black)
            )
            activity.findViewById<LinearLayout>(R.id.linearLayout2)?.let { layout ->
                ViewCompat.setBackgroundTintList(
                    layout,
                    ColorStateList.valueOf(
                        ContextCompat.getColor(
                            activity,
                            R.color.colorPrimary3
                        )
                    )
                )
            }
            activity.findViewById<LinearLayout>(R.id.col963)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.colorPrimary3)
            )
        }
        THEME_FOUR -> {
            activity.setTheme(R.style.AppTheme4)
            setButtonColors(activity,
                R.color.colorPrimary4,
                R.color.colorPrimaryDark4,
                R.color.textColorPrimary4,
                R.color.backgroundColor4
            )
            setStatusBarColor(activity, R.color.colorPrimaryDark4)
            setNavigationBarColor(activity, R.color.colorPrimaryDark4)
            ViewCompat.setBackgroundTintList(activity.findViewById(R.id.linearLayout2), ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.backgroundColor4)))
            activity.findViewById<TextView>(R.id.title_bar)?.let { titleBar ->
                titleBar.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimaryDark4))
            }
            activity.findViewById<LinearLayout>(R.id.buttonRow)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.colorPrimary4)
            )
            activity.findViewById<View>(R.id.main).setBackgroundColor(
                ContextCompat.getColor(activity, R.color.backgroundColor4)
            )
            activity.findViewById<TextView>(R.id.expression).setTextColor(
                ContextCompat.getColor(activity, R.color.textColorPrimary4)
            )
            activity.findViewById<View>(R.id.result).setBackgroundColor(
                ContextCompat.getColor(activity, R.color.backgroundColor4)
            )
            activity.findViewById<TextView>(R.id.result).setTextColor(
                ContextCompat.getColor(activity, R.color.textColorPrimary4)
            )
            activity.findViewById<View>(R.id.view)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.black)
            )
            activity.findViewById<LinearLayout>(R.id.linearLayout2)?.let { layout ->
                ViewCompat.setBackgroundTintList(
                    layout,
                    ColorStateList.valueOf(
                        ContextCompat.getColor(
                            activity,
                            R.color.colorPrimary4
                        )
                    )
                )
            }
            activity.findViewById<LinearLayout>(R.id.col963)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.colorPrimary4)
            )
        }
        else -> {
            activity.setTheme(R.style.AppTheme1)
            setButtonColors(activity,
                R.color.colorPrimary1,
                R.color.colorPrimaryDark1,
                R.color.textColorPrimary1,
                R.color.backgroundColor1
            )
            setStatusBarColor(activity, R.color.colorPrimaryDark1)
            setNavigationBarColor(activity, R.color.colorPrimaryDark1)
            ViewCompat.setBackgroundTintList(activity.findViewById(R.id.linearLayout2), ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.backgroundColor1)))
            activity.findViewById<TextView>(R.id.title_bar)?.let { titleBar ->
                titleBar.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimaryDark1))
            }
            activity.findViewById<LinearLayout>(R.id.buttonRow)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.colorPrimary1)
            )
            activity.findViewById<View>(R.id.main).setBackgroundColor(
                ContextCompat.getColor(activity, R.color.backgroundColor1)
            )
            activity.findViewById<TextView>(R.id.expression).setTextColor(
                ContextCompat.getColor(activity, R.color.textColorPrimary1)
            )
            activity.findViewById<View>(R.id.result).setBackgroundColor(
                ContextCompat.getColor(activity, R.color.backgroundColor1)
            )
            activity.findViewById<TextView>(R.id.result).setTextColor(
                ContextCompat.getColor(activity, R.color.textColorPrimary1)
            )
            activity.findViewById<View>(R.id.view)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.black)
            )
            activity.findViewById<LinearLayout>(R.id.linearLayout2)?.let { layout ->
                ViewCompat.setBackgroundTintList(
                    layout,
                    ColorStateList.valueOf(
                        ContextCompat.getColor(
                            activity,
                            R.color.colorPrimary1
                        )
                    )
                )
            }
            activity.findViewById<LinearLayout>(R.id.col963)?.setBackgroundColor(
                ContextCompat.getColor(activity, R.color.colorPrimary1)
            )
        }
    }
}

fun setStatusBarColor(activity: MainActivity, colorResId: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        activity.window.statusBarColor = ContextCompat.getColor(activity, colorResId)
    }
}

fun setNavigationBarColor(activity: MainActivity, colorResId: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        activity.window.navigationBarColor = ContextCompat.getColor(activity, colorResId)
    }
}

fun setButtonColors(activity: MainActivity, primaryColor: Int, primaryDarkColor: Int, textColor: Int, backgroundColor: Int) {
    val buttons = arrayOf(
        R.id.toggleColumnButton, R.id.history, R.id.levelButton, R.id.ln, R.id.e, R.id.ctg,
        R.id.QrButton, R.id.sin, R.id.cos, R.id.tg, R.id.pi, R.id.sqrt,
        R.id.leftscob, R.id.rightscob, R.id.clear,
        R.id.seven, R.id.four, R.id.one, R.id.zero,
        R.id.backSpace, R.id.eight, R.id.five, R.id.two, R.id.doublezero, R.id.percent,
        R.id.nine, R.id.six, R.id.three, R.id.dot, R.id.divide, R.id.multiply,
        R.id.add, R.id.subtract, R.id.button_theme, R.id.equal
    )

    for (buttonId in buttons) {
        val button = activity.findViewById<View>(buttonId)
        if (button is Button) {
            button.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(activity, primaryColor))
            button.setTextColor(ContextCompat.getColor(activity, textColor))
        } else if (button is ImageButton) {
            button.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(activity, primaryColor))
            button.setColorFilter(
                ContextCompat.getColor(activity, textColor),
                PorterDuff.Mode.SRC_IN
            )
        }
    }

    val tvResult = activity.findViewById<TextView>(R.id.result)
    tvResult.setTextColor(ContextCompat.getColor(activity, textColor))
    tvResult.setBackgroundColor(ContextCompat.getColor(activity, backgroundColor))
}

fun saveTheme(activity: MainActivity, currentTheme: Int) {
    val preferences: SharedPreferences = activity.getSharedPreferences(THEME_PREFERENCES, Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = preferences.edit()
    editor.putInt(SELECTED_THEME, currentTheme)
    editor.apply()
}

fun loadTheme(activity: MainActivity): Int {
    val preferences: SharedPreferences = activity.getSharedPreferences(THEME_PREFERENCES, Context.MODE_PRIVATE)
    return preferences.getInt(SELECTED_THEME, THEME_DEFAULT)
}

fun getColorPrimary(context: Context, theme: Int): Int {
    return when (theme) {
        THEME_ONE -> ContextCompat.getColor(context, R.color.colorPrimary1)
        THEME_TWO -> ContextCompat.getColor(context, R.color.colorPrimary2)
        THEME_THREE -> ContextCompat.getColor(context, R.color.colorPrimary3)
        THEME_FOUR -> ContextCompat.getColor(context, R.color.colorPrimary4)
        else -> ContextCompat.getColor(context, R.color.colorPrimary1)
    }
}

fun getBackgroundColor(context: Context, theme: Int): Int {
    return when (theme) {
        THEME_ONE -> ContextCompat.getColor(context, R.color.backgroundColor1)
        THEME_TWO -> ContextCompat.getColor(context, R.color.backgroundColor2)
        THEME_THREE -> ContextCompat.getColor(context, R.color.backgroundColor3)
        THEME_FOUR -> ContextCompat.getColor(context, R.color.backgroundColor4)
        else -> ContextCompat.getColor(context, R.color.backgroundColor1)
    }
}