package cn.martin.solr.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * Created by lcssos on 16/4/23.
 */
@Getter
@Setter

@SolrDocument(solrCoreName="book")
public class Book {
    @Id
    private Long id;
    @Indexed(type="text_general")
//    @Field
    private String name;


}
