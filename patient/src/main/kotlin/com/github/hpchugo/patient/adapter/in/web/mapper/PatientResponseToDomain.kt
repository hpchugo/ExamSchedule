package com.github.hpchugo.patient.adapter.`in`.web.mapper

import com.github.hpchugo.patient.adapter.`in`.web.response.PatientResponse
import com.github.hpchugo.patient.domain.Patient

fun PatientResponse.toDomain() = this.patient?.let { patient ->
    Patient(
        patientName = patient.patientName,
        patientDocument = patient.patientDocument,
        patientEmail = patient.patientEmail,
        patientPassword = patient.patientPassword
    )
}