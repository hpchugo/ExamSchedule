package com.github.hpchugo.exam.application.service

import com.github.hpchugo.exam.application.port.`in`.GetClinicalExamsUseCase
import com.github.hpchugo.exam.application.port.out.GetClinicalExamsPort
import com.github.hpchugo.exam.domain.ClinicalExam
import org.springframework.stereotype.Component

@Component
class GetClinicalExamsService(private val getClinicalExamsPort: GetClinicalExamsPort) : GetClinicalExamsUseCase{
    override fun execute(): List<ClinicalExam> {
        return getClinicalExamsPort.execute()
    }

}