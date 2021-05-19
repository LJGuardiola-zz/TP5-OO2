package b.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Report implements Exportable {

    private final String report;

    public Report(String report) {
        this.report = report;
    }

    @Override
    public void export(File file) {
        Objects.requireNonNull(file);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
