package com.github.hpchugo.exam.adapter.`in`.web.mapper

import com.github.hpchugo.exam.adapter.`in`.web.response.ClinicalExamResponse
import com.github.hpchugo.exam.domain.ClinicalExam

fun ClinicalExamResponse.toDomain() = ClinicalExam(examId = this.examId ?: "", examName = this.examName)