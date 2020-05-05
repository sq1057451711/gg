package ui;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Net extends  Thread{
    int index;//计数器
    GamePanel panel;
    Random rb = new Random();
    BufferedImage img;
    int x;//鱼网的横坐标
    int y;//鱼网的纵坐标
    int w;//鱼网的宽度
    int h;//鱼网的高度
    //定义集合用来存放鱼网出现时的所有图片
    List<BufferedImage> animation=new ArrayList<>();

    public Net(GamePanel panel){
        this.panel=panel;
        for (int i = 1; i <8 ; i++) {
            String name="/img/net_"+i+".png";
            BufferedImage img = ImageUtil.getImg(name);
            animation.add(img);
        }
        img =  animation.get(0);
        w = img.getWidth();
        h = img.getHeight();
        x=0;
        y=0;
    }

    @Override
    public void run() {
        while (true){
            //鱼网一直游动
            move();
            panel.repaint();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //渔网工作
    private void move() {
        index++;
        img=animation.get(index%7);
        w=img.getWidth();
        h=img.getHeight();
        x++;
    }
}
