package b.model;

import java.io.File;
import java.util.Objects;

public class ReportChecker implements Exportable {

    private final Report report;

    public ReportChecker(Report report) {
        this.report = report;
    }

    @Override
    public void export(File file) {
        Objects.requireNonNull(file);
        if (file.exists()) {
            throw new IllegalArgumentException(
                    "El archivo ya existe..."
            );
        }
        report.export(file);
    }

}
