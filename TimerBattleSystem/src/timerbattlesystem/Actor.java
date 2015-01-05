/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timerbattlesystem;

import java.util.Random;

/**
 *
 * @author kundaime
 */
public class Actor
{
	protected String name;
	protected int hp;
	protected int maxHp;
	protected int minDmg;
	protected int maxDmg;
        public int timer;
	
	public Actor(String n)
	{
		this.name= n;
		this.maxHp= 200;
                this.hp=this.maxHp;
		this.minDmg= 5;
		this.maxDmg= 20;
                this.timer = 0;
	}
        
	public void setName(String name)
	{
            this.name= name;
	}
	
	public String getName()
	{
            return name;
	}
	
	public void setHp(int Hp)
	{
            hp= Math.min(maxHp, Math.max(Hp, 0));
	}
	
	public int getHp()
	{
            return hp;
	}
	
	public void setMaxHP(int Hp)
	{
            maxHp= Hp;
	}
	
	public int getMaxHp()
	{
            return maxHp;
	}
	
	public int attack()
	{
                Random rn = new Random();
		return rn.nextInt(maxDmg - minDmg + 1) + minDmg;
	}
        
        public boolean isAlive(){
            return hp > 0;
        }
		
}
