package com.github.hpchugo.exam.application.service

import com.github.hpchugo.exam.application.port.`in`.GetClinicalExamReportUseCase
import com.github.hpchugo.exam.application.port.out.GetClinicalExamReportPort
import com.github.hpchugo.exam.domain.ClinicalExamReport
import org.springframework.stereotype.Service

@Service
class GetClinicalExamReportService(
    private val getClinicalExamReportPort: GetClinicalExamReportPort
) : GetClinicalExamReportUseCase {
    override fun execute(patientDocument: String): ClinicalExamReport = getClinicalExamReportPort.execute(patientDocument)

}