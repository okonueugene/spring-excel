package com.example.excel_export.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.excel_export.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Serializable> {
    
}
    

