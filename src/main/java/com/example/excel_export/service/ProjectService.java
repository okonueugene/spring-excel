package com.example.excel_export.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.excel_export.model.Project;
import com.example.excel_export.repository.ProjectRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public void generateExcel(HttpServletResponse response) throws IOException{
        List<Project> projects = projectRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();

        // Create a sheet in the workbook
        HSSFSheet sheet = workbook.createSheet("Report");

        // Create a row in the sheet
        HSSFRow row = sheet.createRow(0);

        // Create  cels in the rows
         row.createCell(0).setCellValue("ID");
         row.createCell(1).setCellValue("Title");
         row.createCell(2).setCellValue("Actions");
         row.createCell(3).setCellValue("Status");
         row.createCell(4).setCellValue("Deadline");
         row.createCell(5).setCellValue("Owner");
         row.createCell(6).setCellValue("Date");

         int dataRow = 1;

         for (Project project : projects) {
             HSSFRow dataRow1 = sheet.createRow(dataRow);
             dataRow1.createCell(0).setCellValue(project.getId());
             dataRow1.createCell(1).setCellValue(project.getTitle());
             dataRow1.createCell(2).setCellValue(project.getActions());
             dataRow1.createCell(3).setCellValue(project.getStatus());
             dataRow1.createCell(4).setCellValue(project.getDeadline());
             dataRow1.createCell(5).setCellValue(project.getOwner());
             dataRow1.createCell(6).setCellValue(project.getDate());
             dataRow++;
         }

         ServletOutputStream outputStream = response.getOutputStream();
         workbook.write(outputStream);
         workbook.close();
         outputStream.close();

  
    }

}
