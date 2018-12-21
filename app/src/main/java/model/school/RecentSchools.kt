package winapi251.app.schoolmeal.model.school

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject

/**
 * 최근 선택한 학교 목록
 * - [Observable]: 기본적으로 UI 스레드에서 구독한다. 학교 목록은 최근순으로 정렬된다.
 */
object RecentSchools : Observable<List<School>>() {
    private val recentSchools by lazy { BehaviorSubject.createDefault(Database.selectAll()) }

    /**
     * [school]을 최근 선택한 학교 목록에 추가한다. 만약, `code` 가 동일한 학교가 이미 존재하면 삭제하고
     * 추가한다.
     */
    operator fun plusAssign(school: School) {
        Database.delete(school.code)
        Database.insert(school)
        notifyDataSetChanged()
    }

    /** [school]의 `code` 와 일치하는 모든 학교를 최근 선택한 학교 목록에서 제거한다. */
    operator fun minusAssign(school: School) {
        Database.delete(school.code)
        notifyDataSetChanged()
    }

    private fun notifyDataSetChanged() {
        val previousList = recentSchools.value
        val currentList = Database.selectAll()

        if (currentList != previousList)
            recentSchools.onNext(currentList)
    }

    override fun subscribeActual(observer: Observer<in List<School>>) {
        recentSchools
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }
}

private object Database {
    fun selectAll(): List<School> = TODO()
    fun insert(school: School): Unit = TODO()
    fun delete(code: School.Code): Unit = TODO()
}
