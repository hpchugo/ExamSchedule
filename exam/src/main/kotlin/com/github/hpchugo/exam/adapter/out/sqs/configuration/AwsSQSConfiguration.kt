package com.github.hpchugo.exam.adapter.out.sqs.configuration

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.sqs.AmazonSQS
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class AwsSQSConfiguration {

    @Value("\${aws.s3.endpoint-url}")
    private val endpointUrl: String = ""

    @Value("\${aws.s3.sqs-queue-arn}")
    private val  sqsQueueARN = "*** SQS Queue ARN ***"

    private val credentials: AWSCredentials = BasicAWSCredentials("admin", "admin")

    @Bean
    open fun amazonSQS(): AmazonSQS? {
        val endpointConfiguration = AwsClientBuilder.EndpointConfiguration(
            endpointUrl,
            Region.getRegion(Regions.US_EAST_1).name
        )
        val awsSQSClient =  AmazonSQSClientBuilder.standard()
            .withCredentials(AWSStaticCredentialsProvider(credentials))
            .withEndpointConfiguration(endpointConfiguration)
            .build()

        awsSQSClient.createQueue(sqsQueueARN)

        return awsSQSClient
    }
}