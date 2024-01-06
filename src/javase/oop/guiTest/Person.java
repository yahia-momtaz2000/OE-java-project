/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.guiTest;

/**
 *
 * @author Administrator
 */
public class Person {

    private String personName;
    private String personJob;
    private String personCountry;
    private String personSelectedAge;
    private String personGenderSelected;
    private boolean personCheckCar;
    private String personCarType;

    public Person(String personName, String personJob, String personCountry, String personSelectedAge, String personGenderSelected, boolean personCheckCar, String personCarType) {
        this.personName = personName;
        this.personJob = personJob;
        this.personCountry = personCountry;
        this.personSelectedAge = personSelectedAge;
        this.personGenderSelected = personGenderSelected;
        this.personCheckCar = personCheckCar;
        this.personCarType = personCarType;
    }

    public String getPersonCarType() {
        return personCarType;
    }

    public void setPersonCarType(String personCarType) {
        this.personCarType = personCarType;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonJob() {
        return personJob;
    }

    public void setPersonJob(String personJob) {
        this.personJob = personJob;
    }

    public String getPersonCountry() {
        return personCountry;
    }

    public void setPersonCountry(String personCountry) {
        this.personCountry = personCountry;
    }

    public String getPersonSelectedAge() {
        return personSelectedAge;
    }

    public void setPersonSelectedAge(String personSelectedAge) {
        this.personSelectedAge = personSelectedAge;
    }

    public String getPersonGenderSelected() {
        return personGenderSelected;
    }

    public void setPersonGenderSelected(String personGenderSelected) {
        this.personGenderSelected = personGenderSelected;
    }

    public boolean isPersonCheckCar() {
        return personCheckCar;
    }

    public void setPersonCheckCar(boolean personCheckCar) {
        this.personCheckCar = personCheckCar;
    }
    
    
    
    
    

}
