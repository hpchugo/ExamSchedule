package com.github.hpchugo.exam.adapter.out.sqs

import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.model.SendMessageRequest
import com.github.hpchugo.exam.application.port.out.SendMessageClinicalExamReportPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Component
class SendMessageClinicalExamReportAdapter : SendMessageClinicalExamReportPort {

    @Value("\${aws.s3.sqs-queue-arn}")
    private val  sqsQueueARN = "*** SQS Queue ARN ***"

    @Autowired
    private lateinit var amazonSQS: AmazonSQS

    @Value("\${aws.s3.bucket-name}")
    private val bucketName: String? = null

    override fun execute(patientDocument: String) {
        val sendMsgRequest = SendMessageRequest()
            .withQueueUrl(sqsQueueARN)
            .withMessageBody(patientDocument)
            .withDelaySeconds(5)
        amazonSQS.sendMessage(sendMsgRequest)
    }

}