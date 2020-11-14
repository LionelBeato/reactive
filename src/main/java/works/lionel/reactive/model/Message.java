package works.lionel.reactive.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public class Message {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, unique=true, columnDefinition = "BINARY(16)")
    private final UUID uuid;
    private final String text;

    public Message(UUID uuid, String text) {
        this.uuid = uuid;
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
