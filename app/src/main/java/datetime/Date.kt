package winapi251.app.schoolmeal.datetime

/** 날짜 */
interface Date {
    /** 년 */
    val year: Int

    /** 월 `[1, 12]` */
    val month: Int

    /** 일 `[1, 31]` */
    val day: Int
}
