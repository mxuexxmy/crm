package xyz.mxue.crm.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Contract {
    private Integer conNo;
    private String conName;
    private Integer cusNo;
    private double conAmount;
    private Date conCreate;
    private Integer ctId;
    private String conNotes;
}
