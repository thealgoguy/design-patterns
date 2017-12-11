package singleton;

//Enum provide implicit support for thread safety and only one instance is guaranteed.
//The drawback is that the enum type is somewhat inflexible; for example, it does not allow lazy initialization.

public enum EnumSingleton {
	INSTANCE;
    public static void someMethod(String param) {
        // some class member
    }
}
