
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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

    public static void main(String args[]) {
        new AddProducts();
    }
}
