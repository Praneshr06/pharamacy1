package pharamacypack;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PharmacyManagement extends Frame implements ActionListener {
    Label patientNameLabel, contactLabel, addressLabel, genderLabel, medicineLabel, dateLabel, totalPriceLabel, doctorLabel;
    TextField patientNameField, contactField, addressField, doctorField;
    Choice genderChoice, medicineChoice;
    CheckboxGroup genderGroup;
    Button submitButton, clearButton, calculatePriceButton;
    TextArea cartTextArea;
    Checkbox urgentCheckbox, prescriptionCheckbox;
    Panel panel;
    Date dateOfPurchase;
    double totalPrice = 0;

    public PharmacyManagement() {
        setTitle("Pharmacy Management System");
        setSize(600, 400);
        setLayout(new BorderLayout());

        panel = new Panel();
        panel.setLayout(null);

        patientNameLabel = new Label("Patient Name:");
        patientNameLabel.setBounds(50, 50, 100, 20);
        panel.add(patientNameLabel);

        patientNameField = new TextField();
        patientNameField.setBounds(160, 50, 150, 20);
        panel.add(patientNameField);

        contactLabel = new Label("Contact:");
        contactLabel.setBounds(50, 80, 100, 20);
        panel.add(contactLabel);

        contactField = new TextField();
        contactField.setBounds(160, 80, 150, 20);
        panel.add(contactField);

        addressLabel = new Label("Address:");
        addressLabel.setBounds(50, 110, 100, 20);
        panel.add(addressLabel);

        addressField = new TextField();
        addressField.setBounds(160, 110, 150, 20);
        panel.add(addressField);

        genderLabel = new Label("Gender:");
        genderLabel.setBounds(50, 140, 100, 20);
        panel.add(genderLabel);

        genderChoice = new Choice();
        genderChoice.setBounds(160, 140, 100, 20);
        genderChoice.add("Male");
        genderChoice.add("Female");
        genderChoice.add("Other");
        panel.add(genderChoice);

        medicineLabel = new Label("Medicine:");
        medicineLabel.setBounds(50, 170, 100, 20);
        panel.add(medicineLabel);

        medicineChoice = new Choice();
        medicineChoice.setBounds(160, 170, 150, 20);
        medicineChoice.add("Dolo 650");
        medicineChoice.add("Lacto calamite");
        medicineChoice.add("Vicks");
        medicineChoice.add("Moov");
        medicineChoice.add("Dilorex");
        medicineChoice.add("Cough Syrup");
        medicineChoice.add("Electrol");
        panel.add(medicineChoice);

        urgentCheckbox = new Checkbox("Urgent");
        urgentCheckbox.setBounds(50, 200, 100, 20);
        panel.add(urgentCheckbox);

        prescriptionCheckbox = new Checkbox("Prescription");
        prescriptionCheckbox.setBounds(160, 200, 100, 20);
        panel.add(prescriptionCheckbox);

        doctorLabel = new Label("Doctor:");
        doctorLabel.setBounds(50, 230, 100, 20);
        panel.add(doctorLabel);

        doctorField = new TextField();
        doctorField.setBounds(160, 230, 150, 20);
        panel.add(doctorField);

        dateLabel = new Label("Date of Purchase:");
        dateLabel.setBounds(50, 260, 100, 20);
        panel.add(dateLabel);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateOfPurchase = new Date();
        Label dateValueLabel = new Label(dateFormat.format(dateOfPurchase));
        dateValueLabel.setBounds(160, 260, 150, 20);
        panel.add(dateValueLabel);

        totalPriceLabel = new Label("Total Price:");
        totalPriceLabel.setBounds(50, 290, 100, 20);
        panel.add(totalPriceLabel);

        calculatePriceButton = new Button("Calculate Price");
        calculatePriceButton.setBounds(160, 290, 100, 20);
        calculatePriceButton.addActionListener(this);
        panel.add(calculatePriceButton);

        cartTextArea = new TextArea();
        cartTextArea.setBounds(350, 50, 200, 200);
        panel.add(cartTextArea);

        submitButton = new Button("Submit");
        submitButton.setBounds(50, 330, 80, 30);
        submitButton.addActionListener(this);
        panel.add(submitButton);

        clearButton = new Button("Clear");
        clearButton.setBounds(160, 330, 80, 30);
        clearButton.addActionListener(this);
        panel.add(clearButton);

        add(panel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String patientName = patientNameField.getText();
            String contact = contactField.getText();
            String address = addressField.getText();
            String gender = genderChoice.getSelectedItem();
            String medicine = medicineChoice.getSelectedItem();
            String doctor = doctorField.getText();
            boolean isUrgent = urgentCheckbox.getState();
            boolean isPrescription = prescriptionCheckbox.getState();
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateOfPurchase);

            // Adding the selected medicine to the cart
            String cartItem = "Medicine: " + medicine + ", Price: $" + totalPrice + "\n";
            cartTextArea.append(cartItem);

            // Here you can perform actions with the collected data,
            // like saving to a database or displaying in a table.
            System.out.println("Patient Name: " + patientName);
            System.out.println("Contact: " + contact);
            System.out.println("Address: " + address);
            System.out.println("Gender: " + gender);
            System.out.println("Medicine: " + medicine);
            System.out.println("Doctor: " + doctor);
            System.out.println("Urgent: " + isUrgent);
            System.out.println("Prescription: " + isPrescription);
            System.out.println("Date of Purchase: " + date);
            System.out.println("Total Price: $" + totalPrice);

            // Show submit window
            showSubmitWindow();
        } else if (e.getSource() == clearButton) {
            patientNameField.setText("");
            contactField.setText("");
            addressField.setText("");
            genderChoice.select(0);
            medicineChoice.select(0);
            urgentCheckbox.setState(false);
            prescriptionCheckbox.setState(false);
            doctorField.setText("");
            cartTextArea.setText("");
            totalPrice = 0;
            totalPriceLabel.setText("Total Price:");
        } else if (e.getSource() == calculatePriceButton) {
            // Assuming simple price calculation based on medicine selection
            String selectedMedicine = medicineChoice.getSelectedItem();
            if (selectedMedicine.equals("Dolo 650")) {
                totalPrice = 2.0;
            } else if (selectedMedicine.equals("Lacto calamite")) {
                totalPrice = 300.0;
            } else if (selectedMedicine.equals("Vicks")) {
                totalPrice = 20.0;
            } else if (selectedMedicine.equals("Moov")) {
                totalPrice = 150.0;
            } else if (selectedMedicine.equals("Dilorex")) {
                totalPrice = 150.0;
            } else if (selectedMedicine.equals("Cough Syrup")) {
                totalPrice = 200.0;
            } else if (selectedMedicine.equals("Electrol")) {
                totalPrice = 100.0;
            }
            totalPriceLabel.setText("Total Price: $" + totalPrice);
        }
    }

    private void showSubmitWindow() {
        // Create a new frame for submission confirmation
        Frame submitFrame = new Frame("Submitted Successfully");
        submitFrame.setSize(300, 100);
        submitFrame.setLayout(new FlowLayout());

        // Label to display submission message
        Label submitLabel = new Label("Submitted Successfully!");
        submitFrame.add(submitLabel);

        // Button to close the frame
        Button okButton = new Button("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitFrame.dispose(); // Close the frame when OK is clicked
            }
        });
        submitFrame.add(okButton);

        // Make sure the frame is disposed when the close button is clicked
        submitFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                submitFrame.dispose();
            }
        });

        // Make the frame visible
        submitFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new PharmacyManagement();
    }
}