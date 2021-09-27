package service;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import repository.StudentRepository;
import utils.CommonsUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.List;

public class CsvFileUploadService {
    @Autowired
    StudentRepository studentRepository;

    public void store(InputStream file) {
        try{
            List<Student> lstStudent = CommonsUtils.parseCsvFile(file);

            studentRepository.saveAll(lstStudent);
        } catch(Exception e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }

    public void loadFile(Writer writer) throws IOException {
        try {
            List<Student> learners = (List<Student>) studentRepository.findAll();

        } catch(Exception e) {
            throw new RuntimeException("Fail! -> Message = " + e.getMessage());
        }
    }
}

