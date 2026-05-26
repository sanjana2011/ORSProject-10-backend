package com.rays.ctl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.MarksheetDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * JasperCtl is the controller class for generating Jasper reports.
 * This class extends {@link BaseCtl} and provides functionality to
 * generate and export PDF reports, specifically for the marksheet merit list.
 * 
 * <p>This controller handles HTTP requests for report generation and
 * uses JasperReports library to compile and fill reports with data
 * from the database.</p>
 *
 * @author sanjana gangrade
 */
@RestController
@RequestMapping(value = "Jasper")
public class JasperCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {

    /** EntityManager for database operations and connection management. */
    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Generates and displays a PDF report for the marksheet merit list.
     * This method compiles a JasperReport template, fills it with data
     * from the database connection, and exports it as a PDF response.
     *
     * @param request the HTTP servlet request
     * @param response the HTTP servlet response
     * @throws JRException if an error occurs during JasperReport processing
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs while writing the response
     */
    @GetMapping(value = "/report", produces = { MediaType.APPLICATION_JSON_VALUE })
    public void display(HttpServletRequest request, HttpServletResponse response)
            throws JRException, SQLException, IOException {

        System.out.println("*** Jasper Ctl ***");

        Connection con = null;

        java.io.InputStream jrxmlStream = getClass().getClassLoader().getResourceAsStream("report10.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlStream);

        Map<String, Object> map = new HashMap<String, Object>();

        Session session = (Session) entityManager.unwrap(Session.class);

        con = ((SessionImpl) session).connection();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, con);

        byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

        response.setContentType("application/pdf");

        response.getOutputStream().write(pdf);

        response.getOutputStream().flush();

        System.out.println("Report Generated Successfully");
    }
}