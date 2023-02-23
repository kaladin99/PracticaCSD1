// CSD feb 2015 Juansa Sendra

public class Pool1 extends Pool {   //no kids alone
    private int numkid = 0;
    private int numins = 0;

    public void init(int ki, int cap){}

    public synchronized void kidSwims() throws InterruptedException {
        
        while(numins == 0){ 
            
            wait();
            log.waitingToSwim();
           
        }

        log.swimming();
        numkid ++;
    }

    public synchronized void kidRests()   throws InterruptedException   {
        
        notifyAll();
        log.resting();
        numkid--;
    
    } // al ixir el xiquet ha de avisar als instructors que volen ixir

    public synchronized void instructorSwims() throws InterruptedException   {
        
        notifyAll();
        log.swimming();
        numins++;
    
    } // al entrar un monitor ha de avisar als xiquets que volen entrar
    public synchronized void instructorRests() throws InterruptedException  {
        
        while (numkid > 0 && numins == 1 ) {
            wait();
            log.waitingToRest();
            
        }
        log.resting();
            numins--;
        
    } 


    
   

    


}
