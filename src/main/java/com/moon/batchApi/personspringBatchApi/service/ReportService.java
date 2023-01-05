package com.moon.batchApi.personspringBatchApi.service;


import com.moon.batchApi.personspringBatchApi.Dao.PersonnRepository;
import com.moon.batchApi.personspringBatchApi.model.Personn;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {


    @Autowired
    private PersonnRepository personnRepository;
    @Value("${file.uri}")
    private String path ;


    public String ExportReport(String reportFormat) throws FileNotFoundException, JRException {

        List<Personn> personns = personnRepository.findAll();

        //load file and compile it
        File  file = ResourceUtils.getFile("classpath:personns.jrxml");
        JasperReport jasperReport =  JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(personns);
        Map<String,Object> map = new HashMap<>();
        map.put("CreatBy","Moon-Salam-Technologie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,map,dataSource);

        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"personns.html");
        }

        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"personns.pdf");
        }

        return  "report generated in path "+ path;
    }
}
