package com.boots.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_workplace")
public class Workplace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long number;
    private String detail;
    private Long status=2l;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<WorkplaceStatus> workplaceStatuses;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Set<WorkplaceStatus> getWorkplaceStatuses() {
        return workplaceStatuses;
    }

    public void setWorkplaceStatuses(Set<WorkplaceStatus> workplaceStatuses) {
        this.workplaceStatuses = workplaceStatuses;
    }

    @Override
    public String toString() {
        return "Workplace{" +
                "id=" + id +
                ", number=" + number +
                ", detail='" + detail + '\'' +
                ", status=" + status +
                ", workplaceStatuses=" + workplaceStatuses +
                '}';
    }
}
