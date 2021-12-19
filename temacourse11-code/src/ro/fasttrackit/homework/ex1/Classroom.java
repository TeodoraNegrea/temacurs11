package ro.fasttrackit.homework.ex1;

import java.util.ArrayList;
import java.util.List;

public class Classroom extends StudentGrade {
    private final List<StudentGrade> studentGrades;

    public Classroom() {
        this(new ArrayList<>());
    }

    public Classroom(List<StudentGrade> studentGrades) {
        super("", "", 5);
        this.studentGrades = new ArrayList<>(studentGrades);
    }


    public List<StudentGrade> getGradesForDiscipline(String discipline) {
        List<StudentGrade> listaNoua = new ArrayList<StudentGrade>();
        for (StudentGrade item : studentGrades) {
            if (item.getDiscipline() == discipline) {
                listaNoua.add(item);
            }
        }
        return listaNoua;


    }

    public List<StudentGrade> getGradesForStudent(String grade) {
        return new ArrayList<>(studentGrades);
    }
     /*public int getMaxGrade(String discipline){
        return StudentGrade;*/


    }


