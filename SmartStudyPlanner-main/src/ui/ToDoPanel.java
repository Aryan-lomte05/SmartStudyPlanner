package ui;
import model.Task;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.awt.event.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class ToDoPanel extends JPanel {
    //Take 1
    //    private DefaultListModel<Task> taskListModel;
//    private JList<Task> taskJList;
//    private JTextField titleField;
//    private JTextField descField;
//    private JTextField deadlineField;
//
//    private ArrayList<Task> taskStorage = new ArrayList<>();
//    public ToDoPanel()
//    {
//        setLayout(new BorderLayout());
//
//        // List area
//        taskListModel = new DefaultListModel<>();
//        taskJList = new JList<>(taskListModel);
//        add(new JScrollPane(taskJList), BorderLayout.CENTER);
//
//        // Input + Buttons
//        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
//
//        titleField = new JTextField();
//        descField = new JTextField();
//        deadlineField = new JTextField(); // Format: YYYY-MM-DD
//
//        JButton addBtn = new JButton("Add");
//        JButton delBtn = new JButton("Delete");
//        JButton markBtn = new JButton("Mark Done");
//
//        inputPanel.add(new JLabel("Title:"));
//        inputPanel.add(titleField);
//        inputPanel.add(new JLabel("Description:"));
//        inputPanel.add(descField);
//        inputPanel.add(new JLabel("Deadline (YYYY-MM-DD):"));
//        inputPanel.add(deadlineField);
//        inputPanel.add(addBtn);
//        inputPanel.add(delBtn);
//        inputPanel.add(markBtn);
//
//        add(inputPanel, BorderLayout.SOUTH);
//
//        // Button Logic
//        addBtn.addActionListener(e -> {
//            try {
//                String title = titleField.getText();
//                String desc = descField.getText();
//                LocalDate date = LocalDate.parse(deadlineField.getText());
//
//                Task t = new Task(title, desc, date);
//                taskStorage.add(t);
//                taskListModel.addElement(t);
//
//                titleField.setText("");
//                descField.setText("");
//                deadlineField.setText("");
//
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//            }
//        });
//
//        delBtn.addActionListener(e -> {
//            Task selected = taskJList.getSelectedValue();
//            if (selected != null) {
//                taskStorage.remove(selected);
//                taskListModel.removeElement(selected);
//            }
//        });
//
//        markBtn.addActionListener(e -> {
//            Task selected = taskJList.getSelectedValue();
//            if (selected != null) {
//                selected.markCompleted();
//                taskJList.repaint();
//            }
//        });
//    }
//}
//
     //Take 2
    private DefaultListModel<String> taskListModel;

    public ToDoPanel() {
        setLayout(new BorderLayout());

        // Fields
        JTextField titleField = new JTextField(15);
        JTextField descField = new JTextField(15);

        // Date picker
        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd"));

        // Time picker
        JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "HH:mm"));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add New Task"));

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descField);
        inputPanel.add(new JLabel("Deadline Date:"));
        inputPanel.add(dateSpinner);
        inputPanel.add(new JLabel("Deadline Time:"));
        inputPanel.add(timeSpinner);

        JButton addBtn = new JButton("Add Task");
        inputPanel.add(addBtn);

        // Task list
        taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add Task Logic
        addBtn.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String desc = descField.getText();

                Date selectedDate = ((SpinnerDateModel) dateSpinner.getModel()).getDate();
                Date selectedTime = ((SpinnerDateModel) timeSpinner.getModel()).getDate();

                Calendar deadlineCal = Calendar.getInstance();
                deadlineCal.setTime(selectedDate);

                Calendar timeCal = Calendar.getInstance();
                timeCal.setTime(selectedTime);

                // Merge time into date
                deadlineCal.set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY));
                deadlineCal.set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE));

                Date fullDeadline = deadlineCal.getTime();

                // Time left calculation
                long millisLeft = fullDeadline.getTime() - System.currentTimeMillis();
                long hours = TimeUnit.MILLISECONDS.toHours(millisLeft);
                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisLeft) % 60;

                String formatted = title + " — " + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(fullDeadline)
                        + " (" + hours + "h " + minutes + "m left)";
                taskListModel.addElement(formatted);

                titleField.setText("");
                descField.setText("");

                JOptionPane.showMessageDialog(this, "Task added! Deadline in " + hours + "h " + minutes + "m");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
    }
}