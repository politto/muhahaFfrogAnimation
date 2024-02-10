import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Queue;

public class Main extends JPanel implements Runnable {

    double posX = 0;
    double posY = 0;
    double velocityX = 200.0;
    double velocityY = 200.0;
    int [] frame = {1,2,3};
    int n=0;

    private double totalTime;
    public static void main(String[] args) {
        Main m = new Main();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Muhaha_frog_65050101_65050301");
        m.setPreferredSize(new Dimension(600, 600));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        f.setLocationRelativeTo(null);

        Thread[] threadss = new Thread[4];
        for (int i = 0; i < threadss.length; i++) {
            threadss[i] = new Thread(m);
        }
        if (m.getTotalTime() < 2500){
            for (int i = 0; i < threadss.length; i++) {
                threadss[i].start();
            }
        }
        else{
        }

        // 
        // for (int i = 0; i < threadss.length; i++) {
        //     try{
        //         threadss[i].join(3000);
        //     }
        //     catch(InterruptedException e) {}
        // }

    }

    public void paintComponent(Graphics g) {

        
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();
        g2.fillRect(0, 0, 600, 600);
        g2.setColor(Color.black);

        // Graphics2D g2 = (Graphics2D) g;
        // g2.drawRect(265, 265, 200, 200);
        
        // System.out.println("Ho man");
        
        if (totalTime <= 3000) manifestTadpole(g2, buffer);
        else if (totalTime < 4000) manifestFrogf1(g2, buffer);
        else manifestFrogf2(g2, buffer);
       
        g.drawImage(buffer, 0, 0, null);

    }

