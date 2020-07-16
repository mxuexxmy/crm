package xyz.mxue.crm.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Contract {
    private long conNo;
    private String conName;
    private long cusNo;
    private double conAmount;
    private Date conCreate;
    private long ctId;
    private String conNotes;
}
