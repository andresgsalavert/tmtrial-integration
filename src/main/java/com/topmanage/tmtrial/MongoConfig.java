/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topmanage.tmtrial;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//...

/**
 *
 * @author andresgsalavert
 */
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;

@Configuration
@PropertySources(value = { @PropertySource("classpath:/config.properties") })
public class MongoConfig {

	// 1.2.3.4
	@Value("${mongodb.url}")
	private String mongodbUrl;

	// mongo
	@Value("${mongodb.db}")
	private String defaultDb;

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {

		MongoClientOptions mongoOptions = new MongoClientOptions.Builder().maxWaitTime(1000 * 60 * 5).build();
		MongoClient mongo = new MongoClient(mongodbUrl, mongoOptions);
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, defaultDb);
		return new MongoTemplate(mongoDbFactory);

	}

	// TODO CENTRALIZAR
	// To resolve ${} in @Value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}