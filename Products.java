
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Products extends JFrame implements ActionListener 
{
        private final int IMAGE_WIDTH = 100;
        private final int IMAGE_HEIGHT = 50;
            
        public Products() 
        {
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
                public void actionPerformed(ActionEvent ae) 
                {
                    if (ae.getActionCommand().equals("Add")) 
                    {
                        new AddProducts();
                        dispose();
                    }
                    if (ae.getActionCommand().equals("Upadte")) {
                        new Update();
                        dispose();
                    }
                    if (ae.getActionCommand().equals("Delete")) {
                        new Delete();
                        dispose();
                    }
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

        Label l1 = new Label("Add Part");
        Label id = new Label("ID");
        Label name = new Label("Name");
        Label quantity = new Label("Quantity");
        Label price = new Label("Price");
        Label max = new Label("Max");
        Label min = new Label("Min");
        Label company = new Label("Company Name");

        JTextField idtf = new JTextField(15);
        JTextField nametf = new JTextField(15);
        JTextField quantitytf = new JTextField(15);
        JTextField pricetf = new JTextField(15);
        JTextField maxtf = new JTextField(15);
        JTextField mintf = new JTextField(15);
        JTextField companytf = new JTextField(15);

        //JButton save = new JButton("Save");
        // JButton cancel = new JButton("Cancel");
        ImageIcon saveimg = new ImageIcon("save.jpg");
        saveimg = resizeImage(saveimg, IMAGE_WIDTH, IMAGE_HEIGHT);
        JButton save = new JButton("Save", saveimg);
    
        ImageIcon cancelimg=new ImageIcon("cancel.jpg");
        cancelimg=resizeImage(cancelimg,IMAGE_WIDTH,IMAGE_HEIGHT);
       JButton cancel=new JButton("Canel",cancelimg);

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
                dispose(); // Close current frame
                new Products(); // Open Products frame
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
        cp.setBackground(Color.cyan);
        JLabel l1 = new JLabel("Update Part");
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
        JButton update = new JButton("Update");
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String id = idtf.getText();
                String name = nametf.getText();
                String quantity = quantitytf.getText();
                String price = pricetf.getText();
                String company = companytf.getText();
                Product product = new Product();
                product.update(id, name, quantity, price, company);
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
        JLabel l1 = new JLabel("Delete Part");
        JLabel id = new JLabel("ID");
        JTextField idtf = new JTextField(15);
        JButton delete = new JButton("Delete");
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String id = idtf.getText();
                Product product = new Product();
                product.delete(id);
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
public static void main(String args[])
{
    new Products();
}
