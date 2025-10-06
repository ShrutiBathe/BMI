
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Update extends JFrame {
    public Update() {
        setSize(500, 400);
        setVisible(true);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(10, 2));
        cp.setBackground(Color.decode("#a8adf7")); // Set background color

        // Set font
        Font ft = new Font("Snap ITC", Font.BOLD, 24);
        Font ft1 = new Font("Snap ITC", Font.BOLD, 20);

        JLabel l1 = new JLabel("Update Part");
        l1.setFont(ft);
        l1.setForeground(Color.decode("#14375c"));

        JLabel id = new JLabel("ID");
        id.setFont(ft1);

        JLabel name = new JLabel("Name");
        name.setFont(ft1);

        JLabel quantity = new JLabel("Quantity");
        quantity.setFont(ft1);

        JLabel price = new JLabel("Price");
        price.setFont(ft1);

        JLabel company = new JLabel("Company Name");
        company.setFont(ft1);

        JTextField idtf = new JTextField(15);
        JTextField nametf = new JTextField(15);
        JTextField quantitytf = new JTextField(15);
        JTextField pricetf = new JTextField(15);
        JTextField companytf = new JTextField(15);

        JButton update = new JButton("Update");
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String id = idtf.getText();
                String name = nametf.getText();
                String quantity = quantitytf.getText();
                String price = pricetf.getText();
                String company = companytf.getText();
                Products products = new Products();
                products.update(id, name, quantity, price, company);
                System.out.println("Product updated successfully!");
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
    }
}

class Delete extends JFrame {
    public Delete() {
        setSize(200, 200);
        setVisible(true);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(10, 2));
        cp.setBackground(Color.decode("#a8adf7")); // Set background color

        // Set font
        Font ft = new Font("Snap ITC", Font.BOLD, 24);
        Font ft1 = new Font("Snap ITC", Font.BOLD, 20);

        JLabel l1 = new JLabel("Delete Part");
        l1.setFont(ft);
        l1.setForeground(Color.decode("#14375c"));

        JLabel id = new JLabel("ID");
        id.setFont(ft1);

        JTextField idtf = new JTextField(15);

        JButton delete = new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String id = idtf.getText();
                Products products = new Products();
                products.delete(id);
                System.out.println("Product deleted successfully!");
            }
        });

        cp.add(l1);
        cp.add(new JLabel());
        cp.add(id);
        cp.add(idtf);
        cp.add(delete);
    }


}

            class Products extends JFrame implements ActionListener {
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
            
                private ImageIcon resizeImage(ImageIcon icon, int width, int height) {
                    Image image = icon.getImage();
                    Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    return new ImageIcon(resizedImage);
                }
                public void actionPerformed(ActionEvent ae) {
                    if (ae.getActionCommand().equals("Add")) {
                        new AddProducts();
                        dispose();
                    }
                }
            }
