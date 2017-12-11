package snakeladder;

import java.util.Random;

public class Dice {
	
     public int getRandom() {
    	 Random rd = new Random();
    	 return rd.nextInt(7);
     }
}
