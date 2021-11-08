package hu.me.iit.elastic;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Builder
@Document(indexName = "chats")
public class ChatMessage {

    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String message;
    @Field(type = FieldType.Text)
    private String sender;
    @Field(type = FieldType.Text)
    private String roomId;
    @Field(type = FieldType.Text)
    private String roomName;

}
