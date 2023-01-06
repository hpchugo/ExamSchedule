package com.github.hpchugo.exam.adapter.out.s3

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.ObjectMetadata
import com.github.hpchugo.exam.application.port.out.RegisterClinicalExamReportPort
import org.apache.commons.io.FilenameUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Path
import java.nio.file.Paths

private const val FILE_EXTENSION = "pdf"

@Component
class RegisterClinicalExamReportAdapter : RegisterClinicalExamReportPort {

    @Autowired
    private lateinit var amazonS3: AmazonS3

    @Value("\${aws.s3.bucket-name}")
    private val bucketName: String? = null

    override fun execute(patientDocument: String, file: MultipartFile) {
        initializeBucket()
        val root: Path = Paths.get("patients")
        file.transferTo(root)
        val fileInputStream = file.inputStream
        amazonS3.putObject(bucketName, patientDocument, fileInputStream, extractObjectMetadata(file))
    }

    private fun initializeBucket(){
        if (!amazonS3.doesBucketExistV2(bucketName)) {
            amazonS3.createBucket(bucketName)
        }
    }

    private fun extractObjectMetadata(file: MultipartFile): ObjectMetadata {
        val objectMetadata = ObjectMetadata()
        objectMetadata.contentLength = file.size
        objectMetadata.contentType = file.contentType
        objectMetadata.userMetadata[FILE_EXTENSION] = FilenameUtils.getExtension(file.originalFilename)
        return objectMetadata
    }
}