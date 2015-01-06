/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timerbattlesystem;

/**
 *
 * @author Mira
 */
public class Main {

    /**coba coba mau commits
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Mulai");
        Actor hero1 = new Actor ("Hero-1");
        System.out.println("Player " +hero1.name+" is created.");
        Actor hero2 = new Actor ("Hero-2");
        System.out.println("Player " +hero2.name+"is created.");
        Actor monster = new Actor ("Monster");
        System.out.println("Player "+monster.name+" is created.");
        
        PlayerThread P1 = new PlayerThread ("Player1", hero1, monster);
        P1.start();
        
        PlayerThread P2 = new PlayerThread ("Player2", hero2, monster);
        P2.start();
        
        MonsterThread P3 = new MonsterThread ("Th2", hero1, monster);
        P3.start();
    }
    
}
