import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Update extends JFrame {
    public Update() {
        setSize(500, 400);
        setVisible(true);
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(10, 2));

        Label l1 = new Label("Update Part");
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

        JButton update = new JButton("Update");
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String id = idtf.getText();
                String name = nametf.getText();
                String quantity = quantitytf.getText();
                String price = pricetf.getText();
                String max = maxtf.getText();
                String min = mintf.getText();
                String company = companytf.getText();

                // Assuming a Product class with an update method
                Product product = new Product();
                product.update(id, name, quantity, price, max, min, company);

                System.out.println("Product updated successfully!");
            }
        });

        cp.add(l1);
        cp.add(new Label());
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
        cp.add(update);
    }
}

