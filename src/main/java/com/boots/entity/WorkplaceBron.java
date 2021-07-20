package com.boots.entity;

import javax.persistence.*;


import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "t_workplace_bron")
public class WorkplaceBron {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long number;
    private String detail;
    private Date date_start2=null;
    private Date date_stop=null;

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

    public Date getDate_start2() {
        return date_start2;
    }

    public void setDate_start2(Date date_start2) {
        this.date_start2 = date_start2;
    }

    public Date getDate_stop() {
        return date_stop;
    }

    public void setDate_stop(Date date_stop) {
        this.date_stop = date_stop;
    }

    @Override
    public String toString() {
        return "WorkplaceBron{" +
                "id=" + id +
                ", number=" + number +
                ", detail='" + detail + '\'' +
                ", date_start=" + date_start2 +
                ", date_stop=" + date_stop +
                '}';
    }
}
