package timerbattlesystem;
import java.util.concurrent.locks.Lock;

public class ThreadDemo extends Thread {
   private Thread t;
   private String threadName;
   private Lock lock;
   
   ThreadDemo( String name, Lock lock){
       threadName = name;
       System.out.println("Creating " +  threadName );
       this.lock = lock;
       
   }
   public void run() {
		Actor hero_1 = new Actor("hero_1");
                
      System.out.println("Running " +  threadName );
      lock.lock();
      //try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
         }
     //} catch (InterruptedException e) {
     //    System.out.println("Thread " +  threadName + " interrupted.");
     //}
      lock.unlock();
     System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start ()
   {
      System.out.println("Summon " +  threadName );
      if (t == null)
      {
         t = new Thread (this, threadName);
         t.start ();
      }
   }

}