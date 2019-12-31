package com.zlk.common.core.entiry;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Role {
    @Id
    private String id;
    private String type;
    private String remark;
    private String status;
    private String reason;
    private String invalidTime;
    private String operateId;
    private String operateName;
    private String updateTime;
    private String createTime;
    private String domain;

}
