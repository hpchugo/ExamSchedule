package com.github.hpchugo.exam.application.port.`in`

interface SendMessageClinicalExamReportUseCase {
    fun execute(patientDocument: String)
}