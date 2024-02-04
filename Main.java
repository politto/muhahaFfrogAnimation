import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main extends JPanel implements Runnable {

    double totalTime;
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

        (new Thread(m)).start();

    }

    public void paintComponent(Graphics g) {

        
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();
        g2.fillRect(0, 0, 600, 600);
        g2.setColor(Color.black);

        // Graphics2D g2 = (Graphics2D) g;
        // g2.drawRect(265, 265, 200, 200);
        
        // System.out.println("Ho man");
        manifestTadpole(g2, buffer);

        
        g.drawImage(buffer, 0, 0, null);

    }

    public void run () {
        double lastTime = System.currentTimeMillis();
        double currentTime;
        double elapsedTime;
        double startTime = lastTime;

        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            totalTime += elapsedTime;
            lastTime = currentTime;
            run1To3();
            repaint();
        }
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
        drawTadpoleHead(g2);
        drawTadpoleTorso(g2);
        drawTadpoleRearLegs(g2);
        drawTadpoleFrontLegs(g2);
        paintTadpole(bf);

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

    void paintTadpole(BufferedImage bf){
        if (totalTime > 3000) return;
        double totalTimeCpy = totalTime > 3000? 3000 : totalTime;
        int opacity = (int) (totalTimeCpy > 2500? ((3000 - totalTimeCpy) / 3000) * 255 : 255);
        // System.out.println(opacity + " " + totalTime);
        if (opacity < 0) opacity = 0;
        Color tadColor = new Color(0, 40 + ((int)(totalTimeCpy) / 20) , 0, opacity);
        
        if (tadColor.getGreen() > 130) tadColor = new Color(0, 150, 0, opacity);
        aggressiveFloodFill(bf, 320, 300, Color.black, tadColor);
        vectorTrack(bf.getGraphics(), 295 - (int)(totalTime / 120), 200 - (int)(totalTime / 50), new Color(255, 223, 0));
        aggressiveFloodFill(bf, 295 - (int)(totalTime / 100), 220 - (int)(totalTime / 100), Color.BLACK, new Color(0, 223, 0));
        aggressiveFloodFill(bf, 295 - (int)(totalTime / 100), 220 - (int)(totalTime / 100), Color.BLACK, new Color(0, 223, 0));
        if (totalTime > 1000) {
            floodFill(bf, 205  - (int)(totalTime / 100), 280, Color.white, tadColor);
            floodFill(bf, 380  + (int)(totalTime / 100), 280, Color.white, tadColor);
        }
        if (totalTime > 2000) {
            floodFill(bf, 180 - (int)(totalTime / 100), 350, Color.white, tadColor);
            floodFill(bf, 385 + (int)(totalTime / 100), 353, Color.white, tadColor);
        }
        plot(bf.getGraphics(), 385, 350);
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
        g.fillRect(x, y, 1, 1);
    }

    void plot(Graphics g, float x, float y) {
        g.fillRect((int) x, (int) y, 1, 1);
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

    void conditionalBezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, BufferedImage m, Color lineColor){
        int nextPlotX = 0;
        int nextPlotY = 0;
        int prevX = nextPlotX;
        int prevY = nextPlotY;
        float slope = 0;
        for (int i = 0; i < 10000; i++) {
            float t = i / 10000.0f;

            nextPlotX = (int) (
                Math.pow(1 - t, 3) * x1 
                + 3 * t * Math.pow(1 - t, 2) * x2 
                + 3 * t * t * (1 - t) * x3 
                + Math.pow(t, 3) * x4);
            nextPlotY = (int) (
                Math.pow(1 - t, 3) * y1
                 + 3 * t * Math.pow(1 - t, 2) * y2
                 + 3 * t * t * (1 - t) * y3
                 + Math.pow(t, 3) * y4);
            slope = nextPlotY / nextPlotX;
            System.out.println(nextPlotX + " " + nextPlotY + " " + prevX + " " + prevY);
            if (checkColor(m, nextPlotX, nextPlotY, prevX, prevY, lineColor) && prevX != nextPlotX && prevY != nextPlotY) break;
            else {
                plot(g, nextPlotX, nextPlotY);
            }
            prevX = nextPlotX;
            prevY = nextPlotY;
            // coloredPlot(m.getGraphics(), nextPlotX, nextPlotY, Color.black);

        }
        // System.out.println("End");
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
