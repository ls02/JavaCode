package model;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-08-28
 * Time: 14:23.
 */
public class User {
    private int userId;
    private String name;
    private String password;
    private int isAdmin;
    private String address;
    private String numb;
    private String provinceIndex;
    private String cityIndex;
    private String districtIndex;
    private String street;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumb() {
        return numb;
    }

    public void setNumb(String numb) {
        this.numb = numb;
    }

    public String getProvinceIndex() {
        return provinceIndex;
    }

    public void setProvinceIndex(String provinceIndex) {
        this.provinceIndex = provinceIndex;
    }

    public String getCityIndex() {
        return cityIndex;
    }

    public void setCityIndex(String cityIndex) {
        this.cityIndex = cityIndex;
    }

    public String getDistrictIndex() {
        return districtIndex;
    }

    public void setDistrictIndex(String districtIndex) {
        this.districtIndex = districtIndex;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", address='" + address + '\'' +
                ", numb='" + numb + '\'' +
                ", provinceIndex='" + provinceIndex + '\'' +
                ", cityIndex='" + cityIndex + '\'' +
                ", districtIndex='" + districtIndex + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
