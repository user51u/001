package com.boots.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_statusWorkplace")
public class WorkplaceStatus {
    @Id
    private Long id;
    private String name;

    @Transient
    @ManyToMany(mappedBy = "workplace_statuses")
    private Set<Workplace> workplaces;

    public WorkplaceStatus() {
    }

    public WorkplaceStatus(Long id) {
        this.id = id;
    }

    public WorkplaceStatus(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Workplace> getWorkplaces() {
        return workplaces;
    }

    public void setWorkplaces(Set<Workplace> workplaces) {
        this.workplaces = workplaces;
    }
}
