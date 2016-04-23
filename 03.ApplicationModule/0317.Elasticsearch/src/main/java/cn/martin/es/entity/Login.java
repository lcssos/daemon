package cn.martin.es.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户登录表
 * @author ray
 *
 */

@Getter
@Setter
@Document(indexName = "user6",type = "login")
public class Login implements Serializable {

    private static final long serialVersionUID = 4391566212487348042L;

    private Long id;

    private Long uuid;

    @Field(index = FieldIndex.not_analyzed,type = FieldType.String)
	private String loginname;

    @Field(index = FieldIndex.no,type=FieldType.String)
	private String password;

    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_max_word",type = FieldType.String)
	private String name;

    @Field(index = FieldIndex.not_analyzed,type = FieldType.String)
	private String email;

    @Field(index = FieldIndex.not_analyzed,type = FieldType.String)
    private String sex;

	@DateTimeFormat(pattern = "yyyy-MM-dd",iso= DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date birthday;

	private String photourl;

    @Field(analyzer = "ik_max_word",searchAnalyzer = "ik_max_word",type = FieldType.String)
    private String comments;

}
