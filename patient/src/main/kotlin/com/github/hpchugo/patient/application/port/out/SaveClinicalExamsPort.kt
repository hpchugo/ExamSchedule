package com.github.hpchugo.patient.application.port.out

import com.github.hpchugo.patient.domain.Patient

interface SaveClinicalExamsPort {
    fun execute(patient: Patient)
}