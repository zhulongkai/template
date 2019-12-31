package com.zlk.web.manager.repository;

import com.zlk.common.core.entiry.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface DepartmentRepository extends JpaRepository<Department,String> {

    @Modifying
    @Query(value = "insert into department(id,department,number) values ('1','hehe',6)",nativeQuery = true)
    void insertDepartment();
}
