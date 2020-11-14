package works.lionel.reactive.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;
import works.lionel.reactive.model.Message;

import java.util.UUID;

@RestController
public interface MessageRepository extends CrudRepository<Message, UUID> {
}
