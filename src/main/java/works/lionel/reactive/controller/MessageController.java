package works.lionel.reactive.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import works.lionel.reactive.model.Message;
import works.lionel.reactive.repository.MessageRepository;

import java.time.Duration;
import java.util.Random;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @PostMapping("/post")
    private Mono<Message> postMessage(@RequestBody Message message){
        logger.info(message.toString());
        logger.info("adding...");
        return messageRepository.save(message);
    }

    @GetMapping("/{id}")
    private Mono<Message> getMessageById(@PathVariable String id){
        return messageRepository.findById(id);
    }

//    @GetMapping(path="/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<Message> getAllMessages() {
        return messageRepository.findAll()
                .delayElements(Duration.ofSeconds(1));
    }

    @GetMapping(value = "test",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getMsg(){
        return Flux.fromStream(new Random()
                .ints(10)
                .mapToObj(value -> "this is data " + value))
                .delayElements(Duration.ofSeconds(1))
                .repeat();
    }

    @GetMapping("/what")
    private Mono<Message> getWhat() {
//        return Mono.just("what?");
        return Mono.just(new Message("2", "yup"));
    }


}
