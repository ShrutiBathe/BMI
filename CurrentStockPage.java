import javax.swing.*;

public class CurrentStockPage extends JFrame {
    private JTable stockTable;

    public CurrentStockPage() {
        setTitle("Current Stock");
        setSize(500, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        stockTable = new JTable();
        // Add table model to represent stock data

        add(new JScrollPane(stockTable));
    }
}
