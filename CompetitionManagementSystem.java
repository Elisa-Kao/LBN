import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CompetitionManagementSystem {
    private JFrame frame;
    private JComboBox<String> competitionDropdown;
    private JSpinner scheduleSpinner;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new CompetitionManagementSystem();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CompetitionManagementSystem() {
        frame = new JFrame("競賽管理系統");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 下拉式選單
        competitionDropdown = new JComboBox<>();
        competitionDropdown.addItem("競賽1");
        competitionDropdown.addItem("競賽2");
        competitionDropdown.addItem("競賽3");

        // 按鈕 - 建立新競賽
        JButton createButton = new JButton("建立新競賽");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newCompetition = JOptionPane.showInputDialog(frame, "請輸入新競賽名稱:");
                if (newCompetition != null && !newCompetition.isEmpty()) {
                    competitionDropdown.addItem(newCompetition);
                }
            }
        });

        // 按鈕 - 移除現有要求
        JButton removeButton = new JButton("移除現有要求");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (competitionDropdown.getItemCount() > 0) {
                    int selectedIndex = competitionDropdown.getSelectedIndex();
                    competitionDropdown.removeItemAt(selectedIndex);
                }
            }
        });

        // 時程選擇（包含日期）
        scheduleSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(scheduleSpinner, "yyyy-MM-dd HH:mm");
        scheduleSpinner.setEditor(dateEditor);
        scheduleSpinner.setValue(new Date());

        // 按鈕 - 送出請求
        JButton submitButton = new JButton("送出請求");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在這裡添加處理送出請求的邏輯
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String selectedCompetition = (String) competitionDropdown.getSelectedItem();
                Date selectedSchedule = (Date) scheduleSpinner.getValue();

                // 處理你的請求邏輯，這裡只是簡單的示例
                String message = "已送出請求:\n競賽: " + selectedCompetition + "\n時程: " + dateFormat.format(selectedSchedule);
                JOptionPane.showMessageDialog(frame, message);
            }
        });

        // 將元件添加到視窗中
        JPanel panel = new JPanel();
        panel.add(new JLabel("選擇競賽:"));
        panel.add(competitionDropdown);
        panel.add(createButton);
        panel.add(removeButton);
        panel.add(new JLabel("選擇時程:"));
        panel.add(scheduleSpinner);
        panel.add(submitButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
