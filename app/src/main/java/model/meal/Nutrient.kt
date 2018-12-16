package winapi251.app.schoolmeal.model.meal

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
