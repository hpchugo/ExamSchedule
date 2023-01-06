package com.github.hpchugo.patient.adapter.out.sns.configuration

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Regions
import com.amazonaws.services.sns.AmazonSNS
import com.amazonaws.services.sns.AmazonSNSClient
import com.amazonaws.services.sns.model.CreateTopicRequest
import com.amazonaws.services.sns.model.Topic
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AwsSNSConfiguration {
    private val reportUploadedEventTopic: String
    private val snsClient: AmazonSNS = AmazonSNSClient
        .builder()
        .withEndpointConfiguration(
            AwsClientBuilder.EndpointConfiguration(
                "http://localhost:4566",
                Regions.US_EAST_1.getName()
            )
        )
        .withCredentials(DefaultAWSCredentialsProviderChain())
        .build()

    init {
        val createTopicRequest = CreateTopicRequest("report-uploaded")
        reportUploadedEventTopic = snsClient.createTopic(createTopicRequest).topicArn
        LOG.info("SNS topic ARN? {}", reportUploadedEventTopic)
    }

    @Bean
    open fun getSnsClient(): AmazonSNS {
        return snsClient
    }

    @Bean(name = ["reportUploadedEventTopic"])
    open fun snsProductEventsTopic(): Topic {
        return Topic().withTopicArn(reportUploadedEventTopic)
    }

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(AwsSNSConfiguration::class.java)
    }
}