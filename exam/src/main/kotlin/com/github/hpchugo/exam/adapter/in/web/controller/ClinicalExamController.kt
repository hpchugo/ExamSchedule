package com.github.hpchugo.exam.adapter.`in`.web.controller

import com.github.hpchugo.exam.adapter.`in`.web.mapper.toDomain
import com.github.hpchugo.exam.adapter.`in`.web.mapper.toResponse
import com.github.hpchugo.exam.adapter.`in`.web.response.ClinicalExamResponse
import com.github.hpchugo.exam.application.port.`in`.GetClinicalExamsUseCase
import com.github.hpchugo.exam.application.port.`in`.SaveClinicalExamsUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("/v1/clinical-exams")
class ClinicalExamController(
    private val getClinicalExamsUseCase: GetClinicalExamsUseCase,
    private val saveClinicalExamsUseCase: SaveClinicalExamsUseCase
) {

    @GetMapping("/")
    fun getClinicalExams(): ResponseEntity<List<ClinicalExamResponse>> {
        return ResponseEntity.ok(getClinicalExamsUseCase.execute().toResponse())
    }

    @PostMapping("/")
    fun postClinicalExam(@RequestBody clinicalExamResponse: ClinicalExamResponse) {
        ResponseEntity(
            saveClinicalExamsUseCase.execute(
                ClinicalExamResponse(
                    examId = UUID.randomUUID().toString(),
                    examName = clinicalExamResponse.examName
                ).toDomain()
            ), HttpStatus.NO_CONTENT
        )
    }
}