package com.vishnevskiypro.splitcost.data.dao

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main(){


    //Готовим дату и время для хранения в базе
    val TS_DATE_PATTERN = "dd-MM-yyyy' 'HH:mm:ss"
    val formatter = DateTimeFormatter.ofPattern(TS_DATE_PATTERN)
    val x = LocalDateTime.now().format(formatter)


    println(x)





}