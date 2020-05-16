package com.security.dao;

import com.security.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PeopleDao  extends JpaRepository<People, Long>, JpaSpecificationExecutor<People> {
    /*根据名字查询数据库*/
    public People findByUsername(String username);
}
