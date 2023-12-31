package com.example.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


@Configuration
public class AWSConfig {

	@Value("${aws.access.key}")
	private String awsAccessKey;

	@Value("${aws.secret.access.key}")
	private String awsSecretAccessKey;

	@Value("${aws.region}")
	private String region;

	@Bean
	public AmazonS3 createClientS3() {

		AWSCredentials awsCredentials = new BasicAWSCredentials(awsAccessKey, awsSecretAccessKey);

		return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.withRegion(region).build();

	}

}
