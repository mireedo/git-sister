/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timerbattlesystem;
import java.awt.event.KeyEvent;

/**
 *
 * @author Mira
 */
public class Battle {
    private int Timer()
    {
        int counter = -1;   
        return counter++;
    }
    
    public Battle (Actor player, Actor monster)
    {
        KeyEvent action;
        
        while (player.isAlive()){
            while (Timer() != 10)
                System.out.print("Timer = " + Timer());
            System.out.print("Press Z to Attack!");
        }
    }
}
