package Classes.Report;

import Classes.Enum.ReportType;

public interface Report {
    ReportType getType();

    String getReportContent();

    String ReportDate();

    void generateReport();
}

