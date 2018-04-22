package com.huohuo.ExcelToWord.entity;

/**
 * @author wkr
 * @Date 2016-11-18
 * 实体类
 */
public class Customer {

    private Integer id;

    private String Customer1;

    private String Customer2;

    private String Customer3;

    public Customer() {
        super();
    }

    public Customer(Integer id, String customer1, String customer2,
                    String customer3) {
        super();
        this.id = id;
        Customer1 = customer1;
        Customer2 = customer2;
        Customer3 = customer3;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer1() {
        return Customer1;
    }

    public void setCustomer1(String customer1) {
        Customer1 = customer1;
    }

    public String getCustomer2() {
        return Customer2;
    }

    public void setCustomer2(String customer2) {
        Customer2 = customer2;
    }

    public String getCustomer3() {
        return Customer3;
    }

    public void setCustomer3(String customer3) {
        Customer3 = customer3;
    }
}