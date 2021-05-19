package b;

import b.model.Exportable;
import b.model.Report;
import b.model.ReportChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ReportTest {

    private static final File FILE = new File("report.txt");
    private static final String EXPECTED_MESSAGE = "Mensaje de reporte de ejemplo";

    @Test
    void export_report_by_overwriting() throws IOException {
        Exportable report = new Report(EXPECTED_MESSAGE);
        report.export(FILE);
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            Assertions.assertEquals(
                    EXPECTED_MESSAGE, reader.readLine()
            );
        }
    }

    @Test
    void export_record_without_overwriting() {
        Exportable report = new ReportChecker(new Report(EXPECTED_MESSAGE));
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> report.export(FILE)
        );
    }

}
