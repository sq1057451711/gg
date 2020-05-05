package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 窗体
 */

public class GamePanel extends JPanel {
    //定义背景文件
    BufferedImage bg;
    //创建鱼群
    ArrayList<Fish> flist = new ArrayList<Fish>();
    //鱼群数量
    int num = 20;
    //窗体
    GameFrame fr;
    //计数器
    int index=0;
    //创建网
    Net net = new Net(this);


    public GamePanel( ) {
        //调用读取文件的工具
        bg = ImageUtil.getImg("/img/bg.jpg");
        //设置背景
        //setBackground(Color.yellow);
        //创建所有的鱼
        for (int i = 0; i < num; i++) {
            flist.add(new Fish(this));
        }
        //开启鼠标监听器
        createMouseListener();
    }

    public void action() {
        new Thread() {
            public void run() {
                while (true) {
                        //让鱼游动
                    for (int i = 0; i < flist.size(); i++) {
                        Fish fish = flist.get(i);
                        //启动鱼线程
                        fish.start();
                    }
//                    try {
//                        sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                        //启动网线程
                        net.start();
                }
            }
        }.start();
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //设置字体
        g.setFont(new Font("楷体", Font.BOLD, 40));
        //画背景图
        g.drawImage(bg, 0, 0, 800, 480, null);
        //画鱼
        for (int i = 0; i < flist.size(); i++) {
            Fish fish = flist.get(i);
            g.drawImage(fish.img,fish.x,fish.y,fish.w,fish.h,null);
        }
        //画网
        g.drawImage(net.img,net.x,net.y,net.w,net.h,null);
    }
    //创建鼠标监听器
    public void createMouseListener(){
        MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                net.x=e.getX()-net.w;
                net.y=e.getY()-net.h;
                System.out.println(e.getX()+" "+e.getY());
                repaint();
            }

        };
    }

}
