package com.example.chatgptprojectappv11;


import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


public class PersonInfo {

    private String name;
    private String surname;
    private String company;
    private String birthday;

    public PersonInfo(String name, String surname, String company, String birthday) {
        this.name = name;
        this.surname = surname;
        this.company = company;
        this.birthday = birthday;
    }

    public void writePeopleToFile(Context context) {
        try (FileWriter writer = new FileWriter(new File(context.getFilesDir(), "birthdays.txt"), true)) { // open file for append
            StringBuilder builder = new StringBuilder();
            builder.append(name).append(",")
                    .append(surname).append(",")
                    .append(company).append(",")
                    .append(birthday)
                    .append("\n");

            writer.write(builder.toString());
        } catch (IOException e) {
            Log.i("WriteToFile", "Error writing to file", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonInfo that = (PersonInfo) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(company, that.company) &&
                Objects.equals(birthday, that.birthday);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname, company, birthday);
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", company='" + company + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public static void main(String[] args) {
        PersonInfo person1 = new PersonInfo("John", "Doe", "Acme Inc.", "01/01/2000");
        PersonInfo person2 = new PersonInfo("Jane", "Doe", "Acme Inc.", "02/02/2000");


        Context context = null;
        File file = new File(context.getFilesDir(), "birthdays.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Log.e("WriteToFile", "Error creating file", e);
            }
        }

        // Write the people to the file
        person1.writePeopleToFile(context);
        person2.writePeopleToFile(context);
    }

    public int getBirthday() {
        return 0;
    }

    public char[] getName() {
        return new char[0];
    }

    public Object getSurname() {
        return null;
    }
}
