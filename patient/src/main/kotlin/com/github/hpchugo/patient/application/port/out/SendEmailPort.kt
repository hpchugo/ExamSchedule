package com.github.hpchugo.patient.application.port.out

interface SendEmailPort {
    fun execute(message: String, email: String?)
}