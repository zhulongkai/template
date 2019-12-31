package com.zlk.common.core.entiry;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Person implements Serializable {
    @Id
    private String id;
    private String name;
    private Integer age;
}
