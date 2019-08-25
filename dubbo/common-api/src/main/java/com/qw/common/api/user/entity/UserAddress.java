package com.qw.common.api.user.entity;

/**
 * Created by qinwei on 2019/8/24.
 */
public class UserAddress  {
    private String province;
    private String city;
    private String area;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public UserAddress(String province, String city, String area) {
        this.province = province;
        this.city = city;
        this.area = area;
    }

    public UserAddress() {
    }
}
