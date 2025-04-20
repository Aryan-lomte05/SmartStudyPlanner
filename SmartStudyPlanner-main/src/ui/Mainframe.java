package ui;

import java.awt.*;
import javax.swing.*;

public class Mainframe extends JFrame {

    public Mainframe() {
        setTitle("Padhai Planner");
        setSize(1600, 1200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tp = new JTabbedPane();
        tp.addTab("To do", new ToDoPanel());
        tp.addTab("Calendar", new CalendarPanel());
        tp.addTab("Scheduler", new SchedulerPanel());
        tp.addTab("Stats", new StatsPanel());
        tp.addTab("Settings", new SettingsPanel());

        add(tp, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Mainframe frame = new Mainframe();
            frame.setVisible(true);
        });
    }
}
