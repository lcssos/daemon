package cn.martin.es.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by lcssos on 16/4/23.
 */
@Getter
@Setter
@Document(indexName = "book")
public class Book {
    private Long id;
    private String name;


}
