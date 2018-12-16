package winapi251.app.schoolmeal.model.meal

/**
 * 한 끼 식단 데이터
 * @property dishes 반찬 목록
 * @property nutrient 영양소 데이터
 * @property origin 원산지 데이터 (ex. `mapOf("쌀" to "국내산", "돼지고기" to "국내산")`)
 */
data class Meal(
    val dishes: List<Dish>,
    val nutrient: Nutrient? = null,
    val origin: Map<String, String>? = null
)
