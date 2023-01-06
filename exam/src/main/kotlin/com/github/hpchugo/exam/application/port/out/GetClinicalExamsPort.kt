package com.github.hpchugo.exam.application.port.out

import com.github.hpchugo.exam.domain.ClinicalExam

interface GetClinicalExamsPort {
    fun execute(): List<ClinicalExam>
}