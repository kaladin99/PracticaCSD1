// CSD feb 2015 Juansa Sendra

public class Pool2 extends Pool {   //no kids alone
    private int numkid = 0;
    private int numins = 0;
    //private int ratio = 0;
    int ki_L;
    int cap_L;

    public void init(int ki, int cap){
        ki_L = ki;
        cap_L = cap;


    }

    public synchronized void kidSwims() throws InterruptedException {
        
        while( numkid >= numins * ki_L ){ 
            
            wait();
            log.waitingToSwim();
        }
       
        log.swimming(); 
        numkid ++;
        //ratio--;
    }

    public synchronized void kidRests()   throws InterruptedException   {
        
        numkid--;
        notifyAll();
        log.resting();
        
       // ratio ++;
    
    } // al ixir el xiquet ha de avisar als instructors que volen ixir

    public synchronized void instructorSwims() throws InterruptedException   {
        
        numins++;
        notifyAll();
        log.swimming();
       
      //ratio += 2;
    
    } // al entrar un monitor ha de avisar als xiquets que volen entrar
    public synchronized void instructorRests() throws InterruptedException  {
        
        while (numkid > ((numins -1) * ki_L  )){
            wait();
            log.waitingToRest();
            
        }
        log.resting();
        numins--;
       // ratio -=2;
        
    } 


    
   

    


}
