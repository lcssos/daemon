package cn.martin.druid.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/3/16.
 */
@Getter
@Setter
public class File implements Serializable {
    private Long id;
    private Integer chunks;
    private String path;
    private String status;
    private Date createtime;
}
