package com.github.hpchugo.exam.adapter.out.s3

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.S3Object
import com.github.hpchugo.exam.application.port.out.GetClinicalExamReportPort
import com.github.hpchugo.exam.domain.ClinicalExamReport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

private const val FILE_EXTENSION = "pdf"

@Component
class GetClinicalExamReportAdapter : GetClinicalExamReportPort {

    @Autowired
    private lateinit var amazonS3: AmazonS3

    @Value("\${aws.s3.bucket-name}")
    private val bucketName: String? = null

    override fun execute(patientDocument: String): ClinicalExamReport {
        val s3Object: S3Object = amazonS3.getObject(bucketName, patientDocument)
        val filename: String = patientDocument + "." + s3Object.objectMetadata.userMetadata[FILE_EXTENSION]
        val contentLength: Long = s3Object.objectMetadata.contentLength
        return ClinicalExamReport(patientDocument, filename, contentLength, s3Object.objectContent)
    }

}