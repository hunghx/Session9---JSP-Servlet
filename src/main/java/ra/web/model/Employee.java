package ra.web.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private Integer id;
    private String name;
    private LocalDate birthDay;
    private String address;
    private Boolean sex;

    public Employee() {
    }

    public Employee(Integer id, String name, LocalDate localDate, String address, Boolean sex) {
        this.id = id;
        this.name = name;
        this.birthDay = localDate;
        this.address = address;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLocalDate() {
        return birthDay;
    }

    public void setLocalDate(LocalDate localDate) {
        this.birthDay = localDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
    public String formatDate(){
        return birthDay.format(DateTimeFormatter.ISO_LOCAL_DATE); // yyyy-MM-dd
    }
}
