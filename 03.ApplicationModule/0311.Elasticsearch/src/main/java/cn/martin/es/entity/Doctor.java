package cn.martin.es.entity;

import io.searchbox.annotations.JestId;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by lcssos on 16/1/9.
 */
@Getter
@Setter
public class Doctor {
    @JestId
    private String doctorid;
    private String name;
    private String hospital;
    private String message;
}
