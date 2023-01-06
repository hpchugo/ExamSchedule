package com.github.hpchugo.exam.application.port.`in`

import com.github.hpchugo.exam.domain.ClinicalExam

interface GetClinicalExamsUseCase {
    fun execute(): List<ClinicalExam>
}