package winapi251.app.schoolmeal.model.school

/** 학교 API */
interface SchoolApi {
    /** 지정한 [keyword]에 맞는 학교 목록을 반환한다. */
    suspend fun search(keyword: String): List<School>

    // 기본 동작을 가짜 학교 API 로 설정
    companion object : SchoolApi by MockSchoolApi
}
