/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author x
 */
public class Viewer extends Canvas implements Runnable {

    public Viewer() {
        this.setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                System.out.println(c);
            }
        });
    }

    private boolean runner = false;

    //sky color config
    int sky_r = 0;
    int sky_g = 60;
    int sky_b = 100;
    byte daytime = 0;

    boolean sunup = true, sundonw = false;

    //monnn light
    int mr = 255, mg = 255, mb = 0;

    //c1 clould config
    boolean c1_right = true, c1_left = false, c2_right = false, c2_left = true;
    byte c1x = 0;
    byte c2x = (byte) 125;

    //car movemnt
    byte driver_x = (byte) 0;
    int lr = 255, lg = 255, lb = 0;

    //config the sun
    int sr = 255, sg = 55, sb = 0;
    int snx = 0, sny = 0;

    protected void paint(Graphics g) {
        g.setColor(0xFFFFFF);
        g.fillRect(0, 0, getWidth(), getHeight());

        //creating sky
        g.setColor(sky_r, sky_g, sky_b);
        g.fillRect(0, 0, getWidth(), 180);

        //creating moon
        g.setColor(mr, mg, mb);
        g.fillArc(10, 20, 55, 75, 90, 180);
        g.setColor(sky_r, sky_g, sky_b);
        g.fillArc(20, 20, 45, 75, 90, 180);

        //creating sun
        g.setColor(sr, sg, sb);
        g.fillArc(snx + 60, sny + 150, 60, 60, 0, 360);

        //creating clouds
        g.setColor(0xFFFFFF);
        g.fillArc(c1x + 15, 15, 25, 25, 0, 360);
        g.fillArc(c1x + 45, 20, 25, 25, 0, 360);
        g.fillArc(c1x + 30, 25, 25, 25, 0, 360);
        g.fillArc(c1x + 30, 10, 25, 25, 0, 360);

        g.fillArc(c2x + 35, 65, 25, 25, 0, 360);
        g.fillArc(c2x + 65, 70, 25, 25, 0, 360);
        g.fillArc(c2x + 50, 75, 25, 25, 0, 360);
        g.fillArc(c2x + 50, 60, 25, 25, 0, 360);

        //creating road
        g.setColor(0x5C3D1F);
        g.fillRect(0, 180, getWidth(), 20);

        //create bagground wall
        g.setColor(0, 64, 0);
        g.fillTriangle(0, 120, 130, 170, 0, 180);
        g.fillTriangle(10, 180, 150, 120, 150, 180);
        g.fillTriangle(150, 120, 150, 180, getWidth(), 180);

        //create a tree
        g.setColor(102, 58, 30);
        g.fillRect(195, 110, 10, 70);
        g.setColor(16, 205, 1);
        g.fillArc(165, 90, 40, 40, 0, 360);
        g.fillArc(180, 70, 40, 40, 0, 360);
        g.fillArc(195, 90, 40, 40, 0, 360);

        //building house
        //draw the car
        g.setColor(0xFFCC00);
        g.fillRect(driver_x + 200, 140, 30, 15);
        g.setColor(0x009999);
        g.fillRect(driver_x + 180, 155, 60, 20);
        g.setColor(0x0);
        g.fillArc(driver_x + 190, 165, 15, 15, 0, 360);
        g.fillArc(driver_x + 220, 165, 15, 15, 0, 360);

        //fill road
        g.setColor(0x0);
        g.fillArc(10, 185, 5, 5, 0, 180);
        g.fillArc(50, 190, 5, 5, 0, 180);
        g.fillArc(100, 195, 5, 5, 0, 180);
        g.fillArc(130, 188, 5, 5, 0, 180);
        g.fillArc(160, 190, 5, 5, 0, 180);

        g.fillArc(80, 185, 5, 5, 0, 180);
        g.fillArc(210, 195, 5, 5, 0, 180);

        //car lihgt
        g.setColor(lr, lg, lb);
        g.fillTriangle(driver_x + 180, 160, driver_x + 140, 150, driver_x + 140, 165);

        //create grass
        g.setColor(0x009900);
        g.fillRect(0, 200, getWidth(), getHeight() - 200);
        g.setColor(0, 0, 128);
        g.fillArc(180, 210, 200, 100, 90, 180);

        g.setColor(0, 40, 0);
        g.fillTriangle(50, 220, 10, 300, 260, 310);

        //grwing plants
        g.setColor(237, 28, 36);
        g.fillArc(13, 116, 20, 20, 0, 180);
        g.fillArc(43, 116, 20, 20, 0, 180);
        g.setColor(0x009900);
        g.fillRect(20, 126, 6, 20);
        g.fillRect(50, 126, 6, 20);

        g.setColor(0, 40, 0);
        g.fillTriangle(getWidth() - 90, getHeight() - 80, getWidth() - 30, getHeight() - 80, getWidth() - 65, getHeight() - 30);
        g.setColor(0x009900);
        g.fillTriangle(getWidth() - 80, getHeight() - 80, getWidth() - 40, getHeight() - 80, getWidth() - 63, getHeight() - 40);
        g.setColor(237, 28, 36);
        g.fillArc(168, 200, 20, 20, 0, 180);
        g.setColor(0, 40, 0);
        g.fillRect(175, 210, 6, 50);

        //creating fenz
        for (int i = 0; i < 5; i++) {
            g.setColor(0x7A5229);
            g.fillRect(i * 30 + 30, 230, 5, 65);
            g.setColor(0xFFFFFF);
            g.drawLine(i * 30 + 30, 230, i * 30 + 30, 295);
        }
        g.setColor(0x7A5229);
        g.fillRect(10, 250, 160, 5);
        g.fillRect(10, 270, 160, 5);

        g.setColor(0xFFFFFF);
        g.drawLine(10, 255, 170, 255);
        g.drawLine(10, 275, 170, 275);

    }

    public void run() {
        while (runner) {
            try {
                // move sun to up
                snx++;
                sny--;
                if (snx == 400) {
                    snx = 0;
                    sny = 0;
                    sunup = true;
                    sundonw = false;
                }
                if (snx == 180) {
                    sunup = false;
                    sundonw = true;

                }

                //changin background color
                if (sunup) {
                    if (sky_b < 255) {
                        sky_b++;
                    }
                }
                if (sundonw) {
                    if (sky_b > 100) {
                        sky_b--;
                    }

                }
                if (snx > 70 && snx < 250) {
                    mr = sky_r;
                    mg = sky_g;
                    mb = sky_b;
                }
                if (snx > 250) {
                    mr = 255;
                    mg = 255;
                    mb = 0;
                }
                if (snx > 50 && snx < 230) {
                    lr = 0;
                    lg = 64;
                    lb = 0;
                }
                if (snx > 230) {
                    lr = 255;
                    lg = 255;
                    lb = 0;
                }

                if (c1_right) {
                    c1x++;
                    if (c1x == 125) {
                        c1_right = false;
                        c1_left = true;
                    }
                }
                if (c1_left) {
                    c1x--;
                    if (c1x == 10) {
                        c1_right = true;
                        c1_left = false;
                    }
                }

                if (c2_left) {
                    c2x--;
                    if (c2x == 10) {
                        c2_left = false;
                        c2_right = true;
                    }
                }
                if (c2_right) {
                    c2x++;
                    if (c2x == 125) {
                        c2_left = true;
                        c2_right = false;
                    }
                }

                //moving the sun
                repaint();

                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void start() {
        Thread t = new Thread(this);
        t.start();
        runner = true;
    }

    public void stop() {
        runner = false;
    }

    protected void keyPressed(int keyCode) {
        if (keyCode == -3) {
            driver_x--;
            

        }

        if (keyCode == -4) {
            driver_x++;
            if (driver_x > 0) {
                driver_x = 0;
            }
        }
    }

}
