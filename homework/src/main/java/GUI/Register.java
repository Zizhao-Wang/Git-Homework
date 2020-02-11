package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
 class Register extends JFrame {
    //创建一个容器
    Container ct;
    //创建背景面板。
    BackgroundPanel bgp;
    public static void main(String[] args)
    {
        new Register();
    }
    public Register()
    {
        //不采用任何布局方式。
        ct=this.getContentPane();
        bgp=new BackgroundPanel((new ImageIcon("homework/src/main/resources/Register.jpg")).getImage());
        bgp.setBounds(0,0,306,523);
        ct.add(bgp);

        JTextPane textPane = new JTextPane();

        JTextPane textPane_1 = new JTextPane();

        JTextPane textPane_3 = new JTextPane();

        JButton btnNewButton = new JButton("\u672C\u5730\u6CE8\u518C");
        btnNewButton.setEnabled(false);
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(0, 255, 255));
        GroupLayout gl_bgp = new GroupLayout(bgp);
        gl_bgp.setHorizontalGroup(
                gl_bgp.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_bgp.createSequentialGroup()
                                .addGroup(gl_bgp.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_bgp.createSequentialGroup()
                                                .addGap(86)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_bgp.createSequentialGroup()
                                                .addGap(41)
                                                .addGroup(gl_bgp.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(textPane, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_bgp.createSequentialGroup()
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(46, Short.MAX_VALUE))
        );
        gl_bgp.setVerticalGroup(
                gl_bgp.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_bgp.createSequentialGroup()
                                .addGap(172)
                                .addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(36)
                                .addGroup(gl_bgp.createParallelGroup(Alignment.LEADING)
                                        .addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                .addGap(56))
        );
        bgp.setLayout(gl_bgp);

        //创建按钮
        this.setSize(306,523);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
class BackgroundPanel extends JPanel
{
    Image im;
    public BackgroundPanel(Image im)
    {
        this.im=im;
        this.setOpaque(true);
    }
    //Draw the back ground.
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);

    }
}
}
