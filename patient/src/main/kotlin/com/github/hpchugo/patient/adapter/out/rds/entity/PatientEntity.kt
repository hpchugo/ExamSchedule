package com.github.hpchugo.patient.adapter.out.rds.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "patient")
data class PatientEntity @JvmOverloads constructor(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "patient_id")
    var patientId: Int = 0,
    @Column(name = "patient_name")
    var patientName: String = "",
    @Column(name = "patient_document")
    var patientDocument: String = "",
    @Column(name = "patient_email")
    var patientEmail: String = "",
    @Column(name = "patient_password")
    var patientPassword: String = ""
)