package com.github.hpchugo.exam.adapter.out.dynamodb.entity

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import org.springframework.data.annotation.Id

@DynamoDBTable(tableName = "ClinicalExams")
data class ClinicalExamEntity @JvmOverloads constructor(
    @Id
    @DynamoDBAutoGeneratedKey
    @DynamoDBHashKey(attributeName = "examId")
    var examId: String = "",
    @DynamoDBAttribute(attributeName = "examName")
    var examName: String = ""
)