package com.github.hpchugo.exam.application.service

import com.github.hpchugo.exam.application.port.`in`.SendMessageClinicalExamReportUseCase
import com.github.hpchugo.exam.application.port.out.SendMessageClinicalExamReportPort
import org.springframework.stereotype.Service

@Service
class SendMessageClinicalExamReportService(
    private val sendMessageClinicalExamReportPort: SendMessageClinicalExamReportPort
) : SendMessageClinicalExamReportUseCase {
    override fun execute(patientDocument: String){
        sendMessageClinicalExamReportPort.execute(patientDocument)
    }

}