package com.example.hiltexample.ui.cources.models

import com.example.hiltexample.R

enum class Type {
    SETTINGS {
        override fun getIcon(): Int {
            return R.drawable.ic_baseline_settings_24
        }
    },
    CARD {
        override fun getIcon(): Int {
            return R.drawable.ic_baseline_credit_card_24
        }
    },
    DEFAULT{
        override fun getIcon(): Int {
            return R.drawable.ic_baseline_credit_card_24
        }

    }
    ;

    abstract fun getIcon(): Int
}

fun String.toIconType(): Type =
    when(this){
        "settings" -> Type.SETTINGS
        "card" -> Type.CARD
        else -> Type.DEFAULT
    }
