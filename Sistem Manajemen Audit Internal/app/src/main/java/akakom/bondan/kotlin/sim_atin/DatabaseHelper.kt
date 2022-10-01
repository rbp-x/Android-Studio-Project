package akakom.bondan.kotlin.sim_atin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    /*
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser(ID INTEGER PRIMARY  KEY AUTOINCREMENT, username TEXT, password TEXT)");
    }

 */
    override fun onCreate(db: SQLiteDatabase) {
        val query =
            ("CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_2 + " TEXT, " + COL_3 + " TEXT)")
        db.execSQL(query)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME)
        //   sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase)
    }

    fun tambahUser(user: String?, password: String?): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username", user)
        contentValues.put("password", password)
        val res = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return res
    }

    fun periksaUser(username: String, password: String): Boolean {
        val columns = arrayOf(COL_1)
        val db = readableDatabase
        val selection = COL_2 + "=?" + " AND " + COL_3 + "=?"
        val selectionArgs = arrayOf(username, password)
        val cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null)
        val count = cursor.count
        cursor.close()
        db.close()
        return if (count > 0) true else false
    }

    fun delet(username: String, password: String): Boolean {
        //String[] columns = { COL_1 };
        val dba = readableDatabase
        val selection = COL_2 + "=?" + " AND " + COL_3 + "=?"
        val selectionArgs = arrayOf(username, password)
        // DBMahasiswa getDatabase = new DBMahasiswa(view.getContext());
        // SQLiteDatabase DeleteData = getDatabase.getWritableDatabase();
        dba.delete(TABLE_NAME, selection, selectionArgs)
        return false
    }

    companion object {
        const val DATABASE_NAME = "register.db"
        const val TABLE_NAME = "registeruser"
        const val COL_1 = "ID"
        const val COL_2 = "username"
        const val COL_3 = "password"
        const val COL_4 = "password"
    }
}