package com.api.Cliente.repository.mongo;

import com.api.Cliente.repository.orm.ClienteOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryWithMongoDB extends MongoRepository<ClienteOrmMongo, String> {
}
