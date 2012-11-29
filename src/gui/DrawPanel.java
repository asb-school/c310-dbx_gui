/*
 * CPTR310 Database Application Programming
 * Andrews University
 * Fall 2012
 * Dr. Roy Villafane
 */
package gui;

import dbx_gui.Global;
import dbx_gui.Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author nobody
 */
public class DrawPanel extends javax.swing.JPanel {

    //private int x = 100;
    private int y = 100;
    private int y_min = 100;
    private int y_max = 300;
    private int y_increment = 2;
    Timer t;
    
    // Debug
    private int num_paint = 0;
    
    /**
     * Creates new form DrawPanel
     */
    public DrawPanel() {
        initComponents();

        int delay = 100; //milliseconds
        ActionListener taskPerformer;
        taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //...Perform a task...
                incrementAction();
            }
        };
        t = new Timer(delay, taskPerformer);
        //t.start();    
    }

    public void incrementAction()
    {        
        y = (y < y_max) ? (y + y_increment) : (y_min);
        //System.out.println(y);
        this.repaint();
    }
    
    public void resetAction()
    {
        y = y_min;
        this.repaint();
    }

    public void startTimer()
    {
        t.start();
    }

    public void stopTimer()
    {
        t.stop();
    }

    @Override
    public void paint(Graphics gp) {
        super.paint(gp);

        Graphics2D g = (Graphics2D)gp;        
        g.drawRect(100, y, 20, 20);
        g.drawOval(150, y, 20, 20);
        g.setColor(Color.yellow);
        g.fillRect(200, y, 20, 20);
        g.fillOval(250, y, 20, 20);
        
        int ty = 100;
      /*  for(jpa.Test t: Global.testColl)
        {
            // do something with each Test object t
            String tname = t.getName();
            g.drawString(tname, 200, ty);
            ty = ty + 50;
        }*/
        
        // Debug: print every time we paint
        //System.out.print("Paint ");
        //System.out.println(num_paint);
        //num_paint++;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(128, 128, 128));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
