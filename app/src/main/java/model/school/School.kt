package winapi251.app.schoolmeal.model.school

import winapi251.app.schoolmeal.model.Area

/**
 * 학교 데이터
 * @property code 학교 코드
 * @property course 학교 과정
 * @property name 학교 이름 (ex. `"선린인터넷고등학교"`)
 * @property address 학교 주소 (ex. `"서울특별시 용산구 원효로97길 33-4"`)
 * @property area 소속 행정구역
 */
data class School(
    val code: Code,
    val course: Course,
    val name: String,
    val address: String,
    val area: Area
) {
    /**
     * 나이스 학교 코드
     * @property asString ex. `"B100000658"`
     */
    data class Code(val asString: String)

    /** 학교 과정 */
    enum class Course(val code: Int) {
        /** 유치원 */
        INFANT(1),

        /** 초등학교 */
        ELEMENTARY(2),

        /** 중학교 */
        MIDDLE(3),

        /** 고등학교 */
        HIGH(4),

        /** 특수학교 */
        SPECIAL(5)
    }
}
