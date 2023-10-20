package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
	List<Integer> comNum = new ArrayList<>(); //컴퓨터 생성 랜덤 숫자
	List<Integer> inputNum = new ArrayList<>(); //입력값

	 //게임 시작
	public static void init() {
		Game game = new Game();
		System.out.println(Constants.START_MSG);
		game.ready();
	}
	
	//랜덤 수 생성
	private void ready() {
		while(comNum.size() < Constants.DIGIT_SIZE) { //서로 다른 세자리 수 생성
	         int randomNum = Randoms.pickNumberInRange(Constants.START_RANGE, Constants.END_RANGE);
	         if(!comNum.contains(randomNum)) {
	            comNum.add(randomNum);
	         }
	      } 
	}

}
