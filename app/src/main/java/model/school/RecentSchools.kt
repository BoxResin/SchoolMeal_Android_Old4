package winapi251.app.schoolmeal.model.school

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject
import winapi251.app.schoolmeal.DB_NAME_RECENT_SCHOOL
import winapi251.app.schoolmeal.appContext
import winapi251.app.schoolmeal.model.Area

/**
 * 최근 선택한 학교 목록
 * - [Observable]: 기본적으로 UI 스레드에서 구독한다. 학교 목록은 최근순으로 정렬된다.
 */
object RecentSchools : Observable<List<School>>() {
    private val recentSchools by lazy { BehaviorSubject.createDefault(Database.selectAll()) }

    /**
     * [school]을 최근 선택한 학교 목록에 추가한다. 만약, `code` 가 동일한 학교가 이미 존재하면 삭제하고
     * 추가한다.
     */
    operator fun plusAssign(school: School) {
        Database.delete(school.code)
        Database.insert(school)
        notifyDataSetChanged()
    }

    /** [school]의 `code` 와 일치하는 모든 학교를 최근 선택한 학교 목록에서 제거한다. */
    operator fun minusAssign(school: School) {
        Database.delete(school.code)
        notifyDataSetChanged()
    }

    private fun notifyDataSetChanged() {
        val previousList = recentSchools.value
        val currentList = Database.selectAll()

        if (currentList != previousList)
            recentSchools.onNext(currentList)
    }

    override fun subscribeActual(observer: Observer<in List<School>>) {
        recentSchools
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}

private const val TABLE_NAME = "entry"
private const val COLUMN_NAME_CODE = "code"
private const val COLUMN_NAME_COURSE_CODE = "courseCode"
private const val COLUMN_NAME_NAME = "name"
private const val COLUMN_NAME_ADDRESS = "address"
private const val COLUMN_NAME_AREA = "area"

private const val SQL_CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
    "${BaseColumns._ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
    "$COLUMN_NAME_CODE TEXT NOT NULL," +
    "$COLUMN_NAME_COURSE_CODE TEXT NOT NULL," +
    "$COLUMN_NAME_NAME TEXT NOT NULL," +
    "$COLUMN_NAME_ADDRESS TEXT NOT NULL," +
    "$COLUMN_NAME_AREA TEXT NOT NULL)"

/** 최근 선택한 학교 데이터베이스 */
private object Database {
    private val dbHelper = object : SQLiteOpenHelper(appContext, DB_NAME_RECENT_SCHOOL, null, 1) {
        override fun onCreate(db: SQLiteDatabase) {
            // 테이블 생성
            db.execSQL(SQL_CREATE_TABLE)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            // 테이블 삭제
            db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(db)
        }
    }

    /** 데이터베이스에서 레코드를 모두 읽는다. */
    fun selectAll(): List<School> {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        val result = mutableListOf<School>()

        while (cursor.moveToNext()) {
            val code = cursor.getString(1)
            val courseCode = cursor.getString(2)
            val name = cursor.getString(3)
            val address = cursor.getString(4)
            val area = cursor.getString(5)

            result += School(
                School.Code(code),
                School.Course.valueOf(courseCode),
                name,
                address,
                Area.valueOf(area)
            )
        }

        cursor.close()
        db.close()

        return result.reversed() // 최근순으로 정렬
    }

    /** 데이터베이스에 [school] 레코드를 추가한다. */
    fun insert(school: School) {
        val db = dbHelper.writableDatabase
        db.execSQL(
            "INSERT INTO $TABLE_NAME (" +
                "$COLUMN_NAME_CODE," +
                "$COLUMN_NAME_COURSE_CODE," +
                "$COLUMN_NAME_NAME," +
                "$COLUMN_NAME_ADDRESS," +
                "$COLUMN_NAME_AREA) " +
                "VALUES (" +
                "'${school.code.asString}'," +
                "'${school.course.name}'," +
                "'${school.name}'," +
                "'${school.address}'," +
                "'${school.area.name}')"
        )
        db.close()
    }

    /** 데이터베이스에서 [code]에 해당하는 레코드를 모두 삭제한다. */
    fun delete(code: School.Code) {
        val db = dbHelper.writableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME WHERE $COLUMN_NAME_CODE = '${code.asString}'")
        db.close()
    }
}
