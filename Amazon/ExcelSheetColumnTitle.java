package Amazon;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder resultString = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int rem = columnNumber % 26;
            resultString.append((char) ('A' + rem));
            columnNumber /= 26;
        }
        return resultString.reverse().toString();
    }
}
