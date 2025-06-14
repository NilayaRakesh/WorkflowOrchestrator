package com.nr.workfloworchestrator.springboot.config;

import com.nr.workfloworchestrator.dbmongo.mapper.WorkflowInstanceMapper;
import com.nr.workfloworchestrator.dbmongo.repository.WorkflowInstanceMongoRepository;
import com.nr.workfloworchestrator.dbmongo.service.WorkflowInstanceMongoPersistence;
import com.nr.workfloworchestrator.springboot.condition.MongoDbCondition;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Conditional(MongoDbCondition.class)
@EnableMongoRepositories(basePackageClasses = WorkflowInstanceMongoRepository.class)
public class DbMongoSpringBootConfig {

    @Bean
    WorkflowInstanceMongoPersistence workflowInstanceMongoPersistence(WorkflowInstanceMongoRepository repository,
                                                                      WorkflowInstanceMapper mapper) {
        return new WorkflowInstanceMongoPersistence(repository, mapper);
    }

    @Bean
    WorkflowInstanceMapper workflowInstanceMapper() {
        return Mappers.getMapper(WorkflowInstanceMapper.class);
    }
}
