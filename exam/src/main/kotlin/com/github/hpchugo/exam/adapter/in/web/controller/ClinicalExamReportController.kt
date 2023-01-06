package com.github.hpchugo.exam.adapter.`in`.web.controller

import com.github.hpchugo.exam.application.port.`in`.GetClinicalExamReportUseCase
import com.github.hpchugo.exam.application.port.`in`.RegisterClinicalExamReportUseCase
import com.github.hpchugo.exam.application.port.`in`.SendMessageClinicalExamReportUseCase
import org.apache.commons.io.IOUtils
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/v1/clinical-exams/reports/")
class ClinicalExamReportController(
    private val registerClinicalExamReportUseCase: RegisterClinicalExamReportUseCase,
    private val getClinicalExamReportUseCase: GetClinicalExamReportUseCase,
    private val sendMessageClinicalExamReportUseCase: SendMessageClinicalExamReportUseCase
) {
    @PostMapping("/{patientDocument}", consumes = ["multipart/form-data"])
    fun registerClinicalExamReport(@PathVariable patientDocument: String, @RequestBody file: MultipartFile) {
        registerClinicalExamReportUseCase.execute(patientDocument, file)
        sendMessageClinicalExamReportUseCase.execute(patientDocument)
    }

    @ResponseBody
    @GetMapping("/{patientDocument}", produces = [MediaType.APPLICATION_PDF_VALUE])
    fun getClinicalExamReport(@PathVariable patientDocument: String): ByteArray {
        return IOUtils.toByteArray(getClinicalExamReportUseCase.execute(patientDocument).inputStream)
    }
}