package winapi251.app.schoolmeal

import android.app.Application

/** 커스텀 애플리케이션 */
class SchoolMealApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // 전역변수 앱 컨텍스트 초기화
        appContext = this.applicationContext
    }
}
