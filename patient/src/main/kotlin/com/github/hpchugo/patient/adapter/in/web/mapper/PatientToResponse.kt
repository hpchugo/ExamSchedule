package com.github.hpchugo.patient.adapter.`in`.web.mapper

import com.github.hpchugo.patient.adapter.`in`.web.response.PatientResponse
import com.github.hpchugo.patient.domain.Patient

fun Patient.toResponse() = PatientResponse(
    patient = PatientResponse.PatientInfoResponse(
        patientName = this.patientName,
        patientDocument = this.patientDocument,
        patientEmail = this.patientEmail,
        patientPassword = this.patientPassword
    )
)