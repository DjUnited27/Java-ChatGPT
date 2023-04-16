package com.example.chatgptprojectappv11;

public class Person {
    private String name;
    private String surname;
    private String company;
    private String birthday;

    public Person(String name, String surname, String company, String birthday) {
        this.name = name;
        this.surname = surname;
        this.company = company;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name + "," + surname + "," + company + "," + birthday;
    }
}
