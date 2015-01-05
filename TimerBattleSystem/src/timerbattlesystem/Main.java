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
        Actor monster = new Actor ("Monster");
        
        PlayerThread P1 = new PlayerThread ("Th1", hero1, monster);
        P1.start();
        
        MonsterThread P2 = new MonsterThread ("Th2", hero1, monster);
        P2.start();
    }
    
}
