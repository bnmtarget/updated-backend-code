package bnm.bnmapi;
import javax.persistence.*;


//@Entity
//@Table(name = "userprofile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public UserProfile() {
    }

    public Integer getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPreferredstores() {
        return preferredstores;
    }

    public void setPreferredstores(String preferredstores) {
        this.preferredstores = preferredstores;
    }

    public String getAddress() {
        return address;
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

    public UserProfile(Integer userId,String name,String email,String mobile_no,String preferredlocations,String preferreddays,String preferredstores,String preferredtimings,String address,String gender) {
        this.userId = userId;
        this.name=name;
        this.email = email;
        this.mobile_no=mobile_no;
        this.preferredlocations = preferredlocations;
        this.preferredtimings = preferredtimings;
        this.preferreddays = preferreddays;
        this.preferredstores = preferredstores;
        this.address = address;
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "entity{" +
                "id='" + userId + '\'' +
                ",name='" + name + '\'' +
                ",email='" + email + '\'' +
                ",mobile_no='" + mobile_no + '\'' +
                ", preferred_locations='" + preferredlocations + '\'' +
                ", preferred_timings=" + preferredtimings +
                ", preferred_days=" + preferreddays +
                ", preferred_stores=" + preferredstores +
                ", address=" + address +
                ", gender=" + gender +


                '}';
    }
}
