import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class drawFrog extends JPanel {

    public static void main(String[] args) {
        drawFrog m = new drawFrog();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Muhaha_frog_65050101_65050301");
        m.setPreferredSize(new Dimension(600, 600));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        f.setLocationRelativeTo(null);

        //(new Thread(m)).start();
    }
    public void paintComponent(Graphics g) {

        
        BufferedImage buffer = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();
        g2.fillRect(0, 0, 600, 600);
        g2.setColor(Color.black);

        // Graphics2D g2 = (Graphics2D) g;
        // g2.drawRect(265, 265, 200, 200);
        
        // System.out.println("Ho man");
        //manifestTadpole(g2, buffer);

        drawMuhaha(g2);
        //drawFrogF2(g2);
        g.drawImage(buffer, 0, 0, null);
        

    }
    void drawMuhaha(Graphics2D g2){
        bezierCurve(g2, 359, 49, 378, 69, 432, 82, 470, 85);
        bezierCurve(g2, 470,85, 538,95, 563,132, 586,185);
        bezierCurve(g2, 586,185, 586,223, 578,246, 564,268);
        bezierCurve(g2, 564,268, 559,325, 542,360, 502,384);
        bezierCurve(g2, 502,384, 465,382, 460,422, 422,445);
        bezierCurve(g2, 422,445, 373,454, 350,450, 331,452);
        bezierCurve(g2, 331,452, 314,460, 282,475, 253,487);
        bezierCurve(g2, 253,487, 216,493, 196,496, 161,495);
        bezierCurve(g2, 161,495, 103,473, 84,445, 59,393);
        bezierCurve(g2, 59,393, 55,371, 64,344, 47,320);
        bezierCurve(g2, 47,320, 48,292, 42,270, 62,239);
        bezierCurve(g2, 62,239, 70,220, 62,204, 70,170);
        bezierCurve(g2, 70,170, 65,140, 70,118, 87,102);
        bezierCurve(g2, 87,102, 93,74, 201,20, 309,22);
        bezierCurve(g2, 309,22, 332,25, 357,35, 359,49);

        //FrogButt
        bezierCurve(g2, 309,22, 394,3, 478,14, 538,95);

        //FrogNose
        bresenhamLine(g2, 219,351, 215,352);
        bresenhamLine(g2, 215,352, 190,401);
        drawCircle(g2, 167, 424, 5);

        //FrogEyeLeft
        bezierCurve(g2, 251,354, 269,339, 288,332, 300,334);
        bezierCurve(g2, 300,334, 299,355, 294,368, 290,376);
        bezierCurve(g2, 290,376, 280,377, 270,380, 258,378);
        bezierCurve(g2, 258,378, 251,372, 250,362, 251,354);

        //FrogEyeRight
        bezierCurve(g2, 125,289, 132,296, 134,306, 140,315);
        bezierCurve(g2, 140,315, 144,321, 147,331, 143,337);
        bezierCurve(g2, 143,337, 136,336, 125,328, 116,316);
        bezierCurve(g2, 116,316, 111,299, 117,289, 125,289);

        //FrogMouthRight
        bresenhamLine(g2, 64, 257, 76, 266);
        bezierCurve(g2, 76, 266, 82,322, 84,328, 89,360);
        bezierCurve(g2, 89,360, 87, 361, 98,390, 127,442);

        //MidMouth
        bezierCurve(g2, 135,449, 139, 455, 150,459, 161,462);

        //RightMouth
        bezierCurve(g2, 205,467, 245, 455, 281,442, 317,431);
        bresenhamLine(g2, 317,431, 332, 436);

        //LeftBackLeg
        bresenhamLine(g2, 560,299,560,334);
        bezierCurve(g2, 560,334, 543, 376, 506,419, 465,452);
        bezierCurve(g2, 465,452, 445,467, 437, 479, 432,492);
        bresenhamLine(g2, 432,492,431,516);
        bresenhamLine(g2,431,516, 423,497);
        bresenhamLine(g2, 423,497,424,471);
        bresenhamLine(g2,424,471, 382,508);
        bezierCurve(g2, 382,508, 369,490, 371, 465, 373,450);

        //LeftFrontLeg
        bresenhamLine(g2, 356,448,364,503);
        bresenhamLine(g2,364,503, 408,578);
        bresenhamLine(g2, 408,578,401,583);
        bresenhamLine(g2,401,583, 361,535);
        bresenhamLine(g2, 361,535,321,596);
        bresenhamLine(g2,321,596, 311,596);
        bresenhamLine(g2, 311,596,346,541);
        bresenhamLine(g2,346,541, 289,574);
        bresenhamLine(g2, 289,574,275,570);
        bresenhamLine(g2,275,570, 337,529);
        bresenhamLine(g2, 337,529, 337,519);
        bresenhamLine(g2, 337,519, 304,496);
        bresenhamLine(g2, 304,496, 350,506);
        bresenhamLine(g2, 350,506, 337,448);

        //BackRightLeg
        bresenhamLine(g2, 60,398,32,400);
        bresenhamLine(g2,32,400 ,43,359);
        bresenhamLine(g2,43,359,20,322);
        bresenhamLine(g2,20,322,49,310);

        //FrontRightLeg
        bresenhamLine(g2, 106,462,98,481);
        bresenhamLine(g2,98,481, 63,526);
        bresenhamLine(g2, 63,526,102,489);
        bresenhamLine(g2,102,489, 118,549);
        bresenhamLine(g2, 118,549,120,486);
        bresenhamLine(g2,120,486, 168,504);
        bresenhamLine(g2, 168,504,132,480);




    }
    void drawFrogF2(Graphics2D g2){
        bezierCurve(g2, 179, 136, 165,197, 199,248, 251,283);
        bezierCurve(g2, 251, 283, 319,280, 405,254, 430,209);
        bezierCurve(g2, 430, 209, 345,90, 196,84, 179,136);

        bezierCurve(g2, 290, 266, 233,256, 205,223, 185,179);
    }

    void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

    void plot(Graphics g, float x, float y) {
        g.fillRect((int) x, (int) y, 1, 1);
    }

    void coloredPlot(Graphics g, int x, int y, Color c) {
        g.setColor(c);
        g.fillRect(x, y, 10, 10);
        g.setColor(Color.BLACK);
    }
    void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2){
        float dx = Math.abs(x2 - x1);
        float dy = Math.abs(y2 - y1);

        float sx = (x1 < x2)? 1 : -1;
        float sy = (y1 < y2)? 1 : -1;
        boolean isSwap = false;

        if (dy > dx) {
            float tmp = dx;
            dx = dy;
            dy = tmp;
            isSwap = true;
        }

        float D = 2 * dy / dx;

        float x = x1;
        float y = y1;
        //float y = y1;

        for (int i = 0; i < dx; i++) {
            plot(g, x, y);
            // if (i % 4 == 0) System.out.println(x + " " + y + " " + D);
            if (D >= 0) {
                if (isSwap) x += sx;
                else y += sy;

                D -= 2 * dx;
            }

            if (isSwap) y += sy;
            else x += sx;

            D += 2 * dy;

        }

    }

    void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        for (int i = 0; i < 10000; i++) {
            float t = i / 10000.0f;
            // System.out.println( (Math.pow(1 - t, 3) * x1 + 3 * t * Math.pow(1 - t, 2) * x2 + 3 * t * t * (1 - t) * x3 + Math.pow(t, 4) * x4));
            plot(
            g, 
            (int) (
                Math.pow(1 - t, 3) * x1 
                + 3 * t * Math.pow(1 - t, 2) * x2 
                + 3 * t * t * (1 - t) * x3 
                + Math.pow(t, 3) * x4),
            (int) (
                Math.pow(1 - t, 3) * y1
                 + 3 * t * Math.pow(1 - t, 2) * y2
                 + 3 * t * t * (1 - t) * y3
                 + Math.pow(t, 3) * y4));
        }
    }

    void bezierCurve(Graphics g, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        for (int i = 0; i < 10000; i++) {
            float t = i / 10000.0f;
            // System.out.println( (Math.pow(1 - t, 3) * x1 + 3 * t * Math.pow(1 - t, 2) * x2 + 3 * t * t * (1 - t) * x3 + Math.pow(t, 4) * x4));
            plot(
            g, 
            (int) (
                Math.pow(1 - t, 3) * x1 
                + 3 * t * Math.pow(1 - t, 2) * x2 
                + 3 * t * t * (1 - t) * x3 
                + Math.pow(t, 3) * x4),
            (int) (
                Math.pow(1 - t, 3) * y1
                 + 3 * t * Math.pow(1 - t, 2) * y2
                 + 3 * t * t * (1 - t) * y3
                 + Math.pow(t, 3) * y4));
        }
    }
    void drawCircle(Graphics g, int cenx, int ceny, int rad){
        
        int x = 0;
        int y = rad;
        int Dx = 2 * x;
        int Dy = 2 * y;
        int D = 1 - rad;
        while (x <= y) {
            plot(g, cenx + x, ceny + y);
            plot(g, cenx - x, ceny - y);
            plot(g, cenx - x, ceny + y);
            plot(g, cenx + x, ceny - y);
            
            plot(g, cenx + y, ceny + x);
            plot(g, cenx - y, ceny - x);
            plot(g, cenx - y, ceny + x);
            plot(g, cenx + y, ceny - x);
            x++;
            Dx += 2;
            D += Dx + 1;
            if (D >= 0) {
                y -= 1;
                Dy -= 2;
                D -= Dy;
            }

        }
        
        
    }

    
   
}
