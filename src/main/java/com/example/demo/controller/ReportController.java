package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class ReportController {

    @Autowired
    UserRepository userRepository;

    private final ModelAndView model = new ModelAndView();

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public ResponseEntity<?> createReport() {
        log.info("Preparing the pdf report via jasper.");
        try {
            createPdfReport(userRepository.findAll());
            log.info("File successfully saved.");
        } catch (final Exception e) {
            log.error("Some error has occurred while preparing the employee pdf report.");
            e.printStackTrace();
            return new ResponseEntity<>("File successfully saved.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("File successfully saved.", HttpStatus.OK);
    }

    private void createPdfReport(final List<User> users) throws JRException, FileNotFoundException {
        InputStream inputStream = new FileInputStream("D:\\demoo\\src\\main\\resources\\employeeReport.jrxml");
        final JasperReport report = JasperCompileManager.compileReport(inputStream);
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(users);
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", " demo-app");
        final JasperPrint print = JasperFillManager.fillReport(report, parameters, source); final String filePath = "\\";
       JasperExportManager.exportReportToPdfFile(print, filePath + "users_report.pdf");
    }
}
