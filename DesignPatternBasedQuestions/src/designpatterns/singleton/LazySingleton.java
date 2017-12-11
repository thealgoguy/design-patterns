package singleton;

//Lazy initialization, Not thread safe
public class LazySingleton {
    private static LazySingleton instance;
    
    private LazySingleton () {}
    
    public static LazySingleton getInstance() {
    	//threading issue here
    	if(instance == null) {
    		instance = new LazySingleton();
    	}
    	return instance;
    }
}
