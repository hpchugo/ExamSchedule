package com.github.hpchugo.exam.adapter.`in`.web.response

import java.io.InputStream

data class ClinicalExamReportResponse(
    val patientDocument: String,
    val fileName: String,
    val contentLength: Long,
    val inputStream: InputStream
)
