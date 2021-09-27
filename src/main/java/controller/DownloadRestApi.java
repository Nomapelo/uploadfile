package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CsvFileUploadService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
class DownloadCsvRestApi {
@Autowired
    CsvFileUploadService csvFileUploadService;

    @GetMapping("/api/download/csv/")
    public void downloadFile(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=learners.csv");
        csvFileUploadService.loadFile(response.getWriter());
    }
}
