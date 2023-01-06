package com.github.hpchugo.exam.application.port.`in`

import org.springframework.web.multipart.MultipartFile

interface RegisterClinicalExamReportUseCase {
    fun execute(patientDocument: String, file: MultipartFile)
}