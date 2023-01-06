package com.github.hpchugo.exam.application.service

import com.github.hpchugo.exam.application.port.`in`.SaveClinicalExamsUseCase
import com.github.hpchugo.exam.application.port.out.SaveClinicalExamsPort
import com.github.hpchugo.exam.domain.ClinicalExam
import org.springframework.stereotype.Component

@Component
class SaveClinicalExamsService(private val saveClinicalExamsPort: SaveClinicalExamsPort) : SaveClinicalExamsUseCase {
    override fun execute(clinicalExam: ClinicalExam) {
        return saveClinicalExamsPort.execute(clinicalExam)
    }

}