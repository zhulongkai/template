package com.zlk.web.platform.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.zlk.service.api.service.DepartmentService;
import com.zlk.service.api.service.PersonService;
import com.zlk.web.platform.repository.PersonRepository;
import com.zlk.web.platform.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends BaseService implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Autowired(required = false)
    DepartmentService departmentService;

    @LcnTransaction
    public void insertAll(){
        departmentService.insertDepartment();
        personRepository.insertPerson();
    }
}
