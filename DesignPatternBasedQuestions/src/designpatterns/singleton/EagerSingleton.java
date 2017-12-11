package singleton;
//Eager initialization, Not thread safe
//No exception handling during creation
//Singleton instance created at class loading by class loader
//If same class loaded by multiple loaders, multiple singleton instances will be created


public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();
    
    private EagerSingleton() {}
    
    public static EagerSingleton getInstance() {
    	return instance;
    }
}
