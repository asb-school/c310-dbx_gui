package dbx_gui;

import gui.MenuDialog;
import gui.PlayerForm;
import javax.swing.JFrame;


public class WindowHandler 
{
    public static JFrame playerFrame;
    public static JFrame regionFrame;
    public static JFrame loginFrame;
    public static JFrame npcFrame;
    public static JFrame npcTypeFrame;
    public static MenuDialog menuDialog;
    
    private WindowHandler()
    {
        //nothing to do here
    }
    
    public static void init()
    {
        // Create windows
        createLoginFrame();
        createPlayerFrame();
        createMenuDialog();
        createRegionFrame();
        createNpcFrame();
        createNpcTypeFrame();
    }
    
    private static void createLoginFrame()
    {
        loginFrame = new JFrame();
        loginFrame.setContentPane(new dbx_gui.LoginForm());
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.pack();
    }
    
    private static void createPlayerFrame()
    {
        playerFrame = new JFrame();
        playerFrame.setContentPane(new gui.PlayerForm());
        playerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerFrame.pack();
    }

    private static void createNpcFrame()
    {
        npcFrame = new JFrame();
        npcFrame.setContentPane(new gui.NpcForm());
        npcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        npcFrame.pack();
    }

    private static void createNpcTypeFrame()
    {
        npcTypeFrame = new JFrame();
        npcTypeFrame.setContentPane(new gui.NpcTypeForm());
        npcTypeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        npcTypeFrame.pack();
    }
    
    private static void createMenuDialog()
    {
         menuDialog = new MenuDialog(new javax.swing.JFrame(), true);
         menuDialog.addWindowListener(new java.awt.event.WindowAdapter() 
         {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) 
            {
                System.exit(0);
            }
         });
    }
    
    private static void createRegionFrame()
    {
        regionFrame = new JFrame();
        regionFrame.setContentPane(new gui.RegionForm());
        regionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regionFrame.pack();
    }

    public static void showLoginFrame()
    {
        menuDialog.setVisible(false);
        regionFrame.setVisible(false);
        playerFrame.setVisible(false);
        npcFrame.setVisible(false);
        npcTypeFrame.setVisible(false);
        loginFrame.setVisible(true);
    }
    
    public static void showMenuDialog()
    {
        loginFrame.setVisible(false);
        npcFrame.setVisible(false);
        npcTypeFrame.setVisible(false);
        playerFrame.setVisible(false);
        regionFrame.setVisible(false);
        menuDialog.setVisible(true);
    }
    
    public static void showPlayerFrame()
    {
        menuDialog.setVisible(false);
        regionFrame.setVisible(false);
        npcFrame.setVisible(false);
        npcTypeFrame.setVisible(false);
        playerFrame.setVisible(true);
    }
    
    public static void showRegionFrame()
    {
        menuDialog.setVisible(false);
        playerFrame.setVisible(false);
        npcFrame.setVisible(false);
        npcTypeFrame.setVisible(false);
        regionFrame.setVisible(true);
    }

    public static void showNpcFrame()
    {
        menuDialog.setVisible(false);
        playerFrame.setVisible(false);
        regionFrame.setVisible(false);
        npcTypeFrame.setVisible(false);
        npcFrame.setVisible(true);
    }

    public static void showNpcTypeFrame()
    {
        menuDialog.setVisible(false);
        playerFrame.setVisible(false);
        regionFrame.setVisible(false);
        npcFrame.setVisible(false);
        npcTypeFrame.setVisible(true);
    }
         
                
}
