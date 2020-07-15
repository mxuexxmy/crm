package xyz.mxue.crm.entity;

import lombok.Data;

@Data
public class Contact {
    private int ctId;
    private String ctName;
    private int ctGender;
    private String ctPhone;
    private String ctTitle;
    private String ctNotes;
    private int cusNo;
}
