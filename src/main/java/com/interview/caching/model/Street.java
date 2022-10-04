package com.interview.caching.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.AccessType.PROPERTY;

@Entity
@Table(name = "Streets")
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Street implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String cordinates;

    private LocalDateTime lastModified;
}
