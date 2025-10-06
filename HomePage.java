import javax.swing.*;
import java.awt.event.*;
public class HomePage extends JFrame 
{
    public HomePage() 
    {
        setTitle("Home");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() 
    {
        JButton productButton = new JButton("Manage Products");
        JButton stockButton = new JButton("View Stock");
        JButton customerButton = new JButton("Manage Customers");
        JButton supplierButton = new JButton("Manage Suppliers");
        JButton salesButton = new JButton("Sales");
        JButton purchaseButton = new JButton("Purchases");

        JPanel panel = new JPanel();
        panel.add(productButton);
        panel.add(stockButton);
        panel.add(customerButton);
        panel.add(supplierButton);
        panel.add(salesButton);
        panel.add(purchaseButton);
        
        add(panel);

        productButton.addActionListener(e -> new ProductPage().setVisible(true));
        customerButton.addActionListener(e -> new CustomerPage().setVisible(true));
        stockButton.addActionListener(e -> new CurrentStockPage().setVisible(true));
        supplierButton.addActionListener(e -> new SupplierPage().setVisible(true));
        salesButton.addActionListener(e -> new SalesPage().setVisible(true));
        purchaseButton.addActionListener(e -> new PurchasePage().setVisible(true));

    }
}
