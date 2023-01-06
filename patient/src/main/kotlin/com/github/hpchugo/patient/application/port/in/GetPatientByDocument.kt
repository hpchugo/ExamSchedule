package com.github.hpchugo.patient.application.port.`in`

import com.github.hpchugo.patient.domain.Patient

interface GetPatientByDocument {
    fun execute(document: String): Patient?
}