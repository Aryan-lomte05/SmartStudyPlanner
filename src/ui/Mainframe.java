import java.awt.*;
import javax.swing.*;

package SmartStudyPlanner.ui;

public class Mainframe extends JFrame
{
        setTitle("Padhai Planner");
        setSize(1600,1200);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTabbedPane tp = new JTabbedPane();
        tp.addtab("To do",new ToDoPanel());
        tp.addtab("Calendar",new CalPanel());
        tp.addtab("Scheduler",new SchedulerPanel());
        tp.addtab("Stats",new StatsPanel());
        tp.addtab("Settings",new SettingPanel());

        add(tp,BorderLayout.CENTER);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            Mainframe frame =new Mainframe();
            frame.setVisible(true);
        }


    });
}


