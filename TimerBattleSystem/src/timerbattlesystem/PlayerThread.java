/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timerbattlesystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

//import java.util.concurrent.locks.Lock;

/**
 *
 * @author Mira
 */
public class PlayerThread extends Thread {
    private Thread t;
    private String threadName;
    private Actor player;
    private Actor monster;
    private Lock lock;
    
    PlayerThread (String name, Actor p, Actor m)
    {
        this.threadName = name;
        this.player = p;
        this.monster = m;
        this.lock = new ReentrantLock();
    }
    
    public void PlayerAct (Actor player, Actor monster) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Date date = new Date();
            System.out.println(player.name+" is READY to attack! (z)");
            String action = in.readLine();
            System.out.println(player.name+"'s action received at "+new Timestamp(date.getTime()));
            if (action.equals("z") || action.equals("Z")){
                int attack=player.attack();
               
                lock.lock();
            try {
                monster.hp -= attack;
            } finally {
                lock.unlock();
            }
                
                System.out.println(player.name+"'s damage : "+attack);
            }
            else if(action.equals("x") || action.equals("X")){
                lock.lock();
            try {
                player.heal(player);
            } finally {
                lock.unlock();
            }
                System.out.println(player.name+"heals. HP: "+player.hp);
            }
            if (monster.isAlive()){
                    System.out.println("Monster is still alive!");
                    System.out.println("MONSTER's HP : "+monster.getHp());
            }                   
            player.timer = 0;
    }
    
    @Override
    public void run()
    {
        try{
           while (this.player.isAlive() && this.monster.isAlive()){
                while (this.player.timer != 10){
                    System.out.println(this.player.name+"wait for "+(10 - this.player.timer) +"s..");
                    this.player.timer++;
                    Thread.sleep(900);
                }
                PlayerAct(this.player, this.monster);
           }
           if (!this.monster.isAlive())
               System.out.println(this.player.name+" defeated the monster!");
        }
        catch (IOException e){
            System.out.println("IOException!");
        }
        catch (InterruptedException e1){
            System.out.println("Interrupted!");
        }
    }
    
    public int keyPressed(KeyEvent e){
        return e.getKeyCode();
    }
}
