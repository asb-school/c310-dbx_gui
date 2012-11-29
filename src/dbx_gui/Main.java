/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbx_gui;

import gui.MenuDialog;
import gui.PlayerForm;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author roy
 */
public class Main {

    public static final int MenuPlayer = 1;
    public static final int MenuRegion = 2;

    private static int menuChoice = 0;
    
    //public static List<jpa.Test> test_list = null;
    
    public static void setMenuChoice(int i)
    {
        menuChoice = i;
    }
    
    public static int getMenuChoice()
    {
        return menuChoice;
    }
    
   /* public static void testDbOp()
    {
        javax.persistence.EntityManager entityManager;
        javax.persistence.Query query;
        //java.util.List<jpa.Test> list;
        //org.jdesktop.beansbinding.BindingGroup bindingGroup;

        int min_val_x = 10;

        entityManager = javax.persistence.Persistence.createEntityManagerFactory("dbx_guiPU").createEntityManager();
        query = entityManager.createQuery("SELECT t FROM Test t WHERE t.val >= :min_val ");
        query.setParameter("min_val", min_val_x);
        //list = org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        Global.testColl = query.getResultList();

        for(jpa.Test t: Global.testColl)
        {
            System.out.println("Test item: id: " + t.getId() + " name: " +
                               t.getName() + " val: " + t.getVal());
        }
        //System.out.println("");
    }*/
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // testDbOp();
        //gui.MsgBox.msg("Hello");
        //gui.MenuDialog.main(args);
        
       /* JFrame frame = new JFrame();
        frame.setContentPane(new PlayerForm());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        */
        
        // Initialize the window handler
        WindowHandler.init();
        
        // Show the menu dialog
        WindowHandler.showMenuDialog();
        
        
        //gui.PlayerForm.main(args);
        //gui.RegionForm.main(args);
        //gui.TestForm.main(args);
        //gui.WorldDisplayFrame.main(args);
        //gui.MsgBox.msg("Continue");
        
        /*
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            gui.PlayerForm pf1 = new gui.PlayerForm();
            JFrame fr1 = new JFrame();
            fr1.setContentPane(pf1);
            fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr1.pack();
            fr1.setVisible(true);
            }
        });

        EventQueue.invokeLater(new Runnable() {
            public void run() {
            gui.PlayerForm pf1 = new gui.PlayerForm();
            JFrame fr1 = new JFrame();
            fr1.setContentPane(pf1);
            fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr1.pack();
            fr1.setVisible(true);
            }
        });

        EventQueue.invokeLater(new Runnable() {
            public void run() {
            gui.PlayerForm pf1 = new gui.PlayerForm();
            JFrame fr1 = new JFrame();
            fr1.setContentPane(pf1);
            fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fr1.pack();
            fr1.setVisible(true);
            }
        });
        */
        
    }
}
