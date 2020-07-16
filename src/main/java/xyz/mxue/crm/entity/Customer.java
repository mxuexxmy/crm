package xyz.mxue.crm.entity;

import lombok.Data;

@Data
public class Customer {
    private Integer cusNo;
    private String cusName;
    private Integer cusRegion;
    private String cusUrl;
    private Integer cusLevel;
    private Integer cusCredit;
    private Integer cusSource;
}
