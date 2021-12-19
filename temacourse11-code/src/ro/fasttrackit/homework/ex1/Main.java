package ro.fasttrackit.homework.ex1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<StudentGrade> persons = new ArrayList<>();
        persons.add(new StudentGrade("Ana", "matematica", 10));

        Classroom classroom = new Classroom(persons);
        System.out.println(classroom.getGradesForDiscipline(""));
        System.out.println(classroom.getGradesForStudent(""));

    }
}
