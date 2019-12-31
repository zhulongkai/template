package com.zlk.web.platform.repository;

import com.zlk.common.core.entiry.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface PersonRepository extends JpaRepository<Person,String> {

    @Modifying
    @Query(value = "insert into person(id,name,age) value ('1','zlk',9)",nativeQuery = true)
    void insertPerson();

}
