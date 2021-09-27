package utils;

import model.Student;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonsUtils {
    private static String csvExtension = "csv";

    public static void learnersToCsv(Writer writer, List<Student> learners) throws IOException {

        try (CSVPrinter csvPrinter = new CSVPrinter(writer,
                CSVFormat.DEFAULT.withHeader("Id","student_number", "firstname", "surname", "course_code", "description", "grade"));) {
            for (Student student : learners) {
                List<? extends Serializable> data = Arrays.asList(String.valueOf(student.getStudent_Number()), student.getFirstname(),
                        student.getSurname(),student.getCourse_code(), student.getDescription(),student.getGrade(), String.valueOf(student.getId()));

                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
        } catch (Exception e) {
            System.out.println("Writing CSV error!");
            e.printStackTrace();
        }
    }

    public static List<Student> parseCsvFile(InputStream is) {
        BufferedReader fileReader = null;
        CSVParser csvParser = null;

        List<Student> learners = new ArrayList<Student>();

        try {
            fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Student student = new Student(Long.parseLong(csvRecord.get("id")),csvRecord.get("student_number"),csvRecord.get("firstname"),
                        csvRecord.get("surname"),csvRecord.get("course_code"),csvRecord.get("description"),Integer.parseInt(csvRecord.get("grade")));

                learners.add(student);
            }

        } catch (Exception e) {
            System.out.println("Reading CSV Error!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvParser.close();
            } catch (IOException e) {
                System.out.println("Closing fileReader/csvParser Error!");
                e.printStackTrace();
            }
        }

        return learners;
    }

    public static boolean isCSVFile(MultipartFile file) {
        String extension = file.getOriginalFilename().split("\\.")[1];

        if(!extension.equals(csvExtension)) {
            return false;
        }

        return true;
    }

}

