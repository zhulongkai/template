package com.zlk.web.manager.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.zlk.service.api.service.DepartmentService;
import com.zlk.web.manager.repository.DepartmentRepository;
import com.zlk.web.manager.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends BaseService implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @LcnTransaction
    public void insertDepartment(){
        departmentRepository.insertDepartment();
    }
}
