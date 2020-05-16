package com.security.service;

import com.security.dao.PeopleDao;
import com.security.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    @Autowired
    PeopleDao peopleDao;

    /*根据明治查询*/
    public People findByUsername(String username) {
        return peopleDao.findByUsername(username);
    }

}
