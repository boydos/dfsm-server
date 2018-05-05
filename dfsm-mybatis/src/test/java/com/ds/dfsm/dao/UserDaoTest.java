package com.ds.dfsm.dao;

import com.ds.dfsm.pojo.DfsmUserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    private Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    UserDao userDao;

    @Test
    public void testUserDao() {
        DfsmUserDO dfsmUserDO = new DfsmUserDO();
        dfsmUserDO.setName("test");
        dfsmUserDO.setNickname("神人");
        dfsmUserDO.setPassword("123456");
        dfsmUserDO.setGmtCreate(new Date());
        dfsmUserDO.setGmtModify(new Date());
        //test insert
        int result = userDao.insertUser(dfsmUserDO);
        assertEquals(1, result);
        logger.info("userid={}",dfsmUserDO.getId());

        //test list
        List<DfsmUserDO> users = userDao.listUser();
        for (DfsmUserDO user: users) {
            logger.info("after insert:{}",user);
        }

        //test update
        DfsmUserDO updateUser = new DfsmUserDO();
        updateUser.setId(dfsmUserDO.getId());
        updateUser.setStatus(1);
        updateUser.setPassword("8888");
        updateUser.setGmtModify(new Date());
        result = userDao.updateUser(updateUser);
        assertEquals(1, result);

        DfsmUserDO user = userDao.getUser(dfsmUserDO.getId());
        assertEquals(1,user.getStatus().intValue());

        //test list
        users = userDao.listUser();
        for (DfsmUserDO us: users) {
            logger.info("after update:{}",us);
        }

        //test delete
        result = userDao.deleteUser(dfsmUserDO.getId());
        assertEquals(1,result);

        //test list
        users = userDao.listUser();
        for (DfsmUserDO us: users) {
            logger.info("after delete:{}",us);
        }

    }
}