// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool {   //no kids alone
    private int numkid = 0;
    private int numins = 0;
    //private int ratio = 0;
    private final int maxCap = 5;
    

    public void init(int ki, int cap){}

    public synchronized void kidSwims() throws InterruptedException {
        
        while( numkid >= (numins*2) || (numkid + numins) == maxCap ){ 
            
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
        while (numins + numkid == maxCap){wait();}
        
        notifyAll();
        log.swimming();
        numins++;
      //ratio += 2;
    
    } // al entrar un monitor ha de avisar als xiquets que volen entrar
    public synchronized void instructorRests() throws InterruptedException  {
        
        while (numkid >= (numins * 2  - 1)){
            wait();
            log.waitingToRest();
            
        }
        log.resting();
        numins--;
        notifyAll();
       // ratio -=2;
        
    } 


    
   

    


}
