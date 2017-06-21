package ba.isss.util;

import ba.isss.exception.ReportGenerationException;
import net.sf.jasperreports.engine.JRRewindableDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.util.HashMap;

public interface IReportGenerator {

    JasperReport compileTemplate(String templateFileName) throws ReportGenerationException;

    JasperPrint fillReportWithData(JasperReport report, HashMap<String, Object> parameters, JRRewindableDataSource dataSource)
            throws ReportGenerationException;

    void exportFile(JasperPrint source, String destinationDirectory, String destinationFileName, ReportFormat format)
            throws ReportGenerationException;
}
