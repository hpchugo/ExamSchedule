package com.github.hpchugo.exam.adapter.out.s3.configuration

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.BucketNotificationConfiguration
import com.amazonaws.services.s3.model.S3Event
import com.amazonaws.services.s3.model.SetBucketNotificationConfigurationRequest
import com.amazonaws.services.s3.model.TopicConfiguration
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*


@Configuration
open class AwsS3Configuration {

    @Value("\${aws.accesskey}")
    private val accessKey: String = ""

    @Value("\${aws.secretkey}")
    private val secretKey: String = ""

    @Value("\${aws.s3.endpoint-url}")
    private val endpointUrl: String = ""

    @Value("\${aws.s3.bucket-name}")
    private val bucketName: String? = null

    @Value("\${aws.s3.sns-topic-arn}")
    private val  snsTopicARN = "*** SNS Topic ARN ***"

    @Value("\${aws.s3.sqs-queue-arn}")
    private val  sqsQueueARN = "*** SQS Queue ARN ***"

    private val credentials: AWSCredentials = BasicAWSCredentials("admin", "admin")

    @Bean
    open fun amazonS3(): AmazonS3? {
        val endpointConfiguration = AwsClientBuilder.EndpointConfiguration(
            endpointUrl,
            Region.getRegion(Regions.US_EAST_1).name
        )
        return AmazonS3ClientBuilder.standard()
            .withCredentials(AWSStaticCredentialsProvider(credentials))
            .withEndpointConfiguration(endpointConfiguration)
            .withPathStyleAccessEnabled(true)
            .build()

    }
}