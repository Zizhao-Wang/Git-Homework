package main;

import GUI.Fileabout;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class RunFrame extends JFrame
{
    private Image image = (Image) new ImageIcon("./Image/.jpg").getImage();
    private JPanel contentPane;
    JComboBox comboBox = new JComboBox();
    private DefaultComboBoxModel dcbm;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    RunFrame frame = new RunFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public RunFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 512, 345);
        contentPane = new JPanel();



        contentPane.setBackground(new Color(102, 204, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btnNewButton = new JButton("\u53D1\u9001");
        btnNewButton.setBackground(new Color(102, 102, 255));
        btnNewButton.setFont(new Font("楷体", Font.PLAIN, 30));
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        JTextPane textPane_2 = new JTextPane();

        JLabel lblNewLabel = new JLabel("\u6536\u4EF6\u4EBA\u90AE\u7BB1");
        lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 20));

        JLabel lblNewLabel_2 = new JLabel("\u9009\u62E9\u6587\u4EF6");
        lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 20));

        JButton btnNewButton_1 = new JButton("help");
        btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
        btnNewButton_1.setBackground(UIManager.getColor("Button.highlight"));

        JButton btnNewButton_3 = new JButton("\u8054\u7CFB\u6211\u4EEC");
        btnNewButton_3.setFont(new Font("楷体", Font.PLAIN, 15));




        JButton btnNewButton_2 = new JButton("New button");
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                textPane_2.setText(Fileabout.filechoose());
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 101, Short.MAX_VALUE)
                                                        .addComponent(lblNewLabel_2))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(comboBox, 0, 274, Short.MAX_VALUE)
                                                        .addComponent(textPane_2, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                .addGap(52))
                                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                                                .addComponent(btnNewButton_3)
                                                .addContainerGap())))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(52)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(27)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(textPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNewLabel_2))
                                        .addComponent(btnNewButton_2))
                                .addGap(29)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(26)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton_1)
                                        .addComponent(btnNewButton_3))
                                .addContainerGap(31, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
    void init_combobox() throws IOException {
        String path="D:\\MY1.0\\data\\Register_data.txt";
        java.util.List<String> combox=Fileabout.filereader(path);
        Vector<String> com = new Vector<String>();
        com.addAll(combox);
        dcbm = new DefaultComboBoxModel(com);
        comboBox.setModel(dcbm);
    }
}
