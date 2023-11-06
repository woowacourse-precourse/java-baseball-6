package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	Random computer = new Random();
    	ArrayList<Integer> random = new ArrayList<>();
    	random = computer.Computer();
    	
    	System.out.println(random);
    }

}
