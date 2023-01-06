package com.github.hpchugo.patient.adapter.out.sqs.configuration

import com.amazon.sqs.javamessaging.ProviderConfiguration
import com.amazon.sqs.javamessaging.SQSConnectionFactory
import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Regions
import com.amazonaws.services.sqs.AmazonSQSClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.support.destination.DynamicDestinationResolver
import javax.jms.Session


@EnableJms
@Configuration
open class AwsSQSConfiguration {

    @Value("\${aws.endpoint-url}")
    private val endpointUrl: String = ""

    @Value("\${aws.s3.sqs-queue-arn}")
    private val  sqsQueueARN = "*** SQS Queue ARN ***"

    @Autowired
    private lateinit var connectionFactory: SQSConnectionFactory

    private val credentials: AWSCredentials = BasicAWSCredentials("admin", "admin")

    @Bean
    open fun createConnectionFactory(): SQSConnectionFactory {
        return SQSConnectionFactory(
            ProviderConfiguration(),
            AmazonSQSClient
                .builder()
                .withEndpointConfiguration(
                    AwsClientBuilder.EndpointConfiguration(
                        "http://localhost:4566",
                        Regions.US_EAST_1.getName()
                    )
                )
                .withCredentials(DefaultAWSCredentialsProviderChain())
                .build()
        )
    }

    @Bean
    open fun jmsListenerContainerFactory(): DefaultJmsListenerContainerFactory {
        val factory = DefaultJmsListenerContainerFactory()
        factory.setConnectionFactory(this.connectionFactory)
        factory.setDestinationResolver(DynamicDestinationResolver())
        factory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE)
        return factory
    }

    @Bean
    open fun defaultJmsTemplate(): JmsTemplate {
        return JmsTemplate(this.connectionFactory)
    }
}