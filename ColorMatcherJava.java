/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colormatcherjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Math.abs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author John and Cass
 */
public class ColorMatcherJava {

    /**
     * @param args the command line arguments
     */
    private List panels = new LinkedList();
    private List pic = new LinkedList();
    private CustomPanel current;
    private boolean mousePressed;
    
    public static void main(String[] args) {
        
        new ColorMatcherJava();
    }
    
    
    ColorMatcherJava()
    {
        JFrame jFrame = new JFrame("Mouse Hover Demo");
        jFrame.setSize(new Dimension(500,1000));
        int mult;
        //List panels = new LinkedList();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel tester = new JPanel(new GridLayout(5,10));
        //jFrame.setLayout(new GridLayout(5,5));
        for(int i=0;i<50;i++){
            CustomPanel cur = new CustomPanel(i);
            tester.add(cur);
            mult = i/5;
            if((mult%2) == 0){
                cur.setBackground(randomColor());
                //cur.setBackground(Color.red);
                panels.add(cur);
            }
            else{
                cur.setBackground(randomColor());
                //cur.setBackground(Color.red);
                pic.add(cur);
            }
        }
        current = (CustomPanel) panels.get(0);
        JPanel yellow = new JPanel(new GridLayout(1,1));
        yellow.setPreferredSize(new Dimension(1000,250));
        yellow.setBackground(Color.WHITE);

        //frame.getContentPane().add(green, BorderLayout.PAGE_START);
        jFrame.add(tester, BorderLayout.NORTH);
        jFrame.add(yellow, BorderLayout.SOUTH);
        int color = 0;
        
        JButton testBut = new JButton("check colors");
        yellow.add(testBut);
        testBut.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ColorCompare();
            }
        });
        
        //Change RGB to just work off Hue like in paint line
        JButton button1 = new JButton("Hue Up");
        yellow.add(button1);
        button1.addMouseListener(new MouseAdapter() {
            TimerTask task;
            @Override
            public void mousePressed(MouseEvent e) {
                task = new MyTimerTaskHueUp();
                Timer timer = new Timer();
                mousePressed = true;
                timer.scheduleAtFixedRate(task, 0, 150); // Time is in milliseconds
                // The second parameter is delay before the first run
                // The third is how often to run it
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                task.cancel();
                // Will not stop execution of task.run() if it is midway
                // But will guarantee that after this call it runs no more than one more time
            }
        });
        
        JButton button2 = new JButton("Hue Down");
        yellow.add(button2);
        button2.addMouseListener(new MouseAdapter() {
            TimerTask task;
            @Override
            public void mousePressed(MouseEvent e) {
                task = new MyTimerTaskHueDn();
                Timer timer = new Timer();
                mousePressed = true;
                timer.scheduleAtFixedRate(task, 0, 150); // Time is in milliseconds
                // The second parameter is delay before the first run
                // The third is how often to run it
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                task.cancel();
                // Will not stop execution of task.run() if it is midway
                // But will guarantee that after this call it runs no more than one more time
            }
        });
        
        JButton button7 = new JButton("Value Up");
        yellow.add(button7);
        button7.addMouseListener(new MouseAdapter() {
            TimerTask task;
            @Override
            public void mousePressed(MouseEvent e) {
                task = new MyTimerTaskValUp();
                Timer timer = new Timer();
                mousePressed = true;
                timer.scheduleAtFixedRate(task, 0, 150); // Time is in milliseconds
                // The second parameter is delay before the first run
                // The third is how often to run it
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                task.cancel();
                // Will not stop execution of task.run() if it is midway
                // But will guarantee that after this call it runs no more than one more time
            }
        });
        
        JButton button8 = new JButton("Value Down");
        yellow.add(button8);
        button8.addMouseListener(new MouseAdapter() {
            TimerTask task;
            @Override
            public void mousePressed(MouseEvent e) {
                task = new MyTimerTaskValDn();
                Timer timer = new Timer();
                mousePressed = true;
                timer.scheduleAtFixedRate(task, 0, 150); // Time is in milliseconds
                // The second parameter is delay before the first run
                // The third is how often to run it
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                task.cancel();
                // Will not stop execution of task.run() if it is midway
                // But will guarantee that after this call it runs no more than one more time
            }
        });
        
        JButton button9 = new JButton("Saturate Up");
        yellow.add(button9);
        button9.addMouseListener(new MouseAdapter() {
            TimerTask task;
            @Override
            public void mousePressed(MouseEvent e) {
                task = new MyTimerTaskSatUp();
                Timer timer = new Timer();
                mousePressed = true;
                timer.scheduleAtFixedRate(task, 0, 150); // Time is in milliseconds
                // The second parameter is delay before the first run
                // The third is how often to run it
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                task.cancel();
                // Will not stop execution of task.run() if it is midway
                // But will guarantee that after this call it runs no more than one more time
            }
        });
        
        JButton button10 = new JButton("Saturate Down");
        yellow.add(button10);
        button10.addMouseListener(new MouseAdapter() {
            TimerTask task;
            @Override
            public void mousePressed(MouseEvent e) {
                task = new MyTimerTaskSatDn();
                Timer timer = new Timer();
                mousePressed = true;
                timer.scheduleAtFixedRate(task, 0, 150); // Time is in milliseconds
                // The second parameter is delay before the first run
                // The third is how often to run it
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
                task.cancel();
                // Will not stop execution of task.run() if it is midway
                // But will guarantee that after this call it runs no more than one more time
            }
        });
        
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
    
    
    
    class CustomPanel extends JPanel implements MouseListener
    {
        javax.swing.border.Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        javax.swing.border.Border redBorder = BorderFactory.createLineBorder(Color.WHITE,5);
        int num; 
        JLabel label = new JLabel();
        CustomPanel(int number)
        {
            num = number;
            addMouseListener(this);
            setBorder(blackBorder);
            setFocusable(true);
            setLayout(new GridBagLayout());
            add(label);
        }

        @Override
        public Dimension getPreferredSize()
        {
            return new Dimension(100, 100);
        }

        @Override public void mouseClicked(MouseEvent e){
            CustomPanel tempP = (CustomPanel) e.getSource();
            //System.out.println(tempP.getNum());
            int b = tempP.getNum();
            b = b/5;
            if(b%2 == 0)
                changeBorder(tempP.getNum());
        }
        @Override public void mousePressed(MouseEvent e){}
        @Override public void mouseReleased(MouseEvent e){}

        @Override
        public void mouseEntered(MouseEvent e)
        {
            //setBorder(redBorder);
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            //setBorder(blackBorder);
        }
        
        public int getNum(){
            return num;
        }
    }
    
    public void changeBorder(int box){
        for(Iterator<CustomPanel> p = panels.iterator(); p.hasNext(); ) {
            CustomPanel cur = p.next();
            if(cur.getNum() == box){
                javax.swing.border.Border redBorder = BorderFactory.createLineBorder(Color.WHITE,5);
                cur.setBorder(redBorder);
                current = cur;
            }
            else{
                javax.swing.border.Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
                cur.setBorder(blackBorder);
            }
                
        }
    }
    
    public Color randomColor(){
        Color c;
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        float s = rand.nextFloat();
        float v = rand.nextFloat();
        c = new Color(r, g, b);
        /*float[] newHue = new float[3];
        newHue = Color.RGBtoHSB((int)r,(int)g,(int)b,newHue);
        c = Color.getHSBColor(newHue[0], newHue[1], newHue[2]);*/
        return c;
    }
    
    private class MyTimerTaskHueUp extends TimerTask {
        @Override
        public void run() {
            Color screen = current.getBackground();
                Color newC;
                float[] newHue = new float[3];
                int r = screen.getRed();
                int g = screen.getGreen();
                int b = screen.getBlue();
                newHue = Color.RGBtoHSB(r,g,b,newHue);
                float h = newHue[0];
                if(h <= .99){
                    newC = Color.getHSBColor((float)(h+.01), newHue[1], newHue[2]);
                }
                else if(h >.99){
                    newC = Color.getHSBColor((float)(1), newHue[1], newHue[2]);
                }
                else{
                    newC = new Color(r,g,b);
                }
                current.setBackground(newC);
        }
    }
    
    private class MyTimerTaskHueDn extends TimerTask {
        @Override
        public void run() {
            Color screen = current.getBackground();
                Color newC;
                float[] newHue = new float[3];
                int r = screen.getRed();
                int g = screen.getGreen();
                int b = screen.getBlue();
                newHue = Color.RGBtoHSB(r,g,b,newHue);
                float h = newHue[0];
                if(h >= .01){
                    newC = Color.getHSBColor((float)(h-.01), newHue[1], newHue[2]);
                }
                else if(h < .01){
                    newC = Color.getHSBColor((float)(0), newHue[1], newHue[2]);
                }
                else{
                    newC = new Color(r,g,b);
                }
                current.setBackground(newC);
        }
    }
    
    private class MyTimerTaskSatUp extends TimerTask {
        @Override
        public void run() {
            Color screen = current.getBackground();
                Color newC;
                float[] newHue = new float[3];
                int r = screen.getRed();
                int g = screen.getGreen();
                int b = screen.getBlue();
                newHue = Color.RGBtoHSB(r,g,b,newHue);
                float s = newHue[1];
                if(s <= .99){
                    newC = Color.getHSBColor(newHue[0], ((float)(s+.01)), newHue[2]);
                }
                else if(s> .99){
                    newC = Color.getHSBColor(newHue[0], ((float)(1)), newHue[2]);
                }
                else{
                    newC = new Color(r,g,b);
                }
                current.setBackground(newC);
        }
    }
    
    private class MyTimerTaskSatDn extends TimerTask {
        @Override
        public void run() {
            Color screen = current.getBackground();
                Color newC;
                float[] newHue = new float[3];
                int r = screen.getRed();
                int g = screen.getGreen();
                int b = screen.getBlue();
                newHue = Color.RGBtoHSB(r,g,b,newHue);
                float s = newHue[1];
                if(s >= .01){
                    newC = Color.getHSBColor(newHue[0], ((float)(s-.01)), newHue[2]);
                }
                else if(s < .01){
                    newC = Color.getHSBColor(newHue[0], ((float)(0)), newHue[2]);
                }
                else{
                    newC = new Color(r,g,b);
                }
                current.setBackground(newC);
        }
    }
    
    private class MyTimerTaskValUp extends TimerTask {
        @Override
        public void run() {
            Color screen = current.getBackground();
                Color newC;
                float[] newHue = new float[3];
                int r = screen.getRed();
                int g = screen.getGreen();
                int b = screen.getBlue();
                newHue = Color.RGBtoHSB(r,g,b,newHue);
                float v = newHue[2];
                if(v <= .99){
                    newC = Color.getHSBColor(newHue[0],newHue[1],((float)(v+.01)));
                }
                else if(v > .99){
                    newC = Color.getHSBColor(newHue[0],newHue[1],((float)(1)));
                }
                else{
                    newC = new Color(r,g,b);
                }
                current.setBackground(newC);
        }
    }
    
    private class MyTimerTaskValDn extends TimerTask {
        @Override
        public void run() {
            Color screen = current.getBackground();
                Color newC;
                float[] newHue = new float[3];
                int r = screen.getRed();
                int g = screen.getGreen();
                int b = screen.getBlue();
                newHue = Color.RGBtoHSB(r,g,b,newHue);
                float v = newHue[2];
                if(v >= .01){
                    newC = Color.getHSBColor(newHue[0], newHue[1],((float)(v-.01)));
                }
                else if(v <.01){
                    newC = Color.getHSBColor(newHue[0], newHue[1],((float)(0)));
                }
                else{
                    newC = new Color(r,g,b);
                }
                current.setBackground(newC);
        }
    }
    
    private void ColorCompare(){
        int i = 0;
        int counter = 0;
        int correct = 0;
        CustomPanel side1,side2;
        Color screen,pictur;
        int r,g,b,or,og,ob,per;
        float dif, avg;
        String perc;
        
        while(i < 25){
            side1 = (CustomPanel) panels.get(i);
            side2 = (CustomPanel) pic.get(i);
            screen = side1.getBackground();
            pictur = side2.getBackground();
            r = screen.getRed();
            g = screen.getGreen();
            b = screen.getBlue();
            or = pictur.getRed();
            og = pictur.getGreen();
            ob = pictur.getBlue();
            float[] newHue = new float[3];
            float[] picHue = new float[3];
            newHue = Color.RGBtoHSB(r,g,b,newHue);
            picHue = Color.RGBtoHSB(or,og,ob,picHue);
            if(abs(newHue[0]-picHue[0]) < .03 && abs(newHue[1]-picHue[1]) < .05 && abs(newHue[2]-picHue[2]) < .05){
                counter = counter + 1;
                correct = 1;
                System.out.println("Match " + counter);
            }
            if(correct == 0){
                avg = (abs(newHue[0]-picHue[0]) + abs(newHue[1]-picHue[1]) + abs(newHue[2]-picHue[2]))/3;
                dif = 1 - avg;
                per = (int) (100 * dif);
                perc = String.valueOf(per);
                perc = perc + "%";
                //JLabel label = new JLabel(perc);
                side1.label.setText(perc);
                side1.label.setFont(new Font("Serif", Font.PLAIN, 32));
                System.out.println(dif);
            }
            i= i + 1;
            /*if(counter < i){
                i = 26;
                System.out.println("No");
            }*/
            if(counter == 25){
                System.out.println("All match, great job!");
            }
            correct = 0;
            /*System.out.println(r + "=/=" +or);
            System.out.println(g + "=/=" +og);
            System.out.println(b + "=/=" +ob);*/
        }
        //System.out.println(i + " and " + counter);
    }
}
