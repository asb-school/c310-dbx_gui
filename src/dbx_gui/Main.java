/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbx_gui;

import gui.MenuDialog;
import gui.PlayerForm;
import java.awt.EventQueue;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.persistence.EntityManager;
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
     * Hash a string using MD5
     * @s String to hash
     * @return MD5 hash of input string
     */
    public String hashMD5(String s) throws Exception
    {
        String plainPassword = s;
        String hashedPassword;
        byte[] digest;

        MessageDigest md = MessageDigest.getInstance("MD5");
        digest = md.digest(plainPassword.getBytes());
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < digest.length; ++i)
        {
          sb.append(Integer.toHexString((digest[i] & 0xFF) | 0x100).substring(1,3));
        }
        hashedPassword = sb.toString();
        return hashedPassword;
    }  
    
    /**
     * Verify if the credentials provided by the user match what is available
     * in the authentication store.
     *
     * @param username User name
     * @param password User password
     * @return True if the user name and password are valid, false otherwise.
     */
    public void authenticateUser(String username, String password) throws Exception
    {
        // Hash password
        String encryptedPassword = hashMD5(password);
        
        gui.entityManager.getTransaction();
        
        em.getTransaction().begin();

  Query q = em.createQuery("select c from Customer c where c.surname='Claus'");

  Iterator iter = q.getResultIterator();
  while(iter.hasNext())
  {
    Customer c = (Customer)iter.next();
    System.out.println("Found a claus with id " + c.id);
  }

  em.getTransaction().commit();
        
        
        
        
        
        
        
        
        //gui.entityManager.getTransaction().begin();
        
        
        String sqlStr; // SQL query text
        PreparedStatement pstmt; // SQL statement object
        ResultSet rs; // Results returned from the query

        // SQL query
        sqlStr = "SELECT users.password, player.id, users.admin FROM users, player WHERE player.id = users.player_id AND users.username = ?";

        // Create the SQL statement object and prepare the statement
        pstmt = conn.prepareStatement(sqlStr);

        // Set the parameter values, with the index corresponding to
        // the appropriate question mark sequence in the query string.
        pstmt.setString(1, username);

        // Execute the query
        rs = pstmt.executeQuery();

        // Access the result (should only be 1 row in this case)
        if(!rs.next())
        {
            throw new Exception("ERROR: DBX.authenticateUser: cannot access user");
        }

        // Get the password from the first column (matching the SQL statement)
        String p = rs.getString(1);
        int player_id = rs.getInt(2);
        int admin = rs.getInt(3);

        // Access the result (should only be 1 row in this case)
        if(rs.next())
        {
            throw new Exception("ERROR: DBX.authenticateUser: user is not unique");
        }

        if(encryptedPassword.equals(p))
        {
            // Player is authenticated
            Global.is_player_authn = true;
          
            // Set globals
            Global.authn_player_id = player_id;
            
            // Check if admin
            if (admin == 1)
            {
                Global.is_admin_authn = true;
            }
        }

        rs.close();
        pstmt.close();
        conn.commit();
    }
   
    
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
