package com.github.hpchugo.patient.adapter.`in`.web.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PatientResponse(
    val patient: PatientInfoResponse? = null
){
    data class PatientInfoResponse(
        val patientName: String = "",
        val patientDocument: String = "",
        val patientEmail: String = "",
        val patientPassword: String = ""
    )
}


