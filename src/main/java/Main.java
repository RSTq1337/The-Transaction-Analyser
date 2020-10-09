import io.Reader;
import io.impl.CSVReader;
import model.Args;
import model.Report;
import model.Transaction;
import service.Reporter;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Args arguments = new Args(
                "D:\\\\packageForProjects\\\\analizer\\\\src\\\\main\\\\resources\\\\data.csv",
                "20/08/2018 12:00:00",
                "20/08/2018 13:00:00",
                "Kwik-E-Mart");
        String extension = arguments.getPath().substring(arguments.getPath().lastIndexOf('.') + 1);
        if (extension.equals("csv")) {
            Reader<Transaction> csvReader = new CSVReader();
            Map<String, Transaction> transactions = csvReader.read(arguments.getPath());
            Reporter reporter = new Reporter();
            Report report = reporter.report(transactions, arguments);
            System.out.println(report);
        } else {
            System.out.println("File extension" + '"' + extension + '"' + "currently not supported");
        }
    }
}

