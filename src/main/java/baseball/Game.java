package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
	
	UserInput ui = new UserInput();
	ComputerInput ci = new ComputerInput();
	
	private List<Integer> computer;
	private List<Integer> user;
	int strike = 0;
	int ball = 0;
	
	public Game() {
		computer = ci.getComputer();
	}
	
	public void start() {
		strike = 0;
		ball = 0;
		user = ui.setUser();
		for(int i = 0; i < computer.size(); i++) {
    		int user_temp = user.get(i);
    		int com_temp = computer.get(i);
    		if (user_temp == com_temp) strike++;
    		else if (computer.contains(user_temp)) ball++;
    	}
		Calculate(strike, ball);
	}
	
	public void Calculate(int strike, int ball) {
		//game출력
    	if ((strike == 0) && (ball == 0)) {
    		System.out.println("낫싱");
    	} else if ((strike == 0) && (ball != 0)) {
    		System.out.println(ball+"볼");
    	} else if ((strike != 0) && (ball == 0)) {
    		System.out.println(strike+"스트라이크");
    	} else {
    		System.out.println(ball+"볼 "+strike+"스트라이크");
    	}
    	
    	//게임결과
    	if (strike != 3) {
        	start();
    	}
	}
	
	public int getstatus() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int temp = Integer.parseInt(Console.readLine());
		return temp;
	}
	

}
