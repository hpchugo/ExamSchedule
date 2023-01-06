package com.github.hpchugo.patient.adapter.`in`.web.controller

import com.github.hpchugo.patient.adapter.`in`.web.mapper.toDomain
import com.github.hpchugo.patient.adapter.`in`.web.mapper.toResponse
import com.github.hpchugo.patient.adapter.`in`.web.response.PatientResponse
import com.github.hpchugo.patient.application.port.`in`.GetPatientByDocument
import com.github.hpchugo.patient.application.port.`in`.SavePatientUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/patient")
class PatientController(
    private val getPatientByDocument: GetPatientByDocument,
    private val saveClinicalExamsUseCase: SavePatientUseCase
) {

    @GetMapping("/{patientDocument}")
    fun getPatientByDocument(@PathVariable patientDocument: String): ResponseEntity<PatientResponse> {
        return ResponseEntity.ok(getPatientByDocument.execute(patientDocument)?.toResponse() ?: PatientResponse())
    }

    @PostMapping("/")
    fun postClinicalExam(@RequestBody patient: PatientResponse) {
        ResponseEntity(patient.toDomain()?.let { saveClinicalExamsUseCase.execute(it) }, HttpStatus.NO_CONTENT)
    }
}