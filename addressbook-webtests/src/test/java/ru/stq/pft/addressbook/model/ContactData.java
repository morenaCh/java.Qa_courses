package ru.stq.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
public class ContactData {
    @XStreamOmitField
    public  int id=Integer.MAX_VALUE;
    @Expose
    public String firstName;
    @Expose
    public String middelname;
    @Expose
    public String lastname;
    @Expose
    public String address;
    @Expose
    public String mobilePhone;
    public String homePhone;
    public String workPhone;
    public String allPhones;
    @Expose
    public String email;
    public String emailSecond;
    public String emailThird;
    public String allEmail;
    @Expose
    public String group;
    public File photo;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddelname() {
        return middelname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getworkPhone() {
        return workPhone;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailSecond() {
        return emailSecond;
    }

    public String getEmailThird() {
        return emailThird;
    }

    public String getAllEmail() {
        return allEmail;
    }

    public String getGroup() {
        return this.group;
    }

    public File getPhoto() {
        return photo;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withMiddelname(String middelname) {
        this.middelname = middelname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone=homePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone=workPhone;
        return this;
    }


    public ContactData withAllPhones(String withAllPhones) {
        this.allPhones = withAllPhones;
        return this;
    }


    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmailSecond(String emailSecond) {
        this.emailSecond = emailSecond;
        return this;
    }

    public ContactData withEmailThird(String emailThird) {
        this.emailThird = emailThird;
        return this;
    }

    public ContactData withAllEmail(String allEmail) {
        this.allEmail = allEmail;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(address, that.address) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastname, address);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' ;
    }


}
