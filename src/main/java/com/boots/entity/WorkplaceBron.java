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
    private Long id_user;
    private String detail;
    private String date_start3=null;
    private String time_start=null;
    private String time_stop=null;

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

    public String getDate_start3() {
        return date_start3;
    }

    public void setDate_start3(String date_start3) {
        this.date_start3 = date_start3;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_stop() {
        return time_stop;
    }

    public void setTime_stop(String time_stop) {
        this.time_stop = time_stop;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "WorkplaceBron{" +
                "id=" + id +
                ", number=" + number +
                ", id_user=" + id_user +
                ", detail='" + detail + '\'' +
                ", date_start3='" + date_start3 + '\'' +
                ", time_start='" + time_start + '\'' +
                ", time_stop='" + time_stop + '\'' +
                '}';
    }
}
