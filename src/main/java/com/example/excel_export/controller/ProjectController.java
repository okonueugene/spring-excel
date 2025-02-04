package com.example.excel_export.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.excel_export.service.ProjectService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;


  @GetMapping("/generateExcel")
    public void generateExcel(HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=report.xlsx";
        response.setHeader(headerKey, headerValue);

        projectService.generateExcel(response);
    }

}
