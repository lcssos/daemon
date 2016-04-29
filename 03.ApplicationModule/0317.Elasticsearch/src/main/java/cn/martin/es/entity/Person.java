package cn.martin.es.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;

/**
 * Created by lcssos on 16/4/24.
 */
@Getter
@Setter
@Document(indexName = "trying-out-mapper-attachments2",type = "person",shards = 1,replicas = 0)
public class Person {
    private Long id;

//    @Field(type = FieldType.Attachment)
    @Mapping(mappingPath = "/attachment.json")
    private String cv;
}
