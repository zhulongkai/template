package com.zlk.common.core.entiry;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Department implements Serializable {
    @Id
    private String id;
    private String department;
    private Integer number;
}
