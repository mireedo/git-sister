/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timerbattlesystem;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.concurrent.locks.Lock;

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
        //this.lock = lock;
    }
    
    public void MonsterAct (Actor player, Actor monster)
    {
            player.hp = player.hp - monster.attack();
            System.out.println(player.getName() + " is attacked!");
            System.out.println("HP : " +player.getHp());
            this.monster.timer = 0;
       
    }
    
    @Override
    public void run()
    {
        try{
            while (this.monster.isAlive() && this.player.isAlive()){
                while (this.monster.timer != 10){
                    this.monster.timer++;
                    Thread.sleep(900);
                }
                MonsterAct(this.player, this.monster);
                Thread.sleep(100);
           }
            if (!this.player.isAlive())
                System.out.println("Game over!");
        }
        catch (InterruptedException e1){
            System.out.println("Interrupted!");
        }
    }

}
