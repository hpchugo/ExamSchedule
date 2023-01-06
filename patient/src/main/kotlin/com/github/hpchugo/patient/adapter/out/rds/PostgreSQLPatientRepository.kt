package com.github.hpchugo.patient.adapter.out.rds

import com.github.hpchugo.patient.adapter.out.rds.mapper.toDomain
import com.github.hpchugo.patient.adapter.out.rds.mapper.toEntity
import com.github.hpchugo.patient.application.port.out.GetPatientByDocumentPort
import com.github.hpchugo.patient.application.port.out.SaveClinicalExamsPort
import com.github.hpchugo.patient.domain.Patient
import org.springframework.stereotype.Service

@Service
class PatientRepository(private val springDataPostgreSQLPatientRepository: SpringDataPostgreSQLPatientRepository) :
    GetPatientByDocumentPort, SaveClinicalExamsPort {

    override fun execute(patientDocument: String): Patient? {
        return springDataPostgreSQLPatientRepository.findByPatientDocument(patientDocument)?.toDomain()
    }

    override fun execute(patient: Patient) {
        springDataPostgreSQLPatientRepository.save(patient.toEntity())
    }
}