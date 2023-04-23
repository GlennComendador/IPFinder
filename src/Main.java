import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {

        //JFrame Initialization
        JFrame jFrame = new JFrame("IP Finder Program");
        jFrame.setLayout(new GridLayout());
        jFrame.setBounds(100,100,1000,100);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);

        //JLabel Initialization
        JLabel label = new JLabel("Enter URL: ");
        label.setFont(new Font("Arial", Font.PLAIN, 20));

        //JTextField Initialization
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 20));

        //JButton Initialization
        JButton button = new JButton("Find IP");
        button.setFont(new Font("Arial", Font.PLAIN, 20));

        //Button Actions
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url = textField.getText();

                try {

                    InetAddress ia = InetAddress.getByName(url);
                    String ip = ia.getHostAddress();
                    JOptionPane.showMessageDialog(jFrame, ip);

                } catch (UnknownHostException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jFrame.add(label);
        jFrame.add(textField);
        jFrame.add(button);
        jFrame.setVisible(true);
    }
}
