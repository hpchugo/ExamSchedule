package com.github.hpchugo.patient.application.port.out

import javax.jms.TextMessage

interface ReadMessagePatientDocumentPort {
    fun execute(textMessage: TextMessage): String?
}