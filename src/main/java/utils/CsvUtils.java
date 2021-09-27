package utils;

import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {

    public static List<Student> parseCsvFile(InputStream is) {
        String[] CSV_HEADER = {"Id","student_number", "firstname", "surname", "course_code", "description", "grade"};
        Reader fileReader = null;
        CsvToBean<Student> csvToBean = null;

        List<Student> customers = new ArrayList<Student>();

        try {
            fileReader = new InputStreamReader(is);

            ColumnPositionMappingStrategy<Student> mappingStrategy = new ColumnPositionMappingStrategy<Student>();

            mappingStrategy.setType(Student.class);
            mappingStrategy.setColumnMapping(CSV_HEADER);

            csvToBean = new CsvToBeanBuilder<Student>(fileReader).withMappingStrategy(mappingStrategy).withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true).build();

            customers = csvToBean.parse();

            return customers;
        } catch (Exception e) {
            System.out.println("Reading CSV Error!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Closing fileReader/csvParser Error!");
                e.printStackTrace();
            }
        }

        return customers;
    }

    public static void learnersToCsv(Writer writer, List<Student> learners) {
        String[] CSV_HEADER = {"Id","student_number", "firstname", "surname", "course_code", "description", "grade"};

        StatefulBeanToCsv<Student> beanToCsv = null;

        try {
            // write List of Objects
            ColumnPositionMappingStrategy<Student> mappingStrategy =
                    new ColumnPositionMappingStrategy<Student>();

            mappingStrategy.setType(Student.class);
            mappingStrategy.setColumnMapping(CSV_HEADER);

            beanToCsv = new StatefulBeanToCsvBuilder<Student>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            beanToCsv.write(learners);
        } catch (Exception e) {
            System.out.println("Error occurred while writing csv");
            e.printStackTrace();
        }
    }
}