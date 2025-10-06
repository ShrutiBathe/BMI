
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddProducts extends JFrame 
{
    public AddProducts()
     {
        JLabel background = new JLabel();
        background.setIcon(resizeImage(new ImageIcon("img5.jpg"), 400, 400));
        background.setLayout(new FlowLayout());
        add(background);

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

        JButton save = new JButton("Save");
        JButton cancel = new JButton("Cancel");

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

