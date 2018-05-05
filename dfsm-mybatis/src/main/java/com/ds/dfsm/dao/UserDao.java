package com.ds.dfsm.dao;

import com.ds.dfsm.pojo.DfsmUserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public DfsmUserDO getUser(Long id);

    public List<DfsmUserDO> listUser();

    public int insertUser(DfsmUserDO userDO);

    public int deleteUser(Long id);

    public int updateUser(DfsmUserDO userDO);
}
