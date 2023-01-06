package com.github.hpchugo.patient.adapter.out.sqs

import com.github.hpchugo.patient.application.port.out.GetPatientByDocumentPort
import com.github.hpchugo.patient.application.port.out.ReadMessagePatientDocumentPort
import com.github.hpchugo.patient.application.port.out.SendEmailPort
import org.springframework.beans.factory.annotation.Value
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component
import javax.jms.TextMessage


@Component
class ReadMessagePatientDocumentAdapter(
    private val getPatientByDocumentPort: GetPatientByDocumentPort,
    private val sendEmailPort: SendEmailPort
) : ReadMessagePatientDocumentPort {

    @Value("\${aws.s3.sqs-queue-arn}")
    private val sqsQueueARN = "*** SQS Queue ARN ***"

    @JmsListener(destination = "patient-email-request")
    override fun execute(textMessage: TextMessage): String? {
        val patient = getPatientByDocumentPort.execute(textMessage.text)
        sendEmailPort.execute("O resultado do seu exame está pronto", patient?.patientEmail)
        return patient?.patientEmail
    }
}