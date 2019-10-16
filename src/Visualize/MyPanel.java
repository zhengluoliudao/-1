package Visualize;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Main.Calculate;
import javax.swing.*;

public class MyPanel extends JFrame{

    // 定义组件
    JPanel jp1, jp2, jp3, jp4, imagePanel;
    JLabel jlb1, jlb2, jlb3, jlb4, ansLabel, imageLabel;
    JButton jb1, jb2;
    JTextField jtf1, jtf2, jtf3, jtf4;

    // 构造函数
    public MyPanel() {

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        imagePanel = new JPanel();

        jlb1 = new JLabel("数1");
        jlb2 = new JLabel("运算符");
        jlb3 = new JLabel("数2");
        jlb4 = new JLabel("你的计算结果：");
        imageLabel = new JLabel();
        ansLabel = new JLabel("");

        jb1 = new JButton("计算");
        jb2 = new JButton("取消");

        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);
        jtf4 = new JTextField(10);

        ImageIcon img = new ImageIcon("src/images/logo.jpg");// 创建图片对象
        imageLabel.setIcon(img);

        // 设置布局管理
        this.setLayout(new GridLayout(5,1));

        // 加入各个组件
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp1.add(jlb2);
        jp1.add(jtf2);

        jp1.add(jlb3);
        jp1.add(jtf3);

        jp2.add(jlb4);
        jp2.add(jtf4);

        jp3.add(jb1);
        jp3.add(jb2);

        jp4.add(ansLabel);

        imagePanel.add(imageLabel,BorderLayout.CENTER);

        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.valueOf(jtf1.getText());
                String op = jtf2.getText();
                int num2 = Integer.valueOf(jtf3.getText());
                int ans = Calculate.calculate(num1, num2, op);
                int yourAns = Integer.valueOf(jtf4.getText());
                String ansText="";
                if(ans == yourAns){
                    ansText = "正确结果为："+ ans +"计算正确!";
                }else{
                    ansText = "正确结果为："+ ans + "   " + "计算错误!";
                }
                ansLabel.setText(ansText);
            }
        });

        // 加入到JFrame
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        //this.add(imagePanel);

        this.setSize(800, 800);
        this.setTitle("计算器");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);// JFrame最大化
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 让JFrame的关闭按钮起作用
        this.pack();
    }
}
