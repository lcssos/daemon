package cn.martin.upload.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Administrator on 2016/3/16.
 */
@Getter
@Setter
public class File {
    private Long id;
    private Integer chunks;
    private String path;
    private String status;
    private Date createtime;
}
