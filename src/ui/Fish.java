package ui;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fish extends Thread {
    String name;
    int i = 0;//计数器
    Random rb = new Random();
    BufferedImage img;
    int x;//鱼的横坐标
    int y;//鱼的纵坐标
    int w;//鱼的宽度
    int h;//鱼的高度
    GamePanel panel;
    //定义集合用来存放鱼游动时的所有图片
    List<BufferedImage> animation=new ArrayList<>();

    public  Fish(GamePanel panel){
        this.panel=panel;
        //Random random = new Random();
        //确定鱼显示的图片
        // 确定鱼大小
        int index=rb.nextInt(9)+1;
        //拼接鱼图片名称前缀fish14_catch_04.png
        String fishName = "/img/fish0"+index+"_";
        //加载鱼游动的图片
        for (int i = 0; i < 10; i++) {
            int fi = i+1;
            String prefix = (fi==10?"":"0")+fi;
            //拼接图片地址
            String imgName = fishName+prefix+".png";
            BufferedImage img = ImageUtil.getImg(imgName);
            animation.add(img);
            name=imgName;
        }
        img =  ImageUtil.getImg(name);
        w = img.getWidth();
        h = img.getHeight();
        x = rb.nextInt( 800-w);
        y = rb.nextInt(480-h);
    }

    @Override
    public void run() {
        while (true){
            //鱼一直游动
            move();
            panel.repaint();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //鱼移动方法
    private void move() {
        i++;
        //左移动
        img=animation.get(i%10);
        w=img.getWidth();
        h=img.getHeight();
        x-=3;
        //左移动出界面z
        if (x<=-w){
            getout();

        }
    }

    //鱼重新出现
    private void getout() {
        x=800;
        y=rb.nextInt(480-h);
    }

}
