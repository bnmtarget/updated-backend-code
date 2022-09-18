package bnm.bnmapi.db;


import bnm.bnmapi.UserProfile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "userprofile")
public class UserProfileDAO {
    @Id
    private Integer userId;
    private String name;
    private String email;
    private String preferredlocations;
    private String preferredtimings;
    private String preferreddays;
    private String preferredstores;
    private String address;
    private String gender;
    private String mobile_no;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreferredlocations() {
        return preferredlocations;
    }

    public void setPreferredlocations(String preferredlocations) {
        this.preferredlocations = preferredlocations;
    }

    public String getPreferredtimings() {
        return preferredtimings;
    }

    public void setPreferredtimings(String preferredtimings) {
        this.preferredtimings = preferredtimings;
    }

    public String getPreferreddays() {
        return preferreddays;
    }

    public void setPreferreddays(String preferreddays) {
        this.preferreddays = preferreddays;
    }



    public String getAddress() {
        return address;
    }

    public String getPreferredstores() {
        return preferredstores;
    }

    public void setPreferredstores(String preferredstores) {
        this.preferredstores = preferredstores;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }


}
