package my.toys.pojos;

import java.util.ArrayList;
import java.util.List;

import my.toys.entity.Product;
/**
 * This class holds the records returned by parser.
 * @author Guru
 *
 */
public class CsvTransfer {

    private List<String[]> csvStringList;

    private List<Product> csvList;

    public CsvTransfer() {}

    public List<String[]> getCsvStringList() {
        if (csvStringList != null) return csvStringList;
        return new ArrayList<String[]>();
    }

    public void addLine(String[] line) {
        if (this.csvList == null) this.csvStringList = new ArrayList<>();
        this.csvStringList.add(line);
    }

    public void setCsvStringList(List<String[]> csvStringList) {
        this.csvStringList = csvStringList;
    }

    public void setCsvList(List<Product> csvList) {
        this.csvList = csvList;
    }

    public List<Product> getCsvList() {
        if (csvList != null) return csvList;
        return new ArrayList<Product>();
    }
}