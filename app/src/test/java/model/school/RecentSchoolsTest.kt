package model.school

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import winapi251.app.schoolmeal.model.Area
import winapi251.app.schoolmeal.model.school.RecentSchools
import winapi251.app.schoolmeal.model.school.School

@RunWith(AndroidJUnit4::class)
class RecentSchoolsTest {
    private val testObserver = RecentSchools.test()

    /** [School] 추가 테스트 */
    @Test
    fun insert() {
        val school = School(School.Code("test"), School.Course.HIGH, "테스트", "테스트", Area.SEN)
        RecentSchools += school

        testObserver.assertValues(emptyList(), listOf(school))

        // 다음 테스트를 위해 원래 상태로 되돌리기
        RecentSchools -= school
    }

    /** [School.Code]를 기준으로 레코드를 삭제하는지 검사한다. */
    @Test
    fun delete() {
        val school = School(School.Code("test"), School.Course.HIGH, "테스트", "테스트", Area.SEN)
        val school2 = School(School.Code("test"), School.Course.HIGH, "ASDF", "ASDF", Area.KWE)

        RecentSchools += school
        RecentSchools -= school2

        testObserver.assertValues(emptyList(), listOf(school), emptyList())
    }

    /** 데이터 중복 방지 테스트 */
    @Test
    fun duplication() {
        val school = School(School.Code("test"), School.Course.HIGH, "테스트", "테스트", Area.SEN)
        RecentSchools += school
        RecentSchools += school
        RecentSchools += school

        testObserver.assertValues(emptyList(), listOf(school))

        // 다음 테스트를 위해 원래 상태로 되돌리기
        RecentSchools -= school
    }
}
