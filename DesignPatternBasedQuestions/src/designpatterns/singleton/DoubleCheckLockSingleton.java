package singleton;

//Deals with performance issue of synchronized method 
//by using double check lock inside synchronized block
//can fail if volatile is not used...due to compiler optimization/reordering

public class DoubleCheckLockSingleton {
   private static volatile DoubleCheckLockSingleton instance;
   
   private DoubleCheckLockSingleton () {}
   
   public DoubleCheckLockSingleton getInstance() {
	   if(instance == null) {
		   synchronized(DoubleCheckLockSingleton.class) {
			   if(instance == null) {
				   instance = new DoubleCheckLockSingleton();
			   }
		   }
	   }
	   return instance;
   }
}
