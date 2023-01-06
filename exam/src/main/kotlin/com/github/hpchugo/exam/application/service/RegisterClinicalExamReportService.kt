package com.github.hpchugo.exam.application.service

import com.github.hpchugo.exam.application.port.`in`.RegisterClinicalExamReportUseCase
import com.github.hpchugo.exam.application.port.out.RegisterClinicalExamReportPort
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class RegisterClinicalExamReportService(
    private val registerClinicalExamReportPort: RegisterClinicalExamReportPort
) : RegisterClinicalExamReportUseCase{
    override fun execute(patientDocument: String, file: MultipartFile) {
        registerClinicalExamReportPort.execute(patientDocument, file)
    }
}