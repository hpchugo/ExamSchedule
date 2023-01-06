package com.github.hpchugo.exam.application.port.out

interface SendMessageClinicalExamReportPort {
    fun execute(patientDocument: String)
}