/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timerbattlesystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mira
 */
public class MultiThread {
    private Thread t;
    private String threadName;
    
    MultiThread( String name)
    {
        this.threadName = name;
    }
    
    public void start()
    {
        if (t == null)
        {
            t = new Thread ((Runnable) this, threadName);
            t.start();
        }
    }
    
    public int timer (Actor player)
    {
        return player.timer++;
    }
    
    public void battle(Actor player, Actor monster)
    {
        
    }
    
    public void MonsterAct (Actor player, Actor monster)
    {
        while(monster.isAlive()){
            player.hp = player.hp - monster.attack();
            System.out.println(player.getName() + " is attacked!");
            System.out.println("HP : " +player.getHp());
        }
    }
    
    public void PlayerAct (Actor player, Actor monster) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(player.isAlive()){
            System.out.print("Attack! (Z)");
            String action = in.readLine();
            if (action.equals("z") || action.equals("Z")){
                int attack=player.attack();
                monster.hp = monster.hp - attack;
                System.out.print("Your damamge : "+attack);
            }
        }
    }
}
