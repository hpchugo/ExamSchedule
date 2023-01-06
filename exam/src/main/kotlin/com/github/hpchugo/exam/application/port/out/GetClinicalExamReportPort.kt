package com.github.hpchugo.exam.application.port.out

import com.github.hpchugo.exam.domain.ClinicalExamReport

interface GetClinicalExamReportPort {
    fun execute(patientDocument: String): ClinicalExamReport
}