package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
		System.out.println("숫자 야구 게임을 시작합니다.");
    	
    	//System.out.println(computer);
    	//System.out.println(computer.get(0));
    	
    	boolean isApplicationRun = true;
    	while(isApplicationRun) {
    		boolean isGameRun = true;
    		// 컴퓨터 번호 설정
    		List<Integer> computer = new ArrayList<>();
        	while (computer.size() < 3) {
        	    int randomNumber = Randoms.pickNumberInRange(1, 9);
        	    if (!computer.contains(randomNumber)) {
        	        computer.add(randomNumber);
        	    }
        	}
        	// 게임 진행
    		while(isGameRun) {
    			System.out.print("숫자를 입력해주세요 : ");
    			String userInput = Console.readLine();
    			// 입력값이 잘못되었는지 확인
    			if(userInput.length() != 3) { // 길이가 3이 아닐 경우
    				//break Application;
    				throw new IllegalArgumentException();
    			}
    			List<Integer> user = new ArrayList<>();
    			for(int i = 0; i < 3; i++) { // 요소별로 확인
    				char dummy = userInput.charAt(i);
    				if(dummy < '1' || dummy > '9') { // 숫자가 아닐 때
    					//break Application;
    					throw new IllegalArgumentException();
    				}
    				if (user.contains(dummy)) { // 이미 있을 때
    	    	        //break Application;
    					throw new IllegalArgumentException();
    	    	    }
    				user.add(dummy - '0'); // user 리스트에 하나씩 저장
    			}
    			// 스트라이크 개수 확인
    			int strike = 0;
    			for(int i = 0; i < 3; i++) {
    				if(user.get(i) == computer.get(i)) {
    					strike++;
    				}
    			}
    			// 볼 개수 확인
    			int ball = 0;
    			for(int i = 0; i < 3; i++) {
    				if(user.get(i) == computer.get((i + 1) % 3) || user.get(i) == computer.get((i + 2) % 3)) {
    					ball++;
    				}
    			}
    			// 출력
    			if(strike == 0 && ball == 0) {
    				System.out.println("낫싱");
    			}
    			else if(ball == 0) {
    				System.out.println(strike + "스트라이크");
    			}
    			else {
    				System.out.println(ball + "볼 " + strike + "스트라이크");
    			}
    			if(strike == 3) {
    				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    				isGameRun = false;
    			}
    		}
    		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    		String userInput = Console.readLine();
			// 입력값이 잘못되었는지 확인
			if(userInput.length() != 1) { // 길이가 3이 아닐 경우
				//break Application;
				throw new IllegalArgumentException();
			}
			if(userInput.charAt(0) == '1') {
				continue;
			}
			else if(userInput.charAt(0) == '2') {
				isApplicationRun = false;
			}
			else {
				throw new IllegalArgumentException();
			}
    	}
    }
}
