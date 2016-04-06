package cn.martin.druid.service;

import cn.martin.druid.entity.File;
import cn.martin.druid.repository.FileMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/3/16.
 */
@Service
@Transactional
public class FileService {
    @Resource
    private FileMapper fileMapper;

    public File findOne(Long id){
        return fileMapper.selectByPrimaryKey(id);

    }
}
