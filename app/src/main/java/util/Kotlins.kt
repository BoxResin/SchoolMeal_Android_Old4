/** 코틀린 관련 유틸리티 */
package winapi251.app.schoolmeal.util

/** [block]을 실행하면서 발생하는 모든 예외를 삼킨다. */
inline fun safe(crossinline block: () -> Unit) {
    try {
        block()
    } catch (ignored: Throwable) {
    }
}
