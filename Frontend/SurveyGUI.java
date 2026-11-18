package Frontend;

import javax.swing.*;
import java.awt.*;

public class SurveyGUI extends JFrame {

    private surveyInput survey = new surveyInput();
    private services community = new services(true, true, true);
    private gapIdentifier gap = new gapIdentifier(community);

    private JTextField responseField = new JTextField(25);
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> responseList = new JList<>(listModel);

    private JLabel statusLabel = new JLabel();

    public SurveyGUI() {

        setTitle("Community Needs Survey");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        survey.addListener(gap);

        JLabel title = new JLabel("Community Needs Survey");
        title.setHorizontalAlignment(JLabel.CENTER);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        topPanel.add(title, BorderLayout.NORTH);
        topPanel.add(responseField, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        add(new JScrollPane(responseList), BorderLayout.CENTER);

        JButton addButton = new JButton("Add Response");
        JButton removeButton = new JButton("Remove Selected");
        JButton clearButton = new JButton("Clear All");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(clearButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(statusLabel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            try {
                survey.addResponse(responseField.getText());
                responseField.setText("");
                refreshDisplay();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        removeButton.addActionListener(e -> {
            try {
                survey.removeResponse(responseList.getSelectedIndex());
                gap.updateGaps(survey);
                refreshDisplay();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        clearButton.addActionListener(e -> {
            survey.clearResponses();
            gap.updateGaps(survey);
            refreshDisplay();
        });

        refreshDisplay();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void refreshDisplay() {

        listModel.clear();

        for (String response : survey.getResponse()) {
            listModel.addElement(response);
        }

        String status = "Community Needs: ";

        if (!community.getHousing()) {
            status += "Housing ";
        }

        if (!community.getFood()) {
            status += "Food ";
        }

        if (!community.getElectric()) {
            status += "Electricity ";
        }

        if (community.getHousing()
                && community.getFood()
                && community.getElectric()) {
            status += "None identified";
        }

        statusLabel.setText(status);
    }
}
