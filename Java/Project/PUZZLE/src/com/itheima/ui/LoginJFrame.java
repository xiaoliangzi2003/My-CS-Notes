package com.itheima.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    public LoginJFrame(){
        this.setSize(488,430);//设置窗口大小
        this.setTitle("Login");//设置窗口标题
        this.setAlwaysOnTop(true);//设置窗口置顶
        this.setLocationRelativeTo(null);//设置界面位置居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置默认关闭方式
        this.setVisible(true);//让窗口可见
    }
}
