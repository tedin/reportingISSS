package ba.isss.util;

import ba.isss.exception.ReportGenerationException;
import ba.isss.model.SV20Model;
import ba.isss.model.SV50Model;
import ba.isss.model.SemesterFormModel;
import ba.isss.model.SignUpFormModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@Component
public class GenerateEntryPapers {
    IReportGenerator reportGenerator = new ReportGenerator();

    private String fileName = "";
    private JasperReport compiledTemplate;

    public byte[] generateSignUpForm(SignUpFormModel signUpFormModel) throws ReportGenerationException {
        fileName = "signup_form";
        compiledTemplate = reportGenerator.compileTemplate(fileName);
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        putSignUpFormParameters(signUpFormModel, parameters);
        JasperPrint print = reportGenerator.fillReportWithData(compiledTemplate, parameters, new JREmptyDataSource());
        if (print != null) {
            reportGenerator.exportFile(print, "C://reports/", fileName, ReportFormat.PDF);
            try {
                File file = new File("C://reports/" + fileName + ".pdf");
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                return bytes;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else
            return null;
    }

    public byte[] generateSemesterForm(SemesterFormModel semesterFormModel) throws ReportGenerationException {
        fileName = "semester_form";
        compiledTemplate = reportGenerator.compileTemplate(fileName);
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        putSemesterFormParameters(semesterFormModel, parameters);
        JasperPrint print = reportGenerator.fillReportWithData(compiledTemplate, parameters, new JREmptyDataSource());
        if (print != null) {
            reportGenerator.exportFile(print, "C://reports/", fileName, ReportFormat.PDF);
            try {
                File file = new File("C://reports/" + fileName + ".pdf");
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                return bytes;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else
            return null;
    }

    public byte[] generateSV20(SV20Model sv20Model) throws ReportGenerationException {
        fileName = "SV_20";
        compiledTemplate = reportGenerator.compileTemplate(fileName);
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        putSV20Parameters(sv20Model, parameters);
        JasperPrint print = reportGenerator.fillReportWithData(compiledTemplate, parameters, new JREmptyDataSource());
        if (print != null) {
            reportGenerator.exportFile(print, "C://reports/", fileName, ReportFormat.PDF);
            try {
                File file = new File("C://reports/" + fileName + ".pdf");
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                return bytes;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else
            return null;
    }

    public byte[] generateSV50(SV50Model sv50Model) throws ReportGenerationException {
        fileName = "SV_50";
        compiledTemplate = reportGenerator.compileTemplate(fileName);
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        putSV50Parameters(sv50Model, parameters);
        JasperPrint print = reportGenerator.fillReportWithData(compiledTemplate, parameters, new JREmptyDataSource());
        if (print != null) {
            reportGenerator.exportFile(print, "C://reports/", fileName, ReportFormat.PDF);
            try {
                File file = new File("C://reports/" + fileName + ".pdf");
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                return bytes;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else
            return null;
    }

    public void putSignUpFormParameters(SignUpFormModel signUpFormModel, HashMap<String, Object> parameters) {
        parameters.put("faculty", signUpFormModel.getFaculty());
        parameters.put("studentFullName", signUpFormModel.getStudentFullName());
        parameters.put("indexNumber", signUpFormModel.getIndexNumber());
        parameters.put("dob", signUpFormModel.getDob());
        parameters.put("place", signUpFormModel.getPlace());
        parameters.put("placeOfBirth", signUpFormModel.getPlaceOfBirth());
        parameters.put("facultyPlace", signUpFormModel.getFacultyPlace());
        parameters.put("municipality", signUpFormModel.getMunicipality());
        parameters.put("country", signUpFormModel.getCountry());
        parameters.put("semester", signUpFormModel.getSemester());
        parameters.put("academicYear", signUpFormModel.getAcademicYear());
        parameters.put("studyCycle", signUpFormModel.getStudyCycle());
        parameters.put("studentType", signUpFormModel.getStudentType());
        parameters.put("department", signUpFormModel.getDepartment());
        parameters.put("studyProgram", signUpFormModel.getStudyProgram());
        parameters.put("date", signUpFormModel.getDate());
        parameters.put("jmbg", signUpFormModel.getJmbg());
        parameters.put("citizenship", signUpFormModel.getCitizenship());
        parameters.put("nationality", signUpFormModel.getNationality());
        parameters.put("highSchool", signUpFormModel.getHighSchool());
        parameters.put("father", signUpFormModel.getFather());
        parameters.put("mother", signUpFormModel.getMother());
        parameters.put("fatherOccupation", signUpFormModel.getFatherOccupation());
        parameters.put("motherOccupation", signUpFormModel.getMotherOccupation());
        parameters.put("canton", signUpFormModel.getCanton());
        parameters.put("currentAdress", signUpFormModel.getCurrentAddress());
        parameters.put("telNumber", signUpFormModel.getTelNumber());
        parameters.put("eMail", signUpFormModel.geteMail());
    }

    public void putSemesterFormParameters(SemesterFormModel semesterFormModel, HashMap<String, Object> parameters) {
        parameters.put("faculty", semesterFormModel.getFaculty());
        parameters.put("studentFullName", semesterFormModel.getStudentFullName());
        parameters.put("indexNumber", semesterFormModel.getIndexNumber());
        parameters.put("dob", semesterFormModel.getDob());
        parameters.put("place", semesterFormModel.getPlace());
        parameters.put("facultyPlace", semesterFormModel.getFacultyPlace());
        parameters.put("placeOfBirth", semesterFormModel.getPlaceOfBirth());
        parameters.put("municipality", semesterFormModel.getMunicipality());
        parameters.put("country", semesterFormModel.getCountry());
        parameters.put("semester", semesterFormModel.getSemester());
        parameters.put("academicYear", semesterFormModel.getAcademicYear());
        parameters.put("studyCycle", semesterFormModel.getStudyCycle());
        parameters.put("studentType", semesterFormModel.getStudentType());
        parameters.put("department", semesterFormModel.getDepartment());
        parameters.put("studyProgram", semesterFormModel.getStudyProgram());
        parameters.put("date", semesterFormModel.getDate());
        parameters.put("jmbg", semesterFormModel.getJmbg());
        parameters.put("citizenship", semesterFormModel.getCitizenship());
        parameters.put("nationality", semesterFormModel.getNationality());
        parameters.put("highSchool", semesterFormModel.getHighSchool());
        parameters.put("father", semesterFormModel.getFather());
        parameters.put("mother", semesterFormModel.getMother());
        parameters.put("canton", semesterFormModel.getCanton());
        parameters.put("currentAdress", semesterFormModel.getCurrentAdress());
        parameters.put("telNumber", semesterFormModel.getTelNumber());
        parameters.put("eMail", semesterFormModel.geteMail());
    }

    public void putSV50Parameters(SV50Model sv50Model, HashMap<String, Object> parameters) {
        parameters.put("academicYear", sv50Model.getAcademicYear());
        parameters.put("university", sv50Model.getUniversity());
        parameters.put("faculty", sv50Model.getFaculty());
        parameters.put("department", sv50Model.getDepartment());
        parameters.put("studyProgram", sv50Model.getStudyProgram());
        parameters.put("facultyCanton", sv50Model.getFacultyCanton());
        parameters.put("facultyMunicipality", sv50Model.getFacultyMunicipality());
        parameters.put("facultyAdress", sv50Model.getFacultyAdress());
        parameters.put("personalIdentityNumber", sv50Model.getPersonalIdentityNumber());
        parameters.put("fullName", sv50Model.getFullName());
        parameters.put("gender", sv50Model.getGender());
        parameters.put("municipalityOfBirth", sv50Model.getMunicipalityOfBirth());
        parameters.put("dob", sv50Model.getDob());
        parameters.put("foreignCitizenship", sv50Model.getForeignCitizenship());
        parameters.put("citizenship", sv50Model.getCitizenship());
        parameters.put("nationality", sv50Model.getNationality());
        parameters.put("residenceCountry", sv50Model.getResidenceCountry());
        parameters.put("residenceEntity", sv50Model.getResidenceEntity());
        parameters.put("residenceCanton", sv50Model.getResidenceCanton());
        parameters.put("residenceMunicipality", sv50Model.getResidenceMunicipality());
        parameters.put("residencePlaceAdress", sv50Model.getResidencePlaceAdress());
        parameters.put("currentTelephone", sv50Model.getCurrentTelephone());
        parameters.put("previousEducation", sv50Model.getPreviousEducation());
        parameters.put("previousFaculty", sv50Model.getPreviousFaculty());
        parameters.put("previousEducationCountry", sv50Model.getPreviousEducationCountry());
        parameters.put("previousEducationGraduationYear", sv50Model.getPreviousEducationGraduationYear());
        parameters.put("studyType", sv50Model.getStudyType());
        parameters.put("studyYear", sv50Model.getStudyYear());
        parameters.put("repeatYear", sv50Model.isRepeatYear());
        parameters.put("studentType", sv50Model.getStudentType());
        parameters.put("firstTimeEnrolledYear", sv50Model.getFirstTimeEnrolledYear());
        parameters.put("totalECTS", sv50Model.getTotalECTS());
        parameters.put("lastYearECTS", sv50Model.getLastYearECTS());
        parameters.put("financeWay", sv50Model.getFinanceWay());
        parameters.put("financeSource", sv50Model.getFinanceSource());
        parameters.put("scholarship", sv50Model.isScholarship());
        parameters.put("scholarshipAmount", sv50Model.getScholarshipAmount());
        parameters.put("parentActivity", sv50Model.getParentActivity());
        parameters.put("studentActivity", sv50Model.getStudentActivity());
        parameters.put("parentOccupation", sv50Model.getParentOccupation());
        parameters.put("studentOccupation", sv50Model.getStudentOccupation());
        parameters.put("studentEmployment", sv50Model.getStudentEmployment());
        parameters.put("parentEmployment", sv50Model.getParentEmployment());
        parameters.put("studentDisability", sv50Model.getStudentDisability());
    }

    public void putSV20Parameters(SV20Model sv20Model, HashMap<String, Object> parameters) {
        parameters.put("academicYear", sv20Model.getAcademicYear());
        parameters.put("university", sv20Model.getUniversity());
        parameters.put("faculty", sv20Model.getFaculty());
        parameters.put("department", sv20Model.getDepartment());
        parameters.put("studyProgram", sv20Model.getStudyProgram());
        parameters.put("facultyCanton", sv20Model.getFacultyCanton());
        parameters.put("facultyMunicipality", sv20Model.getFacultyMunicipality());
        parameters.put("facultyAdress", sv20Model.getFacultyAdress());
        parameters.put("facultyTelephone", sv20Model.getFacultyTelephone());
        parameters.put("personalIdentityNumber", sv20Model.getPersonalIdentityNumber());
        parameters.put("fullName", sv20Model.getFullName());
        parameters.put("gender", sv20Model.getGender());
        parameters.put("municipalityOfBirth", sv20Model.getMunicipalityOfBirth());
        parameters.put("dob", sv20Model.getDob());
        parameters.put("foreignCitizenship", sv20Model.getForeignCitizenship());
        parameters.put("citizenship", sv20Model.getCitizenship());
        parameters.put("nationality", sv20Model.getNationality());
        parameters.put("residenceCountry", sv20Model.getResidenceCountry());
        parameters.put("residenceEntity", sv20Model.getResidenceEntity());
        parameters.put("residenceCanton", sv20Model.getResidenceCanton());
        parameters.put("residenceMunicipality", sv20Model.getResidenceMunicipality());
        parameters.put("residencePlaceAdress", sv20Model.getResidencePlaceAdress());
        parameters.put("currentTelephone", sv20Model.getCurrentTelephone());
        parameters.put("previousEducation", sv20Model.getPreviousEducation());
        parameters.put("previousEducationCountry", sv20Model.getPreviousEducationCountry());
        parameters.put("previousEducationGraduationYear", sv20Model.getPreviousEducationGraduationYear());
        parameters.put("studyType", sv20Model.getStudyType());
        parameters.put("studyYear", sv20Model.getStudyYear());
        parameters.put("repeatYear", sv20Model.isRepeatYear());
        parameters.put("studentType", sv20Model.getStudentType());
        parameters.put("firstTimeEnrolledYear", sv20Model.getFirstTimeEnrolledYear());
        parameters.put("totalECTS", sv20Model.getTotalECTS());
        parameters.put("lastYearECTS", sv20Model.getLastYearECTS());
        parameters.put("financeWay", sv20Model.getFinanceWay());
        parameters.put("financeSource", sv20Model.getFinanceSource());
        parameters.put("scholarship", sv20Model.isScholarship());
        parameters.put("scholarshipAmount", sv20Model.getScholarshipAmount());
        parameters.put("parentActivity", sv20Model.getParentActivity());
        parameters.put("studentActivity", sv20Model.getStudentActivity());
        parameters.put("parentOccupation", sv20Model.getParentOccupation());
        parameters.put("studentOccupation", sv20Model.getStudentOccupation());
        parameters.put("studentEmployment", sv20Model.getStudentEmployment());
        parameters.put("parentEmployment", sv20Model.getParentEmployment());
        parameters.put("studentDisability", sv20Model.getStudentDisability());
    }
}
