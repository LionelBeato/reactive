package works.lionel.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import works.lionel.reactive.model.Message;
import works.lionel.reactive.repository.MessageRepository;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    MessageRepository messageRepository;

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Override
    public void run(String... args) throws Exception {
        messageRepository.save(new Message("hello"));
        logger.info("message added");
    }
}
