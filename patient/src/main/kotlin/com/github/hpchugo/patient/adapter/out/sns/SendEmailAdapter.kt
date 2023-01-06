package com.github.hpchugo.patient.adapter.out.sns

import com.amazonaws.services.sns.AmazonSNSClient
import com.amazonaws.services.sns.AmazonSNS
import com.amazonaws.services.sns.model.PublishRequest
import com.amazonaws.services.sns.model.PublishResult
import com.amazonaws.services.sns.model.SubscribeRequest
import com.amazonaws.services.sns.model.Topic
import com.amazonaws.services.sns.model.UnsubscribeRequest
import com.github.hpchugo.patient.application.port.out.SendEmailPort
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


@Service
class SendEmailAdapter(
    private val snsClient: AmazonSNS,
    private val amazonSNSClient: AmazonSNSClient,
    @Qualifier("reportUploadedEventTopic") reportUploadedEventTopic: Topic
) : SendEmailPort {
    private val reportUploadedEventTopic: Topic

    init {
        this.reportUploadedEventTopic = reportUploadedEventTopic
    }

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(
            SendEmailAdapter::class.java
        )
    }


    override fun execute(message: String, email: String?) {
        val topic = reportUploadedEventTopic.topicArn
        val subscribeRequest = SubscribeRequest(topic, "email", email)
        LOG.info("Sending e-mail notification of the results of the exams to: $email")

        val subscribeResult = amazonSNSClient.subscribe(subscribeRequest)
        LOG.info("MessageId: ${subscribeResult.subscriptionArn}")

        val publishRequest = PublishRequest(topic, message, email)
        val publishResult: PublishResult = snsClient.publish(publishRequest)
        LOG.info("MessageId: ${publishResult.messageId}")

        amazonSNSClient.unsubscribe(UnsubscribeRequest(subscribeResult.subscriptionArn))
    }
}