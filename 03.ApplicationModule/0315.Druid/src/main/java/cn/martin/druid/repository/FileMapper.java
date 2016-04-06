package cn.martin.druid.repository;

import cn.martin.druid.entity.File;

/**
 * Created by Administrator on 2016/3/16.
 */
public interface FileMapper {

    File selectByPrimaryKey(Long id);
}
