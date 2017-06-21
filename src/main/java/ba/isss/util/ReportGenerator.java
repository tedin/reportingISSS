package ba.isss.util;


import ba.isss.exception.ReportGenerationException;
import net.sf.jasperreports.engine.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.HashMap;

public class ReportGenerator implements IReportGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportGenerator.class);

    @Override
    public JasperReport compileTemplate(String templateFileName) throws ReportGenerationException {

        try {
            LOGGER.info("Compiling Report Design ...");

            InputStream resource = this.getClass().getClassLoader()
                    .getResourceAsStream(templateFileName + ReportingServiceConstants.JRXML_FILE_EXTENSION);
            LOGGER.info("Done compiling!!! ...");

            return JasperCompileManager.compileReport(resource);
        } catch (JRException e) {
            throw new ReportGenerationException("Error while compiling report", e);
        }
    }

    @Override
    public JasperPrint fillReportWithData(JasperReport report, HashMap<String, Object> parameters, JRRewindableDataSource dataSource)
            throws ReportGenerationException {
        try {
            return JasperFillManager.fillReport(report, parameters, dataSource);
        } catch (JRException e) {
            throw new ReportGenerationException("Error while filling report data", e);
        }
    }

    @Override
    public void exportFile(JasperPrint source, String destinationDirectory, String destinationFileName, ReportFormat format)
            throws ReportGenerationException {
        String destination = destinationDirectory + destinationFileName + format.toString();
        try {
            switch (format) {
                case PDF:
                    JasperExportManager.exportReportToPdfFile(source, destination);
                    break;
                case HTML:
                    JasperExportManager.exportReportToHtmlFile(source, destination);
                    break;
                default:
                    throw new IllegalArgumentException("Report type is not supported");
            }
        } catch (JRException e) {
            throw new ReportGenerationException("Error while generating report", e);
        }
    }
}
