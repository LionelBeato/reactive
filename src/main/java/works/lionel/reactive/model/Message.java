package works.lionel.reactive.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.UUID;

@Document(collection = "messages")
public class Message {

    @Id
    private String id;
    private final String text;

    public Message(String text) {
        this.text = text;
        setId(UUID.randomUUID().toString());
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
