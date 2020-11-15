package works.lionel.reactive.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import works.lionel.reactive.model.Message;

//@Component
//public class MessageWebClient {
//    WebClient webClient = WebClient.create("http://localhost:8000");
//
//
//    public void consume() {
//        Mono<Message> messageMono = webClient.get()
//                .uri("/{1}", "1")
//                .retrieve()
//                .bodyToMono(Message.class);
//
//        messageMono.subscribe();
//
//        Mono<Message> postMessage = webClient.post()
//                .uri("/post")
////                .bodyValue(Mono.just(message), Message.class)
//                .retrieve()
//                .bodyToMono(Message.class);
//
//        postMessage.subscribe();
//
//        Flux<Message> messageFlux = webClient.get()
//                .uri("/all")
//                .retrieve()
//                .bodyToFlux(Message.class);
//
//        messageFlux.subscribe();
//
//    }
//
//}
