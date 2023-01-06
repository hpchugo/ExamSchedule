package com.github.hpchugo.exam.application.port.out

import org.springframework.web.multipart.MultipartFile

interface RegisterClinicalExamReportPort {
    fun execute(patientDocument: String, file: MultipartFile)
}