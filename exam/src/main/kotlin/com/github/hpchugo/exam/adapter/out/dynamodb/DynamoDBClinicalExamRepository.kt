package com.github.hpchugo.exam.adapter.out.dynamodb

import com.github.hpchugo.exam.adapter.out.dynamodb.mapper.toDomain
import com.github.hpchugo.exam.adapter.out.dynamodb.mapper.toEntity
import com.github.hpchugo.exam.application.port.out.GetClinicalExamsPort
import com.github.hpchugo.exam.application.port.out.SaveClinicalExamsPort
import com.github.hpchugo.exam.domain.ClinicalExam
import org.springframework.stereotype.Service

@Service
class DynamoDBClinicalExamRepository(private val springDataDynamoDBClinicalExamRepository: SpringDataDynamoDBClinicalExamRepository) :
    GetClinicalExamsPort, SaveClinicalExamsPort {

    override fun execute(): List<ClinicalExam> {
        return springDataDynamoDBClinicalExamRepository.findAll().toList().toDomain()
    }

    override fun execute(clinicalExam: ClinicalExam) {
        springDataDynamoDBClinicalExamRepository.save(clinicalExam.toEntity())
    }
}