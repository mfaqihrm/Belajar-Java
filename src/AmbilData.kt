import java.util.*

class AmbilData internal constructor(IDTerm: String, timeTerm: String, filepath: String?) {
    var data0: String? = null
    var data1: String? = null
    var data2: String? = null
    var data3: String? = null
    var data4: String? = null
    var data5: String? = null
    var data6: String? = null
    var data7: String? = null
    var data8: String? = null
    var data9: String? = null
    var data10: String? = null
    var data11: String? = null
    var data12: String? = null

    companion object {
        private lateinit var x: Scanner
    }

    /*  data0 = ID          data6 = rhNow           data11 = date
    *   data1 = time        data7 = tempNow         data12 = clock
    *   data2 = tempMin     data8 = weatherCode
    *   data3 = tempMax     data9 = windDirect
    *   data4 = rhMin       data10 = windSpeed
    *   data5 = rhMax
    * */
    init {
        var found = false
        x = Scanner(filepath)
        x.useDelimiter("[;\n]")
        while (x.hasNext() && !found) {
            data0 = x.next()
            data1 = x.next()
            data2 = x.next()
            data3 = x.next()
            data4 = x.next()
            data5 = x.next()
            data6 = x.next()
            data7 = x.next()
            data8 = x.next()
            data9 = x.next()
            data10 = x.next()
            if (data0 == IDTerm && data1 == timeTerm) {
                found = true
            }
        }
        val y = Scanner(data1)
        y.useDelimiter(" ")
        while (y.hasNext()) {
            data11 = y.next()
            data12 = y.next()
        }
    }
}