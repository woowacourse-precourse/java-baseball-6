package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ReplayDecision {
	
	public void valueOutOfBound() {
		
		//try {
		throw new IllegalArgumentException("1,2중 하나만 입력해주세요");
		//} catch(IllegalArgumentException e) {
			//System.out.println(e.toString());
			//e.printStackTrace();
			//return;
		//}
	}
	
	public String congrats_and_replay() {
		
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    	String decision=Console.readLine();
    	
    	return decision;
	}
	
	public void acceptDecision(String decision) {
		
		if(decision.equals("1"))
    		new Game().runGame();
    	else if(decision.equals("2"))
    		System.out.println("게임종료");
    	else
    		valueOutOfBound();
	}
	
	public ReplayDecision() {

		String decision=congrats_and_replay();
		acceptDecision(decision);
	}
}
