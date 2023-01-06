/*
@file:Suppress("unused")

package com.github.hpchugo.patient.adapter.out.rds.configuration

import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.rds.AmazonRDS
import com.amazonaws.services.rds.AmazonRDSClientBuilder
import com.amazonaws.services.rds.model.CreateDBInstanceRequest
import com.amazonaws.services.rds.model.DBInstance
import com.amazonaws.services.rds.model.DeleteDBInstanceRequest
import com.amazonaws.services.rds.model.Endpoint

import java.util.logging.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import java.io.IOException
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import java.util.*

val logger: Logger = Logger.getLogger(RDSConfig::class.java.name)


@Configuration
open class RDSConfig {

    private var credentials: AWSCredentialsProvider? = null
    private var amazonRDS: AmazonRDS? = null

    @Value("spring.datasource.url")
    private var hostname: String? = null

    @Value("spring.datasource.database")
    private var database: String? = null

    @Value("spring.datasource.username")
    private var username: String? = null

    @Value("spring.datasource.password")
    private var password: String? = null

    */
/*
    * User access key and secret key must be set before execute any operation.
    * Follow the link on how to get the user access and secret key
    * https://aws.amazon.com/blogs/security/wheres-my-secret-access-key/
    * **//*

    constructor() {
        //Init RDS client with credentials and region.
        credentials = AWSStaticCredentialsProvider(
            BasicAWSCredentials(
                "<ACCESS_KEY>",
                "<SECRET_KEY>"
            )
        )
        amazonRDS = AmazonRDSClientBuilder.standard().withCredentials(credentials)
            .withRegion(Regions.US_EAST_1).build()
    }

    constructor(amazonRDS: AmazonRDS?) {
        this.amazonRDS = amazonRDS
    }

    */
/**
     * create the RDS instance.
     * After instance creation, update the db_hostname with endpoint in db.properties.
     *//*

    open fun launchInstance(): String? {
        val request = CreateDBInstanceRequest()
        // RDS instance name
        request.dbInstanceIdentifier = "Sydney"
        request.engine = "postgres"
        request.isMultiAZ = false
        request.masterUsername = username
        request.masterUserPassword = password
        request.dbName = database
        request.storageType = "gp2"
        request.allocatedStorage = 10
        val instance: DBInstance = amazonRDS!!.createDBInstance(request)

        // Information about the new RDS instance
        val identifier = instance.dbInstanceIdentifier
        val status: String = instance.dbInstanceStatus
        val endpoint: Endpoint = instance.endpoint
        val endpointUrl = endpoint.toString()
        logger.info(identifier + "\t" + status)
        logger.info(endpointUrl)
        return identifier
    }

    // Describe DB instances
    open fun listInstances() {
        val result = amazonRDS!!.describeDBInstances()
        val instances: List<DBInstance> = result.dbInstances
        for (instance in instances) {
            // Information about each RDS instance
            val identifier: String = instance.dbInstanceIdentifier
            val engine: String = instance.engine
            val status: String = instance.dbInstanceStatus
            val endpoint: Endpoint = instance.endpoint
            val endpointUrl = endpoint.toString()
            logger.info(identifier + "\t" + engine + "\t" + status)
            logger.info("\t" + endpointUrl)
        }
    }

    //Delete RDS instance
    open fun terminateInstance(identifier: String) {
        val request = DeleteDBInstanceRequest()
        request.dbInstanceIdentifier = identifier
        request.isSkipFinalSnapshot = true

        // Delete the RDS instance
        val instance: DBInstance = amazonRDS!!.deleteDBInstance(request)

        // Information about the RDS instance being deleted
        val status: String = instance.dbInstanceStatus
        val endpoint: Endpoint = instance.endpoint
        val endpointUrl = endpoint.toString()
        logger.info(identifier + "\t" + status)
        logger.info(endpointUrl)
    }


    @Throws(SQLException::class, IOException::class)
    open fun runJdbcTests() {
        try {
            val conn = DriverManager.getConnection(hostname, username, password)

            // Create the test table if not exists
            val statement: Statement = conn.createStatement()
            var sql = "CREATE TABLE IF NOT EXISTS jdbc_test (id SERIAL PRIMARY KEY, content VARCHAR(80))"
            statement.executeUpdate(sql)

            // Do some INSERT
            val preparedStatement = conn.prepareStatement("INSERT INTO jdbc_test (content) VALUES (?)")
            val content = "" + UUID.randomUUID()
            preparedStatement.setString(1, content)
            preparedStatement.executeUpdate()
            logger.info("INSERT: $content")

            // Do some SELECT
            sql = "SELECT  * FROM jdbc_test"
            val resultSet: ResultSet = statement.executeQuery(sql)
            while (resultSet.next()) {
                val count = resultSet.getString("content")
                logger.info("Total Records: $count")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}*/
