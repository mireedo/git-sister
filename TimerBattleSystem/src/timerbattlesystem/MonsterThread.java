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
public class MonsterThread extends Thread {
    private Thread t;
    private String threadName;
    private Actor player;
    private Actor monster;
    
    MonsterThread (String name, Actor p, Actor m)
    {
        this.threadName = name;
        this.player = p;
        this.monster = m;
    }
    
    public void MonsterAct (Actor player, Actor monster)
    {
        while(monster.isAlive()){
            player.hp = player.hp - monster.attack();
            System.out.println(player.getName() + " is attacked!");
            System.out.println("HP : " +player.getHp());
        }
    }
    
    @Override
    public void run()
    {
        try{
           while (this.monster.timer != 10){
               this.monster.timer++;
            }
           MonsterAct(this.player, this.monster);
           Thread.sleep(50);
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