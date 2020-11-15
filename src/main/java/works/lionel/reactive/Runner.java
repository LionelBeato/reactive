package works.lionel.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.w3c.dom.events.Event;
import reactor.util.function.Tuple2;
import works.lionel.reactive.model.Message;
import works.lionel.reactive.repository.MessageRepository;

import java.util.logging.Level;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    MessageRepository messageRepository;

    WebClient client = WebClient.create("http://localhost:8000");




    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Override
    public void run(String... args) throws Exception {
        messageRepository.save(new Message("1", "hello"));
        messageRepository.findById("1");
        logger.info("message added: "+ messageRepository.findById("1"));

//        client.get()
//                .uri("/all")
//                .accept(MediaType.TEXT_EVENT_STREAM)
//                .retrieve()
//                .bodyToFlux(Message.class)
//                .subscribe(System.out::println);
    }

}
