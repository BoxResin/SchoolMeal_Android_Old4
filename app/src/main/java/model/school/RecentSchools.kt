package winapi251.app.schoolmeal.model.school

import io.reactivex.Observable
import io.reactivex.Observer

/**
 * 최근 선택한 학교 목록
 * - [Observable]: 기본적으로 UI 스레드에서 구독한다. 학교 목록은 최근순으로 정렬된다.
 */
object RecentSchools : Observable<List<School>>() {
    /** [school]을 최근 선택한 학교 목록에 추가한다. */
    operator fun plusAssign(school: School): Unit = TODO()

    /** [school]을 최근 선택한 학교 목록에서 제거한다. */
    operator fun minusAssign(school: School): Unit = TODO()

    override fun subscribeActual(observer: Observer<in List<School>>): Unit = TODO()
}
