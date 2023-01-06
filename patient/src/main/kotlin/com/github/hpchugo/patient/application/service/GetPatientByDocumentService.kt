package com.github.hpchugo.patient.application.service

import com.github.hpchugo.patient.application.port.`in`.GetPatientByDocument
import com.github.hpchugo.patient.application.port.out.GetPatientByDocumentPort
import com.github.hpchugo.patient.domain.Patient
import org.springframework.stereotype.Component

@Component
class GetPatientByDocumentService(private val getPatientByDocumentPort: GetPatientByDocumentPort) : GetPatientByDocument {
    override fun execute(document: String): Patient? {
        return getPatientByDocumentPort.execute(document)
    }

}