package ba.isss.util;

public enum ReportFormat {
    PDF(".pdf"), HTML(".html");

    private String fileExtension;

    private ReportFormat(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    public String toString() {
        return fileExtension;
    }
}
