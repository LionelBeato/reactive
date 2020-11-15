package works.lionel.reactive.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import works.lionel.reactive.Runner;
import works.lionel.reactive.model.Message;
import works.lionel.reactive.repository.MessageRepository;

import java.util.UUID;

@RestController
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @PostMapping("/post")
    private void postMessage(@RequestBody Message message){
        logger.info(message.toString());
        logger.info("adding...");
        messageRepository.save(message);
    }

    @GetMapping("/{id}")
    private Mono<Message> getMessageById(@PathVariable String id){
        return messageRepository.findById(id);
    }

    @GetMapping("/all")
    private Flux<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    @GetMapping("/what")
    private Mono<Message> getWhat() {
//        return Mono.just("what?");
        return Mono.just(new Message("yup"));
    }


}
