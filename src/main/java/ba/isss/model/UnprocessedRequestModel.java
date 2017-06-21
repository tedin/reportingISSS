package ba.isss.model;

public class UnprocessedRequestModel {

    private Long id;

    private String firstName;
    private String lastName;
    private String reason;
    private String comment;

    private boolean downloaded;

    public UnprocessedRequestModel() {
    }

    public UnprocessedRequestModel(Long id, String firstName, String lastName, String reason, String comment, boolean downloaded) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.reason = reason;
        this.comment = comment;
        this.downloaded = downloaded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isDownloaded() {
        return downloaded;
    }

    public void setDownloaded(boolean downloaded) {
        this.downloaded = downloaded;
    }

    @Override
    public String toString() {
        return "ba.utic.isss.jr.UnprocessedRequestModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", reason='" + reason + '\'' +
                ", comment='" + comment + '\'' +
                ", downloaded=" + downloaded +
                '}';
    }
}
