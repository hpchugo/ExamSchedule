package com.github.hpchugo.exam.domain

import java.io.InputStream

data class ClinicalExamReport(
    val patientDocument: String,
    val fileName: String,
    val contentLength: Long,
    val inputStream: InputStream
)
