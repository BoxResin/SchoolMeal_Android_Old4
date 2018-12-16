package winapi251.app.schoolmeal.model.meal

import winapi251.app.schoolmeal.datetime.Date

/** 식단 API */
interface MealApi {
    /** 지정한 [date]의 하루치 식단 데이터를 반환한다. */
    suspend fun fetch(date: Date): DailyMeal
}
