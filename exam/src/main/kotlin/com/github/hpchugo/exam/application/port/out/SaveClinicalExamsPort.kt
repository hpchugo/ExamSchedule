package com.github.hpchugo.exam.application.port.out

import com.github.hpchugo.exam.domain.ClinicalExam

interface SaveClinicalExamsPort {
    fun execute(clinicalExam: ClinicalExam)
}