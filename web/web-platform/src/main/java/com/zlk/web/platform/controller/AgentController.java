package com.zlk.web.platform.controller;

import com.zlk.common.core.entiry.Agent;
import com.zlk.service.api.service.AgentService;
import com.zlk.service.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {

    @Autowired(required = false)
    AgentService agentService;

    @Autowired
    PersonService personService;

    @RequestMapping("/get/agent/{id}")
    public Agent getAgent(@PathVariable("id") String id){

        personService.insertAll();

        return agentService.getAgent(id);
    }
}
