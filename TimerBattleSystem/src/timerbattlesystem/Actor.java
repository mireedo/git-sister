/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timerbattlesystem;

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
	
	public Actor(String n)
	{
		this.name= n;
		this.maxHp= 100;
                this.hp=this.maxHp;
		this.minDmg= 5;
		this.maxDmg= 20;
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
	
	public void attacked(int attack)
	{
		hp= hp-attack;	
	}
	
	public int attack()
	{
		return minDmg;
	}
		
}
