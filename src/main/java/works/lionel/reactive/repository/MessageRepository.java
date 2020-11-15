package works.lionel.reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import works.lionel.reactive.model.Message;
import java.util.UUID;

@Repository
public interface MessageRepository extends ReactiveMongoRepository<Message, String> {
}
