package com.github.hpchugo.exam.application.port.`in`

import com.github.hpchugo.exam.domain.ClinicalExamReport

interface GetClinicalExamReportUseCase {
    fun execute(patientDocument: String): ClinicalExamReport
}