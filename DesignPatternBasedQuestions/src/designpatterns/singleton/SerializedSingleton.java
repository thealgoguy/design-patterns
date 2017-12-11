package singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//necessary in distributed system
//deserialization creates new instances each time, if readResolve() not overridden

public class SerializedSingleton implements Serializable{
	 private static final long serialVersionUID = -7604766932017737115L;
	 
	 private SerializedSingleton (){}
	 
	 private static class LazyHolder {
		 private static final SerializedSingleton INSTANCE = new SerializedSingleton();
	 }
	 
	 public static SerializedSingleton getInstance() {
		 return LazyHolder.INSTANCE;
	 }
	 
	 //if u don't override this method, different hashcodes will result in main method..test
	 protected Object readResolve() {
		    return getInstance();
		}
	 
	 public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
	        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
	        out.writeObject(instanceOne);
	        out.close();
	        
	        //deserailize from file to object
	        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
	        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
	        in.close();
	        
	        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
	        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());	        
	    }
}
