package com.github.hpchugo.patient.adapter.out.rds

import com.github.hpchugo.patient.adapter.out.rds.entity.PatientEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SpringDataPostgreSQLPatientRepository : CrudRepository<PatientEntity, Int>{
    fun findByPatientDocument(patientDocument: String): PatientEntity?
}