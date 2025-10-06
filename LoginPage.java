import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class LoginPage extends JFrame implements ActionListener 
{
    public LoginPage() 
    {
        // Set background image
        JLabel background = new JLabel();
        background.setIcon(resizeImage(new ImageIcon("img4.jpg"), 300, 300));
        background.setLayout(new FlowLayout());
        add(background);

        JTextField usernametf = new JTextField(15);
        JPasswordField passwordtf = new JPasswordField(15);
        JButton submit = new JButton("Submit");
        submit.addActionListener(this);

        background.add(new Label("Welcome To Inventory Management System !!"));
        background.add(new Label("User Name"));
        background.add(usernametf);
        background.add(new Label("Password "));
        background.add(passwordtf);
        background.add(submit);

        setSize(300, 300);
        setVisible(true);
    }

    // Added resizeImage method
    private ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getActionCommand().equals("Submit")) 
        {
            new Products();
            dispose();
        }
    }

    public static void main(String args[]) 
    {
        new LoginPage();
    }
}

class Products extends JFrame implements ActionListener 
{
    private final int IMAGE_WIDTH = 100;
    private final int IMAGE_HEIGHT = 50;

    public Products() {
        setSize(400, 400);
        setVisible(true);
        setLayout(new FlowLayout());

        // Set background image
        JLabel background = new JLabel();
        background.setIcon(resizeImage(new ImageIcon("img2.jpg"), 400, 400));
        background.setLayout(new FlowLayout());
        add(background);

        // Add image
        ImageIcon addimg = new ImageIcon("add.jpg");
        addimg = resizeImage(addimg, IMAGE_WIDTH, IMAGE_HEIGHT);
        JButton add = new JButton("Add", addimg);
        background.add(add);

        // Update image
        ImageIcon updateimg = new ImageIcon("update.jpg");
        updateimg = resizeImage(updateimg, IMAGE_WIDTH, IMAGE_HEIGHT);
        JButton update = new JButton("Update", updateimg);
        background.add(update);

        // Delete image
        ImageIcon deleteimg = new ImageIcon("delete.jpg");
        deleteimg = resizeImage(deleteimg, IMAGE_WIDTH, IMAGE_HEIGHT);
        JButton delete = new JButton("Delete", deleteimg);
        background.add(delete);

        // View image
        ImageIcon viewimg = new ImageIcon("print.jpg");
        viewimg = resizeImage(viewimg, IMAGE_WIDTH, IMAGE_HEIGHT);
        JButton view = new JButton("View", viewimg);
        background.add(view);

        Font f1 = new Font("Algerian", Font.BOLD, 18);
        JLabel l1 = new JLabel("Perform The Following Operation !!!");
        l1.setFont(f1);
        background.add(l1);

        add.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        view.addActionListener(this);
    }

    private ImageIcon resizeImage(ImageIcon icon, int width, int height) 
    {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getActionCommand().equals("Add")) 
        {
            new AddProducts();
            dispose();
        }
        if (ae.getActionCommand().equals("Update")) 
        {
            new Update();
            dispose();
        }
        if (ae.getActionCommand().equals("Delete")) 
        {
            new Delete();
            dispose();
        }
        if (ae.getActionCommand().equals("View")) 
        {
            new View();
            dispose();
        }
    }
    public void update(String id, String name, String quantity, String price, String company) {
        // Update the product in the database or data structure
        System.out.println("Updating product with ID " + id);
        // Your update logic here
    }
    public void delete(String id) {
        // Delete the product from the database or data structure
        System.out.println("Deleting product with ID " + id);
        // Your delete logic here
    }

}

class AddProducts extends JFrame {
    private final int IMAGE_WIDTH = 100;
    private final int IMAGE_HEIGHT = 50;

    public AddProducts() {
        setSize(500, 400);
        setVisible(true);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(10, 2));
        cp.setBackground(Color.decode("#a8adf7")); // Set background color

        Label l1 = new Label("ADD PRODUCT");
        Label id = new Label("ID");
        Label name = new Label("Name");
        Label quantity = new Label("Quantity");
        Label price = new Label("Price");
        Label max = new Label("Max");
        Label min = new Label("Min");
        Label company = new Label("Company Name");
        //set font
        Font ft = new Font("Snap ITC", Font.BOLD, 24);
        l1.setFont(ft);
        l1.setForeground(Color.decode("#14375c")); 
        Font ft1 = new Font("Snap ITC", Font.BOLD, 20);
        id.setFont(ft1);
        name.setFont(ft1);
        quantity.setFont(ft1);
        price.setFont(ft1);
        max.setFont(ft1);
        min.setFont(ft1);
        company.setFont(ft1);

        JTextField idtf = new JTextField(15);
        JTextField nametf = new JTextField(15);
        JTextField quantitytf = new JTextField(15);
        JTextField pricetf = new JTextField(15);
        JTextField maxtf = new JTextField(15);
        JTextField mintf = new JTextField(15);
        JTextField companytf = new JTextField(15);

        ImageIcon saveimg = new ImageIcon("save.jpg");
        saveimg = resizeImage(saveimg, IMAGE_WIDTH, IMAGE_HEIGHT);
        JButton save = new JButton("Save", saveimg);

        ImageIcon cancelimg = new ImageIcon("cancel.jpg");
        cancelimg = resizeImage(cancelimg, IMAGE_WIDTH, IMAGE_HEIGHT);
        JButton cancel = new JButton("Cancel", cancelimg);

