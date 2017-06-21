package ba.isss.model;

import org.springframework.stereotype.Component;

/**
 * Created by edin on 21.6.2017..
 */
@Component
public class OrganizationalUnit {
    private String faculty;
    private String department;
    private String studyProgram;
    private String facultyCanton;
    private String facultyMunicipality;
    private String facultyAdress;
    private String facultyTelephone;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }

    public String getFacultyCanton() {
        return facultyCanton;
    }

    public void setFacultyCanton(String facultyCanton) {
        this.facultyCanton = facultyCanton;
    }

    public String getFacultyMunicipality() {
        return facultyMunicipality;
    }

    public void setFacultyMunicipality(String facultyMunicipality) {
        this.facultyMunicipality = facultyMunicipality;
    }

    public String getFacultyAdress() {
        return facultyAdress;
    }

    public void setFacultyAdress(String facultyAdress) {
        this.facultyAdress = facultyAdress;
    }

    public String getFacultyTelephone() {
        return facultyTelephone;
    }

    public void setFacultyTelephone(String facultyTelephone) {
        this.facultyTelephone = facultyTelephone;
    }
}
