package winapi251.app.schoolmeal.model.meal

import winapi251.app.schoolmeal.datetime.Date

/**
 * 하루치 식단 데이터
 * @property date 날짜
 * @property breakfast 아침 식단
 * @property lunch 점심 식단
 * @property dinner 저녁 식단
 */
data class DailyMeal(
    val date: Date,
    val breakfast: Meal? = null,
    val lunch: Meal? = null,
    val dinner: Meal? = null
)
