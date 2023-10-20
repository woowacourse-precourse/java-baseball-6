package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	String answer = "";
    	boolean isRun = true;
    	boolean isContinue = true;
    	
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	while(isRun) {
    		List<Integer> computer = new ArrayList<>();
        	
        	while(computer.size() < 3) {
        		int randomNumber = Randoms.pickNumberInRange(1, 9);
        		if(!computer.contains(randomNumber)) computer.add(randomNumber);
        	}
        	
        	while(isContinue) {
        		System.out.print("숫자를 입력해주세요 : ");
        		
        		answer = Console.readLine();
        		
        		if(answer.trim().length() != 3) throw new IllegalArgumentException();
        		
        		
        		int strikeCount = 0;
        		int ballCount = 0;
        		
        		for(int i = 0 ; i < computer.size() ; i++) {
        			int computerNumber = computer.get(i);
        			for(int j = 0 ; j < answer.length(); j++) {
        				int answerNumber = Integer.valueOf(answer.charAt(j)) - '0';
        				if(i == j && computerNumber == answerNumber) strikeCount++;
        				else if(computerNumber == answerNumber) ballCount++;
        			}
        		}
        		
        		System.out.println(answer);
        		
        		StringBuffer sb = new StringBuffer();  
        		if(ballCount != 0) sb.append(ballCount + "볼");
        		if(ballCount != 0 && strikeCount != 0) sb.append(" ");
        		if(strikeCount != 0) sb.append(strikeCount + "스트라이크");
        		if(ballCount == 0 && strikeCount == 0) sb.append("낫싱");
        		System.out.println(sb.toString());
        		
        		if(strikeCount == 3) {
        			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        			isContinue = false;
        		}        		
        	}
        	
        	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        	answer = Console.readLine();
        	
			if(answer.equals("1")) {
				isContinue = true;
			} else if (answer.equals("2")) {
				System.out.println("게임을 종료합니다");
				isRun = false;
			} else {
				throw new IllegalArgumentException();
			}
    	}

    }
}
