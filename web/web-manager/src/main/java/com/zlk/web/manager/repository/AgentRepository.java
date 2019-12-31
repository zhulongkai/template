package com.zlk.web.manager.repository;

import com.zlk.common.core.entiry.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface AgentRepository extends JpaRepository<Agent,String> {

    @Query(value = "select * from agent where id = ?1" ,nativeQuery = true)
    Agent getAgent(String id);
}
