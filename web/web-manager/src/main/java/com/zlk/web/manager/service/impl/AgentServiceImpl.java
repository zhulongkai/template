package com.zlk.web.manager.service.impl;


import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.zlk.common.core.entiry.Agent;
import com.zlk.service.api.service.AgentService;
import com.zlk.web.manager.repository.AgentRepository;
import com.zlk.web.manager.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Slf4j
@Service
@Transactional
public class AgentServiceImpl extends BaseService implements AgentService , Serializable {

    @Autowired
    AgentRepository agentRepository;

    @Override
    @LcnTransaction
    public Agent getAgent(String id) {
        Agent agent = agentRepository.getAgent(id);
        Agent a = new Agent();
        return agent;
    }
}
