/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timerbattlesystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.locks.Lock;

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
    
    PlayerThread (String name, Actor p, Actor m, Lock lock)
    {
        this.threadName = name;
        this.player = p;
        this.monster = m;
        this.lock = lock;
    }
    
    public void PlayerAct (Actor player, Actor monster) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(player.name+" is READY to attack! (z)");
            String action = in.readLine();
            if (action.equals("z") || action.equals("Z")){
                int attack=player.attack();
                lock.lock();
            try {
                monster.hp = monster.hp - attack;
            } finally {
                lock.unlock();
            }
                System.out.println(player.name+"'s damage : "+attack);
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
}
