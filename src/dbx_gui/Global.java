/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbx_gui;

import java.util.*;

/**
 *
 * @author villafan
 */
public class Global {
    /**
     * Remember whether the system administrator is logged in.
     */
    public static boolean is_admin_authn = false;

    /**
     * Remember whether a player is logged in.
     */
    public static boolean is_player_authn = false;
    
    /**
     * If a player is logged in, remember the player id.
     */
    public static long authn_player_id;
    
    /**
     * Collection of all test objects
     */
   // public static List<jpa.Test> testColl;

    /**
     * Collection of all Players
     */
    public static List<jpa.Player> playerColl;

    /**
     * Collection of all benevolent NPCs
     * TODO: change Test to NPC class
     */
  //  public static List<jpa.Test> benNpcColl;

    /**
     * Collection of all aggressive NPCs
     * TODO: change Test to NPC class
     */
    //public static List<jpa.Test> aggrNpcColl;
}
