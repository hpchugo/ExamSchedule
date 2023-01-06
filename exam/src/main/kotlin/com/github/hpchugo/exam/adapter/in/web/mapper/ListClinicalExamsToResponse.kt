package com.github.hpchugo.exam.adapter.`in`.web.mapper

import com.github.hpchugo.exam.adapter.`in`.web.response.ClinicalExamResponse
import com.github.hpchugo.exam.domain.ClinicalExam

fun List<ClinicalExam>.toResponse() = this.map {
    ClinicalExamResponse(
        examId = it.examId,
        examName = it.examName
    )
}