package my.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")

public class Address implements Serializable {

    @Id
    @Generated(value = "assigned")
    private int id = 0;

    @Column(name = "FIRST_LINE")
    private String firstLine = null;
    @Column(name = "SECOND_LINE")
    private String secondLine = null;
    @Column(name = "CITY")
    private String city = null;
    @Column(name = "ZIP_CODE")
    private String zipCode = null;
    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person = null;

    @Column(name = "PERSON_ID", insertable = false, updatable = false)
    private Integer personId = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", firstLine='" + firstLine + '\'' +
                ", secondLine='" + secondLine + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", person=" + person +
                ", personId=" + personId +
                '}';
    }


}