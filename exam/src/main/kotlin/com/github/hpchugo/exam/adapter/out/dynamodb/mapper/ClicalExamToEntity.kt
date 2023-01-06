package com.github.hpchugo.exam.adapter.out.dynamodb.mapper

import com.github.hpchugo.exam.adapter.out.dynamodb.entity.ClinicalExamEntity
import com.github.hpchugo.exam.domain.ClinicalExam

fun ClinicalExam.toEntity() = ClinicalExamEntity(examId = this.examId, examName = this.examName)