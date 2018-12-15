package winapi251.app.schoolmeal.model.school

/** 학교 API */
interface SchoolApi {
    /** 지정한 [keyword]에 맞는 학교 목록을 반환한다. */
    suspend fun search(keyword: String): List<School>
}
