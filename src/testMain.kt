import java.lang.StringBuilder
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL
import kotlin.jvm.JvmStatic

object testMain {
    private fun getUrlContents(theUrl: String): String {
        val content = StringBuilder()
        try {
            val url = URL(theUrl)
            val urlConnection = url.openConnection()
            val bufferedReader = BufferedReader(InputStreamReader(urlConnection.getInputStream()))
            var line: String
            while (bufferedReader.readLine().also { line = it } != null) {
                content.append(
                    """
    $line
    
    """.trimIndent()
                )
            }
            bufferedReader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return content.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val filepath =
            getUrlContents("https://data.bmkg.go.id/DataMKG/MEWS/DigitalForecast/CSV/kecamatanforecast-sulteng.csv")
        val IDTerm = "5012382"
        val timeTerm = "2022-06-09 12:00:00"
        val ambilData0 = AmbilData(IDTerm, timeTerm, filepath)
        val kodeWilayah = ambilData0.data0
        val tanggal = ambilData0.data11
        val jam = ambilData0.data12
        val kelembapan = ambilData0.data6
        val suhu = ambilData0.data7
        val kodeCuaca = ambilData0.data8
        val arahAngin = ambilData0.data9
        val kecAngin = ambilData0.data10

        // Disini harusnya find Database dulu sesuai ID kecamatan, untuk mendapatkan baris nama Kecamatan, Kabupaten dan Provinsi
        val namaKec = "Ulubongka" // mestinya string ini diambil dari database
        val namaKab = "Tojo Una-Una"
        val namaProv = "Sulawesi Tengah"
        val cuaca: String? = if (kodeCuaca == "0") {
            "Cerah"
        } else if (kodeCuaca == "1") {
            "Cerah Berawan"
        } else if (kodeCuaca == "2") {
            "Cerah Berawan"
        } else if (kodeCuaca == "3") {
            "Berawan"
        } else if (kodeCuaca == "4") {
            "Berawan Tebal"
        } else if (kodeCuaca == "5") {
            "Udara Kabur"
        } else if (kodeCuaca == "10") {
            "Asap"
        } else if (kodeCuaca == "45") {
            "Kabut"
        } else if (kodeCuaca == "60") {
            "Hujan Ringan"
        } else if (kodeCuaca == "61") {
            "Hujan Sedang"
        } else if (kodeCuaca == "63") {
            "Hujan Lebat"
        } else if (kodeCuaca == "80") {
            "Hujan Lokal"
        } else if (kodeCuaca == "95") {
            "Hujan Petir"
        } else if (kodeCuaca == "97") {
            "Hujan Petir"
        } else {
            null
        }


        //System.out.println(clock);
        println(
            """Cuaca di wilayah Kecamatan $namaKec, Kab. $namaKab, $namaProv 
pada tanggal $tanggal pukul $jam waktu setempat diperkirakan akan $cuaca.
Dengan Suhu = $suhu °C
Kelembapan = $kelembapan %
Kecepatan Angin = $kecAngin m/s dari arah $arahAngin."""
        )
    }
}