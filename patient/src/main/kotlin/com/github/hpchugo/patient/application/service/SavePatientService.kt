package com.github.hpchugo.patient.application.service

import com.github.hpchugo.patient.application.port.`in`.SavePatientUseCase
import com.github.hpchugo.patient.application.port.out.SaveClinicalExamsPort
import com.github.hpchugo.patient.domain.Patient
import org.springframework.stereotype.Component

@Component
class SavePatientService(private val saveClinicalExamsPort: SaveClinicalExamsPort) : SavePatientUseCase {
    override fun execute(patient: Patient) {
        return saveClinicalExamsPort.execute(patient)
    }

}