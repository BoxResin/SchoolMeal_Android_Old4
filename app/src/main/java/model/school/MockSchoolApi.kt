package winapi251.app.schoolmeal.model.school

import kotlinx.coroutines.delay
import winapi251.app.schoolmeal.model.Area
import winapi251.app.schoolmeal.model.school.School.Code
import winapi251.app.schoolmeal.model.school.School.Course

/** 가짜 학교 API */
object MockSchoolApi : SchoolApi {
    override suspend fun search(keyword: String): List<School> {
        // 실제로 검색하는 느낌을 주기 위해 딜레이
        delay(3000)

        // 가짜 학교 목록 반환
        return listOf(
            School(
                Code("B100000925"), Course.ELEMENTARY, area = Area.SEN,
                name = "서울선린초등학교", address = "서울특별시 강동구 진황도로61길 29"
            ),

            School(
                Code("B100002350"), Course.MIDDLE, area = Area.SEN,
                name = "선린중학교", address = "서울특별시 용산구 원효로97길 33-4"
            ),

            School(
                Code("B100000658"), Course.HIGH, area = Area.SEN,
                name = "선린인터넷고등학교", address = "서울특별시 용산구 원효로97길 33-4"
            )
        ).filter { keyword in it.name } // 검색어가 포함된 학교만 걸러내기
    }
}
