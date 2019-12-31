package com.zlk.web.platform.repository;

import com.zlk.common.core.entiry.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RoleRepository extends JpaRepository<Role,String> {
    @Query(value = "insert into role (id,type,remark,status,reason,)",nativeQuery = true)
    Integer insertRole();
}
