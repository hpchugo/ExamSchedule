package com.github.hpchugo.patient.application.port.`in`

import com.github.hpchugo.patient.domain.Patient

interface SavePatientUseCase {
    fun execute(patient: Patient)
}