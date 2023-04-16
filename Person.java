package com.example.chatgptprojectappv11;

public class Person implements PersonInfo {

    private String name;
    private String surname;
    private String birthday;
    private String birthMonth;
    private String birthYear;
    private String company;

    public Person(String name, String surname, String birthday, String birthMonth, String birthYear, String company) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getCompany() {
        return company;
    }

}
