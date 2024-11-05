package com.miftah.cashchill.utilities

import kotlin.random.Random
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun generateRandomString(length: Int): String {
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    return (1..length)
        .map { chars.random() }
        .joinToString("")
}

fun generateRandomInt(from : Int, to : Int) : Int {
    return Random.nextInt(from, to)
}

fun generateRandomBoolean() : Boolean {
    return Random.nextBoolean()
}

fun intParse(number : Int) : String {
    val formatter = DecimalFormat("#,###")
    return formatter.format(number)
}

fun getCurrentDate(): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) // Format tanggal sesuai lokal
    return dateFormat.format(Date()) // Mengembalikan tanggal hari ini
}

