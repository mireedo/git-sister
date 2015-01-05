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
public class PlayerThread extends Thread {
    private Thread t;
    private String threadName;
    private Actor player;
    private Actor monster;
    
    PlayerThread (String name, Actor p, Actor m)
    {
        this.threadName = name;
        this.player = p;
        this.monster = m;
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
    
    @Override
    public void run()
    {
        try{
           while (this.player.timer != 10){
               System.out.println("Wait for "+this.player.timer +"s..");
               this.player.timer++;
           }
           PlayerAct(this.player, this.monster);
           Thread.sleep(50);
        }
        catch (IOException e){
            System.out.println("IOException!");
        }
        catch (InterruptedException e1){
            System.out.println("Interrupted!");
        }
    }
    
    @Override
    public void start(){
        if (t == null)
        {
            t = new Thread (this.t, threadName);
            t.start();
        }
    }
}
