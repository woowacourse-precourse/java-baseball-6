package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	
	private RandomGenerator randomGenerator;
	private User user;
	
	/* Constructor */
	public Game(RandomGenerator randomGenerator, User user) {
		this.randomGenerator = randomGenerator;
		this.user = user;
	}
	
	
	/* 게임 시작 메소드 */
	public void gameStart() {
		do {
    		playGame();
    		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    	} while (continueGame());
	}
	
	
	/* 게임 핵심 메소드 */
	private void playGame() {
		List<Integer> comPick = randomGenerator.generate(3);
    	
    	while (true) {
    		List<Integer> userPick = user.input();
    		int[] result = checkNumbers(comPick, userPick);
    		
    		showResult(result);
    		
    		if (result[1] == 3) {
    			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    			break;
    		}
    	}	
	}
	
	
	/* 결과 보여주는 메소드 */
	private void showResult (int[] result) {
		
		StringBuilder sb = new StringBuilder();
		
		if (result[0] > 0) sb.append(result[0] + "볼 ");
		if (result[1] > 0) sb.append(result[1] + "스트라이크");
		if (sb.isEmpty()) sb.append("낫싱");
		
		System.out.println(sb.toString());
	}
	
	
	/* 숫자 비교 메소드 */
    private int[] checkNumbers(List<Integer> comPick, List<Integer> userPick) {
    	
    	int[] result = new int[2]; // 0 : Ball, 1 : Strike
    	
    	for (int i = 0; i < userPick.size(); i++) {
			for (int j = 0; j < comPick.size(); j++) {
				if (i == j && userPick.get(i) == comPick.get(j)) result[1]++; // 스트라이크 판정
				
				else if (userPick.get(i) == comPick.get(j)) result[0]++; // 볼 판정
				
				else {}
			}
		}
    	
    	return result;
    }
    
    /* 다시하기 메소드 */
    private static boolean continueGame() {
		
    	String input = Console.readLine();
    	
    	if (input.equals("1")) return true;
    	
    	else if (input.equals("2")) return false;
    	
    	else throw new IllegalArgumentException("1, 2 중에서 입력해 주세요!");
    }
}