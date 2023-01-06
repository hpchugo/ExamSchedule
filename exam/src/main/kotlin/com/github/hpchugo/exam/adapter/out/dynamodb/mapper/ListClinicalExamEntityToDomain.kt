package com.github.hpchugo.exam.adapter.out.dynamodb.mapper

import com.github.hpchugo.exam.adapter.out.dynamodb.entity.ClinicalExamEntity
import com.github.hpchugo.exam.domain.ClinicalExam

fun List<ClinicalExamEntity>.toDomain() = this.map {
    ClinicalExam(examId = it.examId, examName = it.examName)
}
