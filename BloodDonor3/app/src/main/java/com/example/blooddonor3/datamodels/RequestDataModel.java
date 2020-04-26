package com.example.blooddonor3.datamodels;

public class RequestDataModel {
  public String Name;
  public String  age;
    public String gender;
  public String bloodgroup;
  public String ph_no;
  public String city;
    public String state;
  public  String country;
public String Message;
public String date;


    public RequestDataModel(String name, String age, String gender, String bloodgroup, String ph_no, String city, String state, String country, String message, String date) {
        this.Name = name;
        this.age = age;
        this.gender = gender;
        this.bloodgroup = bloodgroup;
        this.ph_no = ph_no;
        this.city = city;
        this.state = state;
        this.country = country;
        this.Message = message;
        this.date = date;

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String  age) {
    this.age = age;
  }

  public String getBloodgroup() {
    return bloodgroup;
  }

  public void setBloodgroup(String bloodgroup) {
    this.bloodgroup = bloodgroup;
  }

  public String  getPh_no() {
    return ph_no;
  }

  public void setPh_no(String ph_no) {
    this.ph_no = ph_no;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getMessage() {
    return Message;
  }

  public void setMessage(String message) {
    Message = message;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
