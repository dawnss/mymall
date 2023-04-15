package org.biye.mymall.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.biye.mymall.core.storage.TencentStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class TencentStorageTest {

    private Log logger = LogFactory.getLog(TencentStorageTest.class);
    @Autowired
    private TencentStorage tencentStorage;

    @Test
    public void test() throws IOException {
        String test = getClass().getClassLoader().getResource("mymall.png").getFile();
        File testFile = new File(test);
        tencentStorage.store(new FileInputStream(test), testFile.length(), "image/png", "mymall.png");
        Resource resource = tencentStorage.loadAsResource("mymall.png");
        String url = tencentStorage.generateUrl("mymall.png");
        logger.info("test file " + test);
        logger.info("store file " + resource.getURI());
        logger.info("generate url " + url);
    }

}