package ro.fasttrackit.homework.ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StudentFileReader {
    public static void main(String[] args) throws Exception {
        List<StudentGrade> studentGrades = readStudent("files/grades.txt");

        System.out.print(studentGrades);
        readFileBuffered();
        writeReport(studentGrades);

        Classroom classroom = new Classroom(studentGrades);
        List<StudentGrade> lista  = new ArrayList<StudentGrade>();
        lista =  classroom.getGradesForDiscipline("Computer Science");
        for (StudentGrade ls : lista){
            System.out.print(ls);
        }



    }

    private static void readFileBuffered() throws Exception {
        System.out.println("Buffered read: ");
        BufferedReader filerReader = new BufferedReader(new FileReader("files/grades.txt"));

        String line;
        while ((line = filerReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static void writeReport(List<StudentGrade> studentGrades) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("files/gradesBeautiful.txt"))) {
            for (StudentGrade studentGrade : studentGrades) {
                writer.write(personToLine(studentGrade));
                writer.newLine();
            }
        }
    }

    private static String personToLine(StudentGrade studentGrades) {
        return studentGrades.getName() + " the discipline " + studentGrades.getDiscipline() + " has the grade " + studentGrades.getGrade();
    }

    private static List<StudentGrade> readStudent(String filePath) throws Exception {
        List<StudentGrade> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                result.add(readPersonFromLine(line));
            }
        }
        return result;
    }

    private static StudentGrade readPersonFromLine(String line) {
        String[] tokens = line.split(Pattern.quote("|"));

        return new StudentGrade(tokens[0], tokens[1], Integer.parseInt(tokens[2]));

    }
}


