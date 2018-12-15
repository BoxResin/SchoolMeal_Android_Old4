package winapi251.app.schoolmeal.model

/**
 * 행정구역
 * @property nameKorean 행정구역 한국어 이름
 */
enum class Area(val nameKorean: String) {
    SEN("서울특별시"),
    PEN("부산광역시"),
    DGE("대구광역시"),
    ICE("인천광역시"),
    GEN("광주광역시"),
    DJE("대전광역시"),
    USE("울산광역시"),
    SJE("세종특별자치시"),
    GOE("경기도"),
    KWE("강원도"),
    CBE("충청북도"),
    CNE("충청남도"),
    JBE("전라북도"),
    JNE("전라남도"),
    GBE("경상북도"),
    GNE("경상남도"),
    JJE("제주특별자치도")
}
