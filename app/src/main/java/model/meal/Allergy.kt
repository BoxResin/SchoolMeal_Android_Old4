package winapi251.app.schoolmeal.model.meal

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