    public synchronized void run () {
       
        double posX = 0;
        double velocityX = 200.0;
        double lastTime = System.currentTimeMillis();
        double currentTime;
        double elapsedTime;
        double startTime = lastTime;

        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            setTotalTime(getTotalTime() + elapsedTime);
            // System.out.println(totalTime);
            // totalTime = 4100;
            lastTime = currentTime;
            // updateposX(elapsedTime);
            // updateposY(elapsedTime);
            //run1To3();
            //run3To5();
            repaint();
        }
        
    }
    private void updateposX(double elapsedTime) {
        posX += velocityX * elapsedTime / 1000.0;
        if(posX >= 500){
            posX = 500;
            velocityX = -velocityX;
        }else if(posX <= 0){
            posX = 0;
            velocityX = -velocityX;
        }

    }
    private void updateposY(double elapsedTime) {
        posY += velocityY * elapsedTime / 1000.0;
        if(posY >= 500){
            posY = 500;
            velocityY = -velocityY;
        }
        else if(posY <= 0){
            posY = 0;
            velocityY = -velocityY;
        }
    }



    void manifestFrogf1(Graphics2D g2, BufferedImage bf){
        double scaleFactorPlus = totalTime / 6000;
        g2.translate(300,300);
        //g2.scale(1 + scaleFactorPlus, 1 + scaleFactorPlus);
        // g2.scale(0.5,0.5);
        g2.translate(-300,-300);
        paintBg2(bf);
        drawMuhaha(g2);
        paintFrogf1(bf);
        
    }
    void manifestFrogf2(Graphics2D g2, BufferedImage bf){
        double scaleFactorPlus = (totalTime - 5000) / 6000;
        System.out.println(scaleFactorPlus);
        g2.translate(300,300);
        if (1 - scaleFactorPlus > 0.5) g2.scale(1 - scaleFactorPlus, 1 - scaleFactorPlus);
        else g2.scale(0.5,0.5);
        g2.translate(-300,-300);
        g2.translate(-posX,-posY);
        if (totalTime > 6000) g2.rotate(scaleFactorPlus);
        paintBg2(bf);
        drawFrogF2(g2);
        g2.translate(posX, posY); 
        

        // g2.rotate(squareRotate);
        if (totalTime < 6000) paintFrogf2(bf);
        
    }

    void drawTadpoleFrontLegs(Graphics2D g2){
        
        if (totalTime < 2000) return;
        ArrayList<NodeCoordinate> left = new ArrayList<>();
        left.add(new NodeCoordinate(205, 330));
        left.add(new NodeCoordinate(180, 340));
        left.add(new NodeCoordinate(165, 335));
        left.add(new NodeCoordinate(170, 345));
        left.add(new NodeCoordinate(160, 350));
        left.add(new NodeCoordinate(172, 352));
        left.add(new NodeCoordinate(167, 364));
        left.add(new NodeCoordinate(182, 350));
        left.add(new NodeCoordinate(203, 345));
        continuousDraw(g2, left);

        ArrayList<NodeCoordinate> right = new ArrayList<>();
        right.add(new NodeCoordinate(375, 345));
        right.add(new NodeCoordinate(400, 350));
        right.add(new NodeCoordinate(412, 362));
        right.add(new NodeCoordinate(409, 350));
        right.add(new NodeCoordinate(420, 345));
        right.add(new NodeCoordinate(407, 342));
        right.add(new NodeCoordinate(410, 332));
        right.add(new NodeCoordinate(395, 342));
        right.add(new NodeCoordinate(375, 335));
        continuousDraw(g2, right);
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
        bezierCurve(g2, 309,22, 394,3, 478,14, 538,115);

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
        //bezierCurve(g2, 430, 209, 345,90, 196,84, 204,84);
        bezierCurve(g2, 430, 209, 345,90, 196,84, 179,136);
        //bezierCurve(g2, 204,84, 186, 66, 181,118, 179,136);
        bezierCurve(g2, 290, 266, 233,256, 205,223, 185,179);

        //Body
        bezierCurve(g2, 179, 136, 133,198, 125,227, 134,259);
        bezierCurve(g2, 134,259, 133, 298, 204,371, 313,395);
        bezierCurve(g2, 313,395, 399, 404, 558,318, 550,297);
        bezierCurve(g2, 550,297, 549,267, 506, 197, 444,178);

        //Head
        bezierCurve(g2, 486,253, 453, 225, 447,178, 438,163);
        bezierCurve(g2, 438,163, 420,139, 401, 89, 385,60);
        bezierCurve(g2, 385,60, 368,54, 343,58, 336, 37);
        bezierCurve(g2, 336, 37, 315,16, 242,47, 179,136);

        //Eye
        drawCircle(g2, 402, 103, 14);

        //Nose
        bresenhamLine(g2, 330, 46, 331, 57);
        bresenhamLine(g2, 351, 65, 360, 60);

        //RightLeg
        
        bezierCurve(g2, 150, 298, 101,307, 77,331, 52,363);
        bresenhamLine(g2, 52,363, 73, 313);
        bezierCurve(g2, 73, 313, 52,330, 39,343, 29,354);
        bezierCurve(g2, 29,354, 31, 338, 40,320, 43,313);
        bresenhamLine(g2, 43,313, 7, 338);
        bezierCurve(g2, 7, 338, 21, 308, 73,280, 134,259);

        //LeftLeg
        
        bezierCurve(g2, 520,325, 537, 378, 553,403, 596,423);
        bezierCurve(g2, 596,423,595,438, 571,433, 543, 439);
        bezierCurve(g2, 543, 439, 539,476,535,417, 533,569);
        bezierCurve(g2, 533,569, 533, 583, 521,577,487,489);
        bezierCurve(g2,487,489, 461,465, 422, 409, 399,363);
        bezierCurve(g2, 471,368,484,395,500,429, 535,500);
        bresenhamLine(g2, 530,470,523,418);
        bresenhamLine(g2,523,418, 571,433);
        
    }
 

    void paintTadpole(BufferedImage bf){
        if (totalTime > 3000) return;
        double totalTimeCpy = totalTime > 3000? 3000 : totalTime;
        int opacity = (int) (totalTimeCpy > 2500? ((3000 - totalTimeCpy) / 3000) * 255 : 255);
        // int opacity = 255;
        // System.out.println(opacity + " " + totalTime);
        if (opacity < 0) opacity = 0;
        Color tadColor = new Color(0, 40 + ((int)(totalTimeCpy) / 20) , 0, opacity);
        
        if (tadColor.getGreen() > 130) tadColor = new Color(0, 150, 0, opacity);
        aggressiveFloodFill(bf, 320, 300, Color.black, tadColor);
        // vectorTrack(bf.getGraphics(), 295 - (int)(totalTime / 130), 200 - (int)(totalTime / 50), new Color(255, 223, 0));

        aggressiveFloodFill(bf, 220 - (int)(totalTime / 110), 330 + (int)(totalTime / 220), Color.black, new Color(255, 255, 5, opacity));
        aggressiveFloodFill(bf, 350 + (int)(totalTime / 120), 324 + (int)(totalTime / 185), Color.black, new Color(255, 255, 5, opacity));

        aggressiveFloodFill(bf, 220 - (int)(totalTime / 120), 340 + (int)(totalTime / 100), Color.black, new Color(5, 5, 5, opacity));
        aggressiveFloodFill(bf, 350 + (int)(totalTime / 120), 335 + (int)(totalTime / 100), Color.black, new Color(5, 5, 5, opacity));
        aggressiveFloodFill(bf, 295 - (int)(totalTime / 100), 220 - (int)(totalTime / 100), Color.BLACK, new Color(0, 223, 0));
        aggressiveFloodFill(bf, 295 - (int)(totalTime / 130), 200 - (int)(totalTime / 50), Color.BLACK, new Color(180, 223, 226));
        if (totalTime > 1000) {
            aggressiveFloodFill(bf, 205  - (int)(totalTime / 100), 280, Color.black, tadColor);
            aggressiveFloodFill(bf, 380  + (int)(totalTime / 100), 280, Color.black, tadColor);
        }
        if (totalTime > 2000) {
            aggressiveFloodFill(bf, 180 - (int)(totalTime / 100), 350, Color.black, tadColor);
            aggressiveFloodFill(bf, 385 + (int)(totalTime / 100), 353, Color.black, tadColor);
        }
        plot(bf.getGraphics(), 385, 350);
    }
    
    void paintFrogf1(BufferedImage bf){
        aggressiveFloodFill(bf, 300, 300, Color.black, new Color(150, 130, 40));
        aggressiveFloodFill(bf, 450, 40, Color.black, new Color(150, 110, 30));
        aggressiveFloodFill(bf, 450, 450, Color.black, new Color(150, 110, 30));
        aggressiveFloodFill(bf, 350, 550, Color.black, new Color(150, 110, 30));
        aggressiveFloodFill(bf, 120, 500, Color.black, new Color(150, 110, 30));
        aggressiveFloodFill(bf, 40, 350, Color.black, new Color(150, 110, 30));
        aggressiveFloodFill(bf, 120, 315, Color.black, new Color(0, 2, 0));
        aggressiveFloodFill(bf, 290, 335, Color.black, new Color(0, 2, 0));
        // vectorTrack(bf.getGraphics(), 120, 320, getBackground());
    }

    void paintFrogf2(BufferedImage bf){
        aggressiveFloodFill(bf, 300, 300, Color.black, new Color(150, 130, 40));
        aggressiveFloodFill(bf, 80, 310, Color.black, new Color(150, 130, 40));
        aggressiveFloodFill(bf, 520, 400, Color.black, new Color(150, 130, 40));
        aggressiveFloodFill(bf, 300, 250, Color.black, new Color(255, 0, 0));
        // vectorTrack(bf.getGraphics(), 310, 80, getBackground());
    }

    void paintBg(BufferedImage bf) {
        if (totalTime > 3000) return;
        double totalTimeCpy = totalTime > 3000? 3000 : totalTime;
        int opacity = (int) (totalTimeCpy > 2500? ((3000 - totalTimeCpy) / 3000) * 255 : 255);
        // int opacity = 255;
        // System.out.println(opacity + " " + totalTime);
        if (opacity < 0) opacity = 0;
        floodFill(bf, 0, 0, Color.white, new Color(200, 225, 216, opacity));
        Graphics2D g = (Graphics2D) bf.getGraphics(); 
        // g.setColor(new Color(180, 185, 220));
        // RectDrop(g, 100, 100, 500);
        // RectDrop(g, 100, 100, 1500);
        // RectDrop(g, 400, 150, 675);
        // RectDrop(g, 400, 150, 1675);
        // RectDrop(g, 220, 550, 1100);
        // RectDrop(g, 220, 550, 2100);
        // RectDrop(g, 10, 200, 1500);
        // RectDrop(g, 10, 200, 2500);
        // RectDrop(g, 450, 480, 800);
        // RectDrop(g, 450, 480, 1800);

    }

    void paintBg2(BufferedImage bf) {
        floodFill(bf, 599, 599, Color.white, new Color(150, 225, 166));
        Graphics2D g = (Graphics2D) bf.getGraphics(); 
        // g.setColor(new Color(70, 185, 80));
        // RectDrop(g, 100, 100, 500);
        // RectDrop(g, 100, 100, 1500);
        // RectDrop(g, 400, 150, 675);
        // RectDrop(g, 400, 150, 1675);
        // RectDrop(g, 220, 550, 1100);
        // RectDrop(g, 220, 550, 2100);
        // RectDrop(g, 10, 200, 1500);
        // RectDrop(g, 10, 200, 2500);
        // RectDrop(g, 450, 480, 800);
        // RectDrop(g, 450, 480, 1800);
    }

    public synchronized double getTotalTime() {
        return totalTime;
    }

    public synchronized void setTotalTime(double value) {
        totalTime = value;
    }

    void manifestTadpole(Graphics2D g2, BufferedImage bf) {
        double scaleFactorPlus = totalTime / 6000;
        float fadedColorScale = (float)((3000 - totalTime) / 500);
        if (scaleFactorPlus > 0.5) scaleFactorPlus = 0.5;
        if (fadedColorScale < 0) fadedColorScale = 0;
        else if (fadedColorScale > 1) fadedColorScale = 1;
        // float fadedColorScale = 1;
        // double scaleFactorPlus = 0;
        // System.out.println(fadedColorScale);
        g2.translate(300, 300);
        g2.scale(1 + scaleFactorPlus, 1 + scaleFactorPlus);
        g2.translate(-300, -300);
        if (totalTime > 2500){
            int r = g2.getColor().getRed();
            int g = g2.getColor().getGreen();
            int b = g2.getColor().getBlue();
            g2.setColor(new Color(r, g, b, fadedColorScale));
        }
        paintBg(bf);
        drawTadpoleHead(g2);
        drawTadpoleTorso(g2);
        drawTadpoleRearLegs(g2);
        drawTadpoleFrontLegs(g2);
        paintTadpole(bf);
        // 

    }

    void drawTadpoleHead(Graphics2D g2) {
        // bresenhamLine(g2, 0, 0, 600, 600);
        bezierCurve(g2, 250, 280, 170, 320, 200, 400, 280, 400);
        bezierCurve(g2, 280, 400, 400, 400, 400, 290, 320, 280);
        bezierCurve(g2, 220, 360, 310, 380, 310, 380, 360, 360);

        drawCircle(g2, 230, 340, 15);
        drawCircle(g2, 230, 340, 10);
        drawCircle(g2, 350, 338, 15);
        drawCircle(g2, 350, 338, 10);

        // conditionalBezierCurve(g2, 100, 100, 120, 120, 280, 280, 500, 400, bf, Color.black);
    }

    void drawTadpoleTorso(Graphics2D g2) {
        double tailRightSwingScale = (3000 - totalTime) / 3000;
        // double tailRightSwingScale = 1;
        if (tailRightSwingScale < 0) tailRightSwingScale = 0;
        bezierCurve(g2, 240, 300, 240, 240, 260, 210, 280 + (70 * tailRightSwingScale),  200);
        bezierCurve(g2, 330, 300, 310  + (10 * tailRightSwingScale) , 250 , 340 - (20 * tailRightSwingScale), 250, 280 + (70 * tailRightSwingScale), 200);
        bezierCurve(g2, 280, 300, 280 - (20 * tailRightSwingScale), 210, 280 - (20 * tailRightSwingScale), 170, 280 + (100 * tailRightSwingScale), 200);
        bezierCurve(g2, 280, 300, 280, 270, 280 - (10 * tailRightSwingScale), 245, 280 + (70 * tailRightSwingScale), 200);
        bresenhamLine(g2, (int)(280 + (100 * tailRightSwingScale)), 200, (int)(280 + (65 * tailRightSwingScale)), 200);

    }

    void drawTadpoleRearLegs(Graphics g2) {

        if (totalTime < 1000) return;
        ArrayList<NodeCoordinate> leftLeg = new ArrayList<>();
        leftLeg.add(new NodeCoordinate(235, 288));
        leftLeg.add(new NodeCoordinate(210, 280));
        leftLeg.add(new NodeCoordinate(210, 265));
        leftLeg.add(new NodeCoordinate(200, 260));
        leftLeg.add(new NodeCoordinate(185, 245));
        leftLeg.add(new NodeCoordinate(190, 258));
        leftLeg.add(new NodeCoordinate(175, 262));
        leftLeg.add(new NodeCoordinate(190, 268));
        leftLeg.add(new NodeCoordinate(185, 280));
        leftLeg.add(new NodeCoordinate(200, 268));
        leftLeg.add(new NodeCoordinate(200, 290));
        leftLeg.add(new NodeCoordinate(225, 298));

        continuousDraw(g2, leftLeg);

        ArrayList<NodeCoordinate> rightLeg = new ArrayList<>();
        rightLeg.add(new NodeCoordinate(350, 288));
        rightLeg.add(new NodeCoordinate(380, 280));
        rightLeg.add(new NodeCoordinate(380, 265));
        rightLeg.add(new NodeCoordinate(390, 260));
        rightLeg.add(new NodeCoordinate(402, 248));
        rightLeg.add(new NodeCoordinate(400, 260));
        rightLeg.add(new NodeCoordinate(415, 265));
        rightLeg.add(new NodeCoordinate(400, 268));
        rightLeg.add(new NodeCoordinate(405, 282));
        rightLeg.add(new NodeCoordinate(390, 270));
        rightLeg.add(new NodeCoordinate(390, 290));
        rightLeg.add(new NodeCoordinate(360, 297));
        continuousDraw(g2, rightLeg);

    }

    

    void waterDrop(Graphics2D g,int x, int y, int startTime){
        if (totalTime < startTime || totalTime > startTime + 3000) return;
        drawCircle(g, x, y,(int)((totalTime - startTime) / 10));
        
    }

    void RectDrop(Graphics2D g,int x, int y, int startTime){
        while (true)
            if (totalTime % 3000 == 0)
                drawRect(g, x, y, (int)(startTime + totalTime)); 
    }
    void drawRect(Graphics g,int x, int y,int startTime){
        // กำหนดพิกัดของจุดสี่เหลี่ยม
        int[] xPoints = {x, x+ + (int)((totalTime - startTime) / 10), x+ + (int)((totalTime - startTime) / 10), x, x};
        int[] yPoints = {y, y, y+ + (int)((totalTime - startTime) / 10), y+ + (int)((totalTime - startTime) / 10), y};

        // วาดเส้นตรง
        g.drawPolyline(xPoints, yPoints, xPoints.length);
    }

    void run1To3() {

    }

    void run3To5() {
       
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

    void continuousDraw(Graphics g, NodeCoordinate[] input) {
        for (int i = 1; i < input.length; i++) {
            bresenhamLine(g, input[i - 1].getX(), input[i - 1].getY(), input[i].getX(), input[i].getY());
        }
    }

    void myPolygonDraw(Graphics g, ArrayList<NodeCoordinate> input){

        for (int i = 1; i < input.size(); i++) {
            bresenhamLine(g, input.get(i - 1).getX(), input.get(i - 1).getY(), input.get(i).getX(), input.get(i).getY());
        }
        bresenhamLine(g, input.get(input.size() - 1).getX(), input.get(input.size() - 1).getY(), input.get(0).getX(), input.get(0).getY());
    }

    void continuousDraw(Graphics g, ArrayList<NodeCoordinate> input) {
                for (int i = 1; i < input.size(); i++) {
            bresenhamLine(g, input.get(i - 1).getX(), input.get(i - 1).getY(), input.get(i).getX(), input.get(i).getY());
        }
    }

    void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 2, 2);
    }

    void plot(Graphics g, float x, float y) {
        g.fillRect((int) x, (int) y, 2, 2);
    }

    void coloredPlot(Graphics g, int x, int y, Color c) {
        g.setColor(c);
        g.fillRect(x, y, 1, 1);
        g.setColor(Color.BLACK);
    }

    void vectorTrack(Graphics g, int x, int y, Color c) {
        g.setColor(c);
        g.fillRect(x, y, 10, 10);
        g.setColor(Color.BLACK);
    }

    void myPolygonDraw(Graphics g, NodeCoordinate[] input){

        for (int i = 1; i < input.length; i++) {
            bresenhamLine(g, input[i - 1].getX(), input[i - 1].getY(), input[i].getX(), input[i].getY());
        }
        bresenhamLine(g, input[input.length - 1].getX(), input[input.length - 1].getY(), input[0].getX(), input[0].getY());
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

    private boolean checkColor(BufferedImage m, int checkAroundX, int checkAroundY, int prevX, int prevY, Color lineColor){
        return checkAroundX != prevX
        && checkAroundY != prevY
        && m.getRGB(checkAroundX, checkAroundY) != lineColor.getRGB() 
        && m.getRGB(checkAroundX - 1, checkAroundY - 1) != lineColor.getRGB() 
        && m.getRGB(checkAroundX + 1, checkAroundY + 1) != lineColor.getRGB()
        && m.getRGB(checkAroundX - 1, checkAroundY + 1) != lineColor.getRGB()
        && m.getRGB(checkAroundX + 1, checkAroundY - 1) != lineColor.getRGB()
        && m.getRGB(checkAroundX - 1, checkAroundY) != lineColor.getRGB()
        && m.getRGB(checkAroundX + 1, checkAroundY) != lineColor.getRGB()
        && m.getRGB(checkAroundX, checkAroundY + 1) != lineColor.getRGB()
        && m.getRGB(checkAroundX, checkAroundY - 1) != lineColor.getRGB();
    }

    public BufferedImage floodFill (BufferedImage m, int x, int y, Color targetColor, Color replacementColor){
        Queue<NodeCoordinate> q = new LinkedList<>();
        coloredPlot(m.getGraphics(), x, y, replacementColor);
        q.add(new NodeCoordinate(x, y));

        while (!q.isEmpty()) {
            NodeCoordinate cur = q.poll();
            try {
                //Sounth
                if (m.getRGB(cur.getX(), cur.getY() + 1) == targetColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX(), cur.getY() + 1, replacementColor);
                    q.add(new NodeCoordinate(cur.getX(), cur.getY() + 1));
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                
            }
            try {
                //North
                if (m.getRGB(cur.getX(), cur.getY() - 1) == targetColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX(), cur.getY() - 1, replacementColor);
                    q.add(new NodeCoordinate(cur.getX(), cur.getY() - 1));
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                
            }
            try {
                //West
                if (m.getRGB(cur.getX() - 1, cur.getY()) == targetColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX() - 1, cur.getY(), replacementColor);
                    q.add(new NodeCoordinate(cur.getX() - 1, cur.getY()));
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                
            }
            try {
                //East
                if (m.getRGB(cur.getX() + 1, cur.getY()) == targetColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX() + 1, cur.getY(), replacementColor);
                    q.add(new NodeCoordinate(cur.getX() + 1, cur.getY()));
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                
            }

        }

        return m; 
    }

    public BufferedImage aggressiveFloodFill (BufferedImage m, int x, int y, Color stopFill, Color replacementColor){
        Queue<NodeCoordinate> q = new LinkedList<>();
        coloredPlot(m.getGraphics(), x, y, replacementColor);
        q.add(new NodeCoordinate(x, y));
        while (!q.isEmpty()) {
            NodeCoordinate cur = q.poll();
            // System.out.println(q.size() + " " + (m.getRGB(cur.getX(), cur.getY() + 1) != stopFill.getRGB()));
            try {
                //Sounth
                if (m.getRGB(cur.getX(), cur.getY() + 1) != stopFill.getRGB() && m.getRGB(cur.getX(), cur.getY() + 1) != stopFill.getRGB() && m.getRGB(cur.getX(), cur.getY() + 1) != replacementColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX(), cur.getY() + 1, replacementColor);
                    q.add(new NodeCoordinate(cur.getX(), cur.getY() + 1));
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                
            }
            try {
                //North
                if (m.getRGB(cur.getX(), cur.getY() - 1) != stopFill.getRGB() && m.getRGB(cur.getX(), cur.getY() - 1) != stopFill.getRGB() && m.getRGB(cur.getX(), cur.getY() - 1) != replacementColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX(), cur.getY() - 1, replacementColor);
                    q.add(new NodeCoordinate(cur.getX(), cur.getY() - 1));
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                
            }
            try {
                //West
                if (m.getRGB(cur.getX() - 1, cur.getY()) != stopFill.getRGB() && m.getRGB(cur.getX() - 1, cur.getY()) != stopFill.getRGB() && m.getRGB(cur.getX() - 1, cur.getY()) != replacementColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX() - 1, cur.getY(), replacementColor);
                    q.add(new NodeCoordinate(cur.getX() - 1, cur.getY()));
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                
            }
            try {
                //East
                if (m.getRGB(cur.getX() + 1, cur.getY()) != stopFill.getRGB() && m.getRGB(cur.getX() + 1, cur.getY()) != stopFill.getRGB() && m.getRGB(cur.getX() + 1, cur.getY()) != replacementColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX() + 1, cur.getY(), replacementColor);
                    q.add(new NodeCoordinate(cur.getX() + 1, cur.getY()));
                }

            }
            catch (ArrayIndexOutOfBoundsException e) {
                
            }

        }

        return m;
    }



}
