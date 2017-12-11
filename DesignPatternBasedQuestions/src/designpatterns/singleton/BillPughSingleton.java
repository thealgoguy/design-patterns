package singleton;

//No synchronization used
//static inner class with eager initialization
//When the singleton class is loaded, LazyHolder class is not loaded into memory 
//only when getInstance() method called, LazyHolder is loaded.
//Preferred implementation

public class BillPughSingleton {
    
  private BillPughSingleton() {}
  
  private static class LazyHolder {
	  private static final BillPughSingleton INSTANCE = new BillPughSingleton(); 
  }
  
  public static BillPughSingleton getInstance() {
	  return LazyHolder.INSTANCE;
  }
}
