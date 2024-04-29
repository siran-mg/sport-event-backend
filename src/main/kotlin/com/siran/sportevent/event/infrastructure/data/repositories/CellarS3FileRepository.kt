package com.siran.sportevent.event.infrastructure.data.repositories

import com.siran.sportevent.event.domain.repositories.FileRepository
import com.siran.sportevent.event.infrastructure.config.CellarS3Properties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.stereotype.Repository
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.ObjectCannedACL
import java.io.File
import java.net.URI


@Repository
@EnableConfigurationProperties(CellarS3Properties::class)
class CellarS3FileRepository(
    val cellarS3Properties: CellarS3Properties,
) : FileRepository {
    override fun upload(path: String, file: File): String {
        val credentialsProvider =
            StaticCredentialsProvider.create(
                AwsBasicCredentials.create(
                    cellarS3Properties.keyId,
                    cellarS3Properties.keySecret
                )
            )
        val s3ClientBuilder = S3Client
            .builder()
            .endpointOverride(URI.create("https://${cellarS3Properties.host}"))
            .region(Region.of(cellarS3Properties.region))
            .credentialsProvider(credentialsProvider)

        val fileName = "$path/${file.name}"

        val s3Client = s3ClientBuilder.build()

        s3Client.putObject(
            {
                it.bucket(cellarS3Properties.bucket)
                it.key(fileName)
                it.acl(ObjectCannedACL.PUBLIC_READ)
                it.build()
            },
            RequestBody.fromFile(file)
        )
        return s3Client.utilities().getUrl {
            it.bucket(cellarS3Properties.bucket)
            it.key(fileName)
            it.build()
        }.toExternalForm()
    }
}