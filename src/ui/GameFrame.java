package ui;

import javax.swing.*;

/**
 *
 */
public class GameFrame extends JFrame {
    public GameFrame(){
        //设置标题
        setTitle("捕鱼达人");
        //设置大小
        setSize(800,480);
        //设置位置居中显示
        setLocationRelativeTo(null);
        //设置不允许玩家改变界面大小
        setResizable(false);
        //关闭窗体的时候退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        GamePanel gamePanel = new GamePanel();
        gameFrame.add(gamePanel);
        //显示窗体
        gameFrame.setVisible(true);
        //开始游戏
        gamePanel.action();



    }
}
