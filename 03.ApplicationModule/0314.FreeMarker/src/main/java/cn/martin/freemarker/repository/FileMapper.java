package cn.martin.freemarker.repository;

import cn.martin.freemarker.entity.File;

/**
 * Created by Administrator on 2016/3/16.
 */
public interface FileMapper {

    File selectByPrimaryKey(Long id);
}
