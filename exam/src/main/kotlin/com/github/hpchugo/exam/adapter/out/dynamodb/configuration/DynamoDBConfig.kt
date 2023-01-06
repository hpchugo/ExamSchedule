package com.github.hpchugo.exam.adapter.out.dynamodb.configuration

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig
import com.github.hpchugo.exam.adapter.out.dynamodb.SpringDataDynamoDBClinicalExamRepository
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary


@Configuration
@EnableDynamoDBRepositories(basePackageClasses = [SpringDataDynamoDBClinicalExamRepository::class])
open class DynamoDBConfig {
    @Value("\${aws.dynamodb.endpoint}")
    private val awsEndpoint: String? = null

    @Value("\${aws.accesskey}")
    private val awsAccessKey: String? = null

    @Value("\${aws.secretkey}")
    private val awsSecretKey: String? = null

    @Value("\${aws.region}")
    private val awsRegion: String? = null


    private val amazonDynamoDB = AmazonDynamoDBClient.builder()
        .withEndpointConfiguration(EndpointConfiguration("http://localhost:4566", "us-east-1"))
        .withCredentials(DefaultAWSCredentialsProviderChain())
        .build()

    @Bean
    @Primary
    open fun dynamoDBMapperConfig(): DynamoDBMapperConfig? {
        return DynamoDBMapperConfig.DEFAULT
    }

    @Bean
    @Primary
    open fun dynamoDBMapper(amazonDynamoDB: AmazonDynamoDB?, config: DynamoDBMapperConfig?): DynamoDBMapper? {
        return DynamoDBMapper(amazonDynamoDB, config)
    }

    @Bean
    @Primary
    open fun amazonDynamoDB(): AmazonDynamoDB? {
        return amazonDynamoDB
    }
}