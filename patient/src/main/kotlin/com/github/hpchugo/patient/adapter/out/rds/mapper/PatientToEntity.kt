package com.github.hpchugo.patient.adapter.out.rds.mapper

import com.github.hpchugo.patient.adapter.out.rds.entity.PatientEntity
import com.github.hpchugo.patient.domain.Patient

fun Patient.toEntity() = PatientEntity(
    patientName = this.patientName,
    patientDocument = this.patientDocument,
    patientEmail = this.patientEmail,
    patientPassword = this.patientPassword
)