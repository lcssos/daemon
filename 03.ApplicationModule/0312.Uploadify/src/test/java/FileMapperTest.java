import cn.martin.upload.entity.File;
import cn.martin.upload.repository.FileMapper;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/3/26.
 */
@ContextConfiguration(locations = {
        "classpath:applicationContext.xml"
})
public class FileMapperTest extends AbstractJUnit4SpringContextTests {

    @Resource
    private FileMapper fileMapper;

    @Test
    public void test(){
        File file = fileMapper.selectByPrimaryKey(1L);
        System.out.println(file.getChunks());
    }
}
