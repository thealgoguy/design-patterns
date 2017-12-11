package hitcounter;

import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Deque;
import java.util.Random;
//Maintain 3 lists, one each for last hour, second and minute will require too much synchronization for updating three lists
//which will degrade concurrency of the application
//VVI : To find hits in last minute, we need to record hits in seconds granularity(deque size)
//      To record hits for last second we need queue size in milliseconds granularity

public class HitCounter {
    private class Hit {
    	public long time;
    	public long count;
    	
    	public Hit() {
    		this.time = Calendar.getInstance().get(Calendar.SECOND);
    		this.count = 1;
    	}
    }
    
    private static final int MAX_SIZE = 60*60;
    private long lastHitTime = 0;
    private  Deque<Hit> dq;
    private  long lastMinuteCount = 0; 
    
    public HitCounter() {
    	this.lastHitTime = Calendar.getInstance().get(Calendar.SECOND);
    	this.lastMinuteCount = 0;
    	dq = new ArrayDeque<Hit>();
    }
    
    public synchronized void hit() {
    	System.out.print(" Last hit time : "+lastHitTime);
    	long currentTime = Calendar.getInstance().get(Calendar.SECOND);
    	synchronized(this) {
    		if(currentTime == lastHitTime) {  //next hit in the same second
        		Hit lastHit = dq.peekLast();
        		if(lastHit == null) {
        			lastHit = new Hit();
        			dq.offer(lastHit);
        		}
        		else lastHit.count++;     
        	}   	
        	else { 
        		//remove the entries that are outside the minute window
            	while(!dq.isEmpty() && currentTime - dq.peekFirst().time >MAX_SIZE) {
            		lastMinuteCount -= dq.peekFirst().count;   
            		dq.poll();
            	}
        		//first hit for this second
        		Hit newHit = new Hit();
        		dq.add(newHit);
        	}   
    		lastMinuteCount++;
        	lastHitTime = currentTime;
        	System.out.print(" LastMinuteHitCount = "+getLastMinuteCount()+"\n");
    	}
    }
    
    public long getLastMinuteCount() {
    	return lastMinuteCount;
    }
    
    public static void main(String[] args){
		HitCounter hc = new HitCounter();
		Calendar c = Calendar.getInstance();
		int mill = c.get(Calendar.MILLISECOND);
		System.out.println("mill = "+mill);
		Random rd = new Random();
		for(int i=0;i<1E3;i++){
			System.out.print("i = " + i + ", ");
			hc.hit();
			try {
				Thread.sleep(rd.nextInt(100));//thread sleep a random time between [0,100] miliseconds 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
    
}
