package com.github.hpchugo.exam.adapter.out.dynamodb

import com.github.hpchugo.exam.adapter.out.dynamodb.entity.ClinicalExamEntity
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@EnableScan
@Repository
interface SpringDataDynamoDBClinicalExamRepository : CrudRepository<ClinicalExamEntity, String>{

}