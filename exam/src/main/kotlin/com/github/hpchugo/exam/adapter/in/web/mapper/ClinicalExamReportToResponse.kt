package com.github.hpchugo.exam.adapter.`in`.web.mapper

import com.github.hpchugo.exam.adapter.`in`.web.response.ClinicalExamReportResponse
import com.github.hpchugo.exam.domain.ClinicalExamReport

fun ClinicalExamReport.toResponse() = ClinicalExamReportResponse(
    patientDocument = this.patientDocument,
    fileName = this.fileName,
    contentLength = this.contentLength,
    inputStream = this.inputStream
)