/** 식단 관련 모델 클래스 */
package winapi251.app.schoolmeal.model.meal

import winapi251.app.schoolmeal.datetime.Date

/**
 * 알레르기
 * @property nameKorean 알레르기 한국어 이름
 */
enum class Allergy(val nameKorean: String) {
    EGG("난류"),
    MILK("우유"),
    BUCKWHEAT("메밀"),
    PEANUT("땅콩"),
    SOYBEAN("대두"),
    WHEAT("밀"),
    MACKEREL("고등어"),
    CRAB("게"),
    SHRIMP("새우"),
    PORK("돼지고기"),
    PEACH("복숭아"),
    TOMATO("토마토"),
    SULFUROUS_ACID("아황산류"),
    WALNUT("호두"),
    CHICKEN("닭고기"),
    BEEF("쇠고기"),
    SQUID("오징어"),
    SHELLFISH("조개류")
}

/**
 * 반찬 데이터
 * @property name 반찬 이름
 * @property allergies 유발하는 알레르기 목록
 */
data class Dish(
    val name: String,
    val allergies: List<Allergy> = emptyList()
)

/**
 * 영양소 데이터
 * @property energy 에너지 (단위: kcal)
 * @property carbohydrate 탄수화물 (단위: g)
 * @property protein 단백질 (단위: g)
 * @property fat 지방 (단위: g)
 * @property calcium 칼슘 (단위: mg)
 * @property iron 철분 (단위: mg)
 * @property vitaminA 비타민A (단위: R.E)
 * @property thiamine 티아민 (단위: mg)
 * @property riboflavin 리보플라빈 (단위: mg)
 * @property vitaminC 비타민C (단위: mg)
 */
data class Nutrient(
    val energy: Double = 0.0,
    val carbohydrate: Double = 0.0,
    val protein: Double = 0.0,
    val fat: Double = 0.0,
    val calcium: Double = 0.0,
    val iron: Double = 0.0,
    val vitaminA: Double = 0.0,
    val thiamine: Double = 0.0,
    val riboflavin: Double = 0.0,
    val vitaminC: Double = 0.0
)

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
