package util

import org.junit.Test
import winapi251.app.schoolmeal.util.safe
import java.lang.Math.round

class KotlinsKtTest {
    @Test
    fun safe() {
        // 예외가 발생하면 안 된다.
        safe {
            val a = 100
            val b = round(0f)
            println(a / b)
        }
    }
}
