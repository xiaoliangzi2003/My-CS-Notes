package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.util.Random;

//规定GameJFrame为游戏主界面
//ctrl+Alt+M 将选中的块抽取出来，作为一个单独的函数

public class GameJFrame extends JFrame implements ActionListener, MouseListener, KeyListener {
    int[] tempArr = new int[16];
    JButton buttonLogin = new JButton("登录按钮");
    JButton buttonRegister = new JButton("注册按钮");

    public GameJFrame() {
        InitJFrame();//初始化界面
        JMenuBar jMenuBar = initJMenuBar();//初始化菜单
        initData();//初始化数据
        initButton();
        this.addMouseListener(this);
        initImage();//初始化图片
        this.setJMenuBar(jMenuBar);//给整个界面设置菜单
        this.setVisible(true);//让窗口可见


        //给按钮绑定鼠标事件

    }

    private void initButton() {
        buttonLogin.setBounds(0, 0, 100, 50);
        buttonRegister.setBounds(100, 0, 100, 50);
        buttonLogin.addActionListener(this);
        buttonRegister.addActionListener(this);
        buttonLogin.addMouseListener(this);
        buttonRegister.addKeyListener(this);//调用者this：本类对象（整个界面）,参数this：事件触发时，实现本类中对应的实现代码
        this.getContentPane().add(buttonLogin);
        this.getContentPane().add(buttonRegister);
    }


    private void initData() {
        Random r = new Random();//创建随机对象
        for (int i = 0; i < 16; i++) {
            tempArr[i] = i;//初始化
        }
        for (int i = 1; i <= tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);//获取随机索引
            //交换第i个索引对应的内容和随机索引对应的内容
            int temp = tempArr[i-1];
            tempArr[i-1] = tempArr[index];
            tempArr[index] = temp;
        }

    }

    private void initImage() {

        //先加载的图片在顶层，后加载的图片在底层
        for (int i = 1; i <=15; i++) {
            JLabel jLabel = new JLabel(new ImageIcon("E:\\Code\\Java\\PUZZLE\\image\\animal\\animal3\\" + tempArr[i] + ".jpg"));//创建一个图片对象，并放入到创建的一个JLabel容器对象（管理图片）
            jLabel.setBounds(105 * ((i-1) % 4)+83, 105 * ((i-1) / 4)+134, 105, 105);//指定图片位置
            //给图片添加边框
            jLabel.setBorder(new BevelBorder(0));//斜面边框的方向

            this.getContentPane().add(jLabel);//获取主界面隐藏容器，将管理容器添加到隐藏容器
        }
        ImageIcon bg=new ImageIcon("E:\\Code\\Java\\PUZZLE\\image\\background.png");
        //加载背景图片
        JLabel background=new JLabel(bg);
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);

    }

    private static JMenuBar initJMenuBar() {
        //创建菜单栏
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单下的两个条目对象
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //创建条目对象下的选项
        JMenuItem replayItem = new JMenuItem("重新开始");
        JMenuItem reloginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");
        JMenuItem accountItem = new JMenuItem("公众号");

        //添加条目栏到菜单栏
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //选项栏添加到指定的条目栏
        aboutJMenu.add(accountItem);
        functionJMenu.add(replayItem);
        functionJMenu.add(reloginItem);
        functionJMenu.add(closeItem);
        return jMenuBar;
    }

    private void InitJFrame() {
        this.setSize(603, 680);//设置窗口大小
        this.setTitle("Puzzle Game beta1.0");//设置窗口标题
        this.setAlwaysOnTop(true);//设置窗口置顶
        this.setLocationRelativeTo(null);//设置界面位置居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置默认关闭方式
        this.setLayout(null);//取消居中放置锁定,只有取消了才能
        //把所有按钮添加到主界面中
        this.getContentPane().add(buttonLogin);
        this.getContentPane().add(buttonRegister);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object e=actionEvent.getSource();
        if(e==buttonLogin){
            buttonLogin.setSize(200,200);
        }else if(e==buttonRegister){
            Random r=new Random();
            buttonRegister.setLocation(r.nextInt(500),r.nextInt(500));
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.println("按住");
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        System.out.println("滑入");
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        System.out.println("滑出");
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println("敲击键盘");
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println("按下键盘不松");
        int code=keyEvent.getKeyCode();
        System.out.println((char)code);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        System.out.println("释放键盘");
    }
}