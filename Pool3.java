// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool {   //no kids alone
    private int numkid = 0;
    private int numins = 0;
    //private int ratio = 0;
    //private final int maxCap = 5;
    int ki_L;
    int cap_L;

    public void init(int ki, int cap){
        ki_L = ki;
        cap_L = cap;
    }

    public synchronized void kidSwims() throws InterruptedException {
        
        while( numkid >= (numins* ki_L) || (numkid + numins) == cap_L ){ 
            
            wait();
            log.waitingToSwim();
           
        }
       


        log.swimming();
        numkid ++;
        //ratio--;
    }

    public synchronized void kidRests()   throws InterruptedException   {
        
        notifyAll();
        log.resting();
        numkid--;
       // ratio ++;
    
    } // al ixir el xiquet ha de avisar als instructors que volen ixir

    public synchronized void instructorSwims() throws InterruptedException   {
        while (numins + numkid == cap_L){wait();}
        
        notifyAll();
        log.swimming();
        numins++;
      //ratio += 2;
    
    } // al entrar un monitor ha de avisar als xiquets que volen entrar
    public synchronized void instructorRests() throws InterruptedException  {
        
        while (numkid > ((numins -1) * ki_L  )){
            wait();
            log.waitingToRest();
            
        }
        log.resting();
        numins--;
        notifyAll();
       // ratio -=2;
        
    } 


    
   

    


}
