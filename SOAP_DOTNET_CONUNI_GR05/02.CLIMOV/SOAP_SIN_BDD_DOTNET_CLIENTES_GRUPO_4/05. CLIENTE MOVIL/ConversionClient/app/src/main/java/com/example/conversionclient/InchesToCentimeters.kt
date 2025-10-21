package com.example.conversionclient

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Element
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory

class InchesToCentimeters : AppCompatActivity() {

    private lateinit var editTextInches: EditText
    private lateinit var buttonConvert: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inchestocentimeters)

        editTextInches = findViewById(R.id.editTextInches)
        buttonConvert = findViewById(R.id.buttonConvert)
        textViewResult = findViewById(R.id.textViewResult)

        buttonConvert.setOnClickListener {
            val inches = editTextInches.text.toString().toDoubleOrNull()
            if (inches != null) {
                val methodName = "PulgadasACentimetros"
                val soapAction = "http://tempuri.org/IConversionUnidadesServicio/$methodName"

                val url = "http://192.168.100.238:8733/Design_Time_Addresses/CONUNIL_GR05/ConversionUnidadesServicio/"
                val xmlInput = """
                    <?xml version="1.0" encoding="utf-8"?>
                    <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tns="http://tempuri.org/">
                        <soap:Body>
                            <tns:$methodName>
                                <tns:pulgadas>$inches</tns:pulgadas>
                            </tns:$methodName>
                        </soap:Body>
                    </soap:Envelope>
                """.trimIndent()

                AsyncTaskHandleSOAP().execute(url, soapAction, xmlInput)
            } else {
                textViewResult.text = "Entrada inválida. Por favor, ingrese un número válido."
            }
        }
    }

    private inner class AsyncTaskHandleSOAP : AsyncTask<String, Void, String>() {

        override fun doInBackground(vararg params: String?): String {
            val urlString = params[0]
            val soapAction = params[1]
            val xmlInput = params[2]

            if (urlString == null || soapAction == null || xmlInput == null) {
                return "Error: Uno o más parámetros son nulos"
            }

            try {
                val url = URL(urlString)
                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "POST"
                connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8")
                connection.setRequestProperty("SOAPAction", soapAction)
                connection.doOutput = true

                val outputStream = connection.outputStream
                outputStream.write(xmlInput.toByteArray())
                outputStream.flush()

                val inputStream = BufferedInputStream(connection.inputStream)
                val response = readStream(inputStream)

                inputStream.close()
                outputStream.close()
                connection.disconnect()

                return response
            } catch (e: Exception) {
                e.printStackTrace()
                return "Error: ${e.message}"
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            try {
                val xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(result?.byteInputStream())
                xmlDoc.documentElement.normalize()

                val resultNode = xmlDoc.getElementsByTagName("PulgadasACentimetrosResult").item(0) as Element
                val conversionResult = resultNode.textContent

                textViewResult.text = "Pulgadas a Centímetros: $conversionResult cm"
            } catch (e: Exception) {
                e.printStackTrace()
                textViewResult.text = "Error al analizar la respuesta XML"
            }
        }

        private fun readStream(inputStream: InputStream): String {
            val outputStream = ByteArrayOutputStream()
            val buffer = ByteArray(1024)
            var bytesRead: Int
            while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                outputStream.write(buffer, 0, bytesRead)
            }
            return outputStream.toString("UTF-8")
        }
    }
}