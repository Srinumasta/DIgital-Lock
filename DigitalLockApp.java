import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitalLockApp {
    private static DigitalLock lock = new DigitalLock("");

    public static void main(String[] args) {
        JFrame frame = new JFrame("Digital Lock");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        // Create Password Panel
        JPanel createPanel = new JPanel();
        createPanel.setLayout(new GridLayout(2, 1));
        JTextField createPasswordField = new JTextField();
        JButton createButton = new JButton("Create Password");
        createPanel.add(new JLabel("Create Password:"));
        createPanel.add(createPasswordField);
        createPanel.add(createButton);
        frame.add(createPanel);

        // Unlock Panel
        JPanel unlockPanel = new JPanel();
        unlockPanel.setLayout(new GridLayout(2, 1));
        JTextField unlockPasswordField = new JTextField();
        JButton unlockButton = new JButton("Unlock");
        unlockPanel.add(new JLabel("Unlock:"));
        unlockPanel.add(unlockPasswordField);
        unlockPanel.add(unlockButton);
        frame.add(unlockPanel);

        // Change Password Panel
        JPanel changePanel = new JPanel();
        changePanel.setLayout(new GridLayout(4, 1));
        JTextField oldPasswordField = new JTextField();
        JTextField newPasswordField = new JTextField();
        JButton changeButton = new JButton("Change Password");
        changePanel.add(new JLabel("Old Password:"));
        changePanel.add(oldPasswordField);
        changePanel.add(new JLabel("New Password:"));
        changePanel.add(newPasswordField);
        changePanel.add(changeButton);
        frame.add(changePanel);

        // Message Label
        JLabel messageLabel = new JLabel("", SwingConstants.CENTER);
        frame.add(messageLabel);

        // Action Listeners
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = createPasswordField.getText();
                if (!password.isEmpty()) {
                    lock = new DigitalLock(password);
                    messageLabel.setText("Password created successfully.");
                } else {
                    messageLabel.setText("Password cannot be empty.");
                }
            }
        });

        unlockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = unlockPasswordField.getText();
                if (!password.isEmpty()) {
                    if (lock.unlock(password)) {
                        messageLabel.setText("Lock unlocked.");
                    } else {
                        messageLabel.setText("Incorrect password.");
                    }
                } else {
                    messageLabel.setText("Password cannot be empty.");
                }
            }
        });

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPassword = oldPasswordField.getText();
                String newPassword = newPasswordField.getText();
                if (!oldPassword.isEmpty() && !newPassword.isEmpty()) {
                    if (lock.changePassword(oldPassword, newPassword)) {
                        messageLabel.setText("Password changed successfully.");
                    } else {
                        messageLabel.setText("Incorrect old password.");
                    }
                } else {
                    messageLabel.setText("Passwords cannot be empty.");
                }
            }
        });

        frame.setVisible(true);
    }
}