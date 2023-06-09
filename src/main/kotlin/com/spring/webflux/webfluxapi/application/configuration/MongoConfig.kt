package com.spring.webflux.webfluxapi.application.configuration



import com.mongodb.reactivestreams.client.MongoClients
import com.spring.webflux.webfluxapi.adapter.output.mongodb.MongoRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories(
    basePackageClasses = arrayOf(MongoRepository::class))
class MongoConfig : AbstractReactiveMongoConfiguration() {

    override fun getDatabaseName() = "playlists"

    override fun reactiveMongoClient(): com.mongodb.reactivestreams.client.MongoClient = mongoClient()

    @Bean
    fun mongoClient() = MongoClients.create()

    @Bean
    override fun reactiveMongoTemplate(
        databaseFactory: ReactiveMongoDatabaseFactory,
        mongoConverter: MappingMongoConverter
    ): ReactiveMongoTemplate = ReactiveMongoTemplate(mongoClient(), databaseName)
}