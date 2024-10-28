package com.tandemdiabetes.technicalinterview1.domain


/**
 * Use the "character" field to display the emoji
 * Use the "unicodeName" field to display the name of the emoji
 */
data class Emoji(
    val slug: String,
    val character: String,
    val unicodeName: String,
    val codePoint: String,
    val group: String,
    val subGroup: String,
)
