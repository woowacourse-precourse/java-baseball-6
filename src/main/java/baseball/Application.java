package baseball;
import camp.nextstep.edu.missionutils.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main (String[] args){
    	List<Integer> computer = new ArrayList<>();
    	List<Integer> inputNumberArray = new ArrayList<>();
    	final String REGEX = "^[1-9]*$";
    	
    	System.out.println("숫자 야구 게임을 시작합니다.");
    		
    		while(true) {
    		
    		
    		while(computer.size()<3) {
    			int randomNumber = Randoms.pickNumberInRange(1, 9);
    			if(!computer.contains(randomNumber)) {
    				computer.add(randomNumber);
    			}
    		}
    		
for (int i = 0; i < 3; i++) {
				System.out.println(computer.get(i));
			}
    		
    		while(true) {
    			System.out.print("숫자를 입력해주세요 : ");
    			String input = Console.readLine();
    			if(input.matches(REGEX)==false) {
    				throw new IllegalArgumentException();
    			}
    			int inputNumber = Integer.parseInt(input);
    			int strike = 0;
    			int ball = 0;
    			
    			if(inputNumber>999||inputNumber<100) {
    				throw new IllegalArgumentException();
    			}
    			
    			inputNumberArray.add(inputNumber/100);
    			inputNumber = inputNumber%100;
    			inputNumberArray.add(inputNumber/10);
    			inputNumberArray.add(inputNumber%10);
    			inputNumberArray = inputNumberArray.stream().distinct().collect(Collectors.toList());
    			if(inputNumberArray.size()!=3||inputNumberArray.contains(0)) {
    				throw new IllegalArgumentException();
    			}
    		
    				for(int j=0; j<3; j++) {
    					if(inputNumberArray.contains(computer.get(j))) {
    						if(computer.get(j)==inputNumberArray.get(j)) {
    							strike++;
    						} else {
    							ball++;
    						}
    					}
    				}
    		
    			if(ball != 0) {
    				System.out.print(ball + "볼 ");
    			}
    			if(strike !=0 ) {
    				System.out.print(strike + "스트라이크");
    			}
    			if(ball ==0 && strike ==0) {
    				System.out.print("낫싱");
    			}
    			System.out.println();
    			inputNumberArray.clear();
    			
    			if(strike == 3) {
    				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    				computer.clear();
    				break;
    			}
    		}
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			String retryNumber = Console.readLine();
			if(Integer.parseInt(retryNumber) == 2) {
				break;
			}
			if(Integer.parseInt(retryNumber)!=1||retryNumber.matches(REGEX)==false) {
				throw new IllegalArgumentException();
			}
		
    	}
    }
}