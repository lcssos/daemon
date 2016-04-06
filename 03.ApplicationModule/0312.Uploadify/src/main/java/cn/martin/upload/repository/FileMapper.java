package cn.martin.upload.repository;

import cn.martin.upload.entity.File;

/**
 * Created by Administrator on 2016/3/16.
 */
public interface FileMapper {
    File selectByPrimaryKey(Long id);
    File selectByMd5(String md5);

}
