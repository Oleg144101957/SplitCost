package com.vishnevskiypro.splitcost.data

object DbConstants {

    //db
    const val DB_NAME = "splitdb.db"
    const val DB_VERSION = 1


    //TABLES
    const val TABLE_TRIP = "trip"
    const val TABLE_COST = "cost"
    const val TABLE_USER = "user"

    //COLUMNS TRIP TABLE
    const val ID_TRIP = "id_trip"
    const val TRIP_NAME = "trip_name"
    const val TRIP_AVATAR = "trip_avatar"


    const val ID_COST = "id_cost"

    const val TIME = "time"
    const val DESCRIPTION = "description"
    const val AMOUNT = "amount"
    const val USER_ID = "user_id"
    const val TRIP_ID = "trip_id"


    //CREATE TABLES
    const val CREATE_TABLE_START = "CREATE TABLE IF NOT EXISTS"
    const val CREATE_TRIP_TABLE = "$CREATE_TABLE_START $TABLE_TRIP ($ID_TRIP INTEGER PRIMARY KEY AUTOINCREMENT, $TRIP_NAME TEXT, $TRIP_AVATAR TEXT)"
    const val DROP_TRIP_TABLE = "DROP TABLE IF EXIST $TABLE_TRIP"
}
