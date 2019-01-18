package com.example.win.muzeji;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Muzej {
//    @SerializedName("employee_id")
//    @Expose
//    private Integer employeeId;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("dob")
//    @Expose
//    private String dob;
//    @SerializedName("designation")
//    @Expose
//    private String designation;
//    @SerializedName("contact_number")
//    @Expose
//    private String contactNumber;
//    @SerializedName("email")
//    @Expose
//    private String email;
//    @SerializedName("salary")
//    @Expose
//    private String salary;
//
//    public Integer getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(Integer employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDob() {
//        return dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }
//
//    public String getDesignation() {
//        return designation;
//    }
//
//    public void setDesignation(String designation) {
//        this.designation = designation;
//    }
//
//    public String getContactNumber() {
//        return contactNumber;
//    }
//
//    public void setContactNumber(String contactNumber) {
//        this.contactNumber = contactNumber;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getSalary() {
//        return salary;
//    }
//
//    public void setSalary(String salary) {
//        this.salary = salary;
//    }

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("naziv")
    @Expose
    private String naziv;
    @SerializedName("telefon")
    @Expose
    private String telefon;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("cijena_ulaznice")
    @Expose
    private String cijena_ulaznice;
    @SerializedName("opis")
    @Expose
    private String opis;
    @SerializedName("latituda")
    @Expose
    private String latituda;
    @SerializedName("longituda")
    @Expose
    private String longituda;
    @SerializedName("icon")
    @Expose
    private String iconURL;

//    public Muzej(Integer id, String naziv, String telefon, String email, String cijena_ulaznice, String opis, String latituda, String longituda, String iconURL) {
//        this.id = id;
//        this.naziv = naziv;
//        this.telefon = telefon;
//        this.email = email;
//        this.cijena_ulaznice = cijena_ulaznice;
//        this.opis = opis;
//        this.latituda = latituda;
//        this.longituda = longituda;
//        this.iconURL = iconURL;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCijena_ulaznice() {
        return cijena_ulaznice;
    }

    public void setCijena_ulaznice(String cijena_ulaznice) {
        this.cijena_ulaznice = cijena_ulaznice;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getLatituda() {
        return latituda;
    }

    public void setLatituda(String latituda) {
        this.latituda = latituda;
    }

    public String getLongituda() {
        return longituda;
    }

    public void setLongituda(String longituda) {
        this.longituda = longituda;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
}
