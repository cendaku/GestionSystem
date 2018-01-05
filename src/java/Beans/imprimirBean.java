package Beans;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean
@SessionScoped
public class imprimirBean {

    private byte[] bytes = null;
    private Connection conexion;
    JasperPrint jasperPrint;

    public void lisAlumPdf() {
        try {
            JRBeanCollectionDataSource beanCollectionDataSource;
            String reportPath;
            reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report/listadoalumno.jasper");
            // Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionSystem", "root", "123456");

            //Map<String,Object> parameters=new HashMap<String, Object>();
            jasperPrint = JasperFillManager.fillReport(reportPath, null, conexion);
            bytes = JasperRunManager.runReportToPdf(reportPath, null, conexion);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setContentLength(bytes.length);
            servletOutputStream.write(bytes, 0, bytes.length);
            servletOutputStream.flush();
            servletOutputStream.close();

            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(imprimirBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(imprimirBean.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(imprimirBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exporAlumnotPdf(Integer ci) {
        try {
            JRBeanCollectionDataSource beanCollectionDataSource;
            String reportPath;
            reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report/alumno.jasper");
            // Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionSystem", "root", "123456");

            Map<String,Object> parameters=new HashMap<String, Object>();
            parameters.put("ci", ci.toString());
            jasperPrint = JasperFillManager.fillReport(reportPath, parameters, conexion);
            bytes = JasperRunManager.runReportToPdf(reportPath, parameters, conexion);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setContentLength(bytes.length);
            servletOutputStream.write(bytes, 0, bytes.length);
            servletOutputStream.flush();
            servletOutputStream.close();

            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(imprimirBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(imprimirBean.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(imprimirBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void lisInsPdf() {
        try {
            JRBeanCollectionDataSource beanCollectionDataSource;
            String reportPath;
            reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report/listainstructor.jasper");
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionSystem", "root", "123456");

            jasperPrint = JasperFillManager.fillReport(reportPath, null, conexion);
            bytes = JasperRunManager.runReportToPdf(reportPath, null, conexion);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setContentLength(bytes.length);
            servletOutputStream.write(bytes, 0, bytes.length);
            servletOutputStream.flush();
            servletOutputStream.close();

            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(imprimirBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(imprimirBean.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(imprimirBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void exporInstructortPdf(Integer ci) {
        try {
            JRBeanCollectionDataSource beanCollectionDataSource;
            String reportPath;
            reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report/instructor.jasper");
            // Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionSystem", "root", "123456");

            Map<String,Object> parameters=new HashMap<String, Object>();
            parameters.put("ci", ci.toString());
            jasperPrint = JasperFillManager.fillReport(reportPath, parameters, conexion);
            bytes = JasperRunManager.runReportToPdf(reportPath, parameters, conexion);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            httpServletResponse.setContentType("application/pdf");
            httpServletResponse.setContentLength(bytes.length);
            servletOutputStream.write(bytes, 0, bytes.length);
            servletOutputStream.flush();
            servletOutputStream.close();

            FacesContext.getCurrentInstance().responseComplete();

        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(imprimirBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(imprimirBean.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(imprimirBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