        JRadioButton b1 = new JRadioButton("In-House");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {}
        });

        JRadioButton b2 = new JRadioButton("OutSourced");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {}
        });

        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);

        cp.add(l1);
        cp.add(new Label());
        cp.add(b1);
        cp.add(b2);
        cp.add(id);
        cp.add(idtf);
        cp.add(name);
        cp.add(nametf);
        cp.add(quantity);
        cp.add(quantitytf);
        cp.add(price);
        cp.add(pricetf);
        cp.add(max);
        cp.add(maxtf);
        cp.add(min);
        cp.add(mintf);
        cp.add(company);
        cp.add(companytf);
        cp.add(save);
        cp.add(cancel);

        // Add ActionListener to Cancel button
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new Products();
            }
        });

        // Add ActionListener to Save button
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String productID = idtf.getText();
                String productName = nametf.getText();
                String productQuantity = quantitytf.getText();
                String productPrice = pricetf.getText();
                String productMax = maxtf.getText();
                String productMin = mintf.getText();
                String productCompany = companytf.getText();

                System.out.println("Product added successfully!");
            }
        });
    }

    private ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}

class Update extends JFrame 
{
    public Update() 
    {
        setSize(500, 400);
        setVisible(true);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(10, 2));
        cp.setBackground(Color.decode("#a8adf7"));
        JLabel l1 = new JLabel("Update Part");
        Font ft = new Font("Snap ITC", Font.BOLD, 24);
        l1.setFont(ft);
        l1.setForeground(Color.decode("#14375c")); 

        JLabel id = new JLabel("ID");
        JLabel name = new JLabel("Name");
        JLabel quantity = new JLabel("Quantity");
        JLabel price = new JLabel("Price");
        JLabel company = new JLabel("Company Name");
        JTextField idtf = new JTextField(15);
        JTextField nametf = new JTextField(15);
        JTextField quantitytf = new JTextField(15);
        JTextField pricetf = new JTextField(15);
        JTextField companytf = new JTextField(15);

        Font ft1 = new Font("Arial", Font.BOLD, 20);
        id.setFont(ft1);
        name.setFont(ft1);
        quantity.setFont(ft1);
        price.setFont(ft1);
        company.setFont(ft1);

        JButton update = new JButton("Update");
        JButton cancel = new JButton("Cancel");
        update.setFont(ft1);
        cancel.setFont(ft1);
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String id = idtf.getText();
                String name = nametf.getText();
                String quantity = quantitytf.getText();
                String price = pricetf.getText();
                String company = companytf.getText();
                Products product1 = new Products();
                product1.update(id, name, quantity, price, company);
                System.out.println("Product updated successfully!");
            }
        });
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose(); // Close current frame
                new Products(); // Open Products frame
            }
        });
        cp.add(l1);
        cp.add(new JLabel());
        cp.add(id);
        cp.add(idtf);
        cp.add(name);
        cp.add(nametf);
        cp.add(quantity);
        cp.add(quantitytf);
        cp.add(price);
        cp.add(pricetf);
        cp.add(company);
        cp.add(companytf);
        cp.add(update);
        cp.add(cancel);
    }
}
class Delete extends JFrame 
{
    public Delete() 
    {
        JLabel background = new JLabel();
        background.setIcon(resizeImage(new ImageIcon("img5.jpg"), 300, 300));
        background.setLayout(new FlowLayout());
        add(background);
        setSize(300, 300);
        setVisible(true);
       
        JTextField idtf = new JTextField(15);
        JButton delete = new JButton("Delete");
        JButton cancel = new JButton("Cancel");
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String id = idtf.getText();
                Products product = new Products();
                product.delete(id);
                System.out.println("Product deleted successfully!");
            }
        });
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose(); // Close current frame
                new Products(); // Open Products frame
            }
        });
        background.add(new JLabel());
        background.add(new Label("Product ID "));
        background.add(idtf);
        background.add(delete);
        background.add(cancel);
    }
    private ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
class View extends JFrame {
    private final int IMAGE_WIDTH = 100;
    private final int IMAGE_HEIGHT = 20;

    public View() 
    {
        JLabel background = new JLabel();
        background.setIcon(resizeImage(new ImageIcon("show.jpg"), 300, 300));
        background.setLayout(new FlowLayout());
        add(background);
        setSize(800, 600);
        setVisible(true);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Create a table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Quantity");
        model.addColumn("Price");
        model.addColumn("Company Name");

        // Add data to the table model
        model.addRow(new Object[]{"1", "Product 1", "10", "100", "Company 1"});
        model.addRow(new Object[]{"2", "Product 2", "20", "200", "Company 2"});
        model.addRow(new Object[]{"3", "Product 3", "30", "300", "Company 3"});

        // Create a JTable
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a panel for the cancel button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        ImageIcon cancelimg = new ImageIcon("cancel.jpg");
        cancelimg = resizeImage(cancelimg, IMAGE_WIDTH, IMAGE_HEIGHT);
        JButton cancel = new JButton("Cancel", cancelimg);

        // Add action listener to cancel button
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose(); // Close current frame
                new Products(); // Open Products frame
            }
        });

        // Add cancel button to button panel
        buttonPanel.add(cancel);

        // Add scroll pane and button panel to content pane
        cp.add(scrollPane, BorderLayout.CENTER);
        cp.add(buttonPanel, BorderLayout.SOUTH);
    }

    private ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}

