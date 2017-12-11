package singleton;

//concurrency overhead due to synchronized method

public class SynchronizedMethodSingleton {
  private static SynchronizedMethodSingleton instance;
  
  public static synchronized SynchronizedMethodSingleton getInstance() {
	  if(instance == null) {
		  instance = new SynchronizedMethodSingleton();
	  }
	  return instance;
  }
}
