package baseball;
import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class PlayBall{
	public void Controller() throws IllegalArgumentException{
		System.out.println("숫자 야구 게임을 시작합니다");
		List<String> create = createNumber();
		while(true) {
			System.out.print("숫자를 입력해주세요 : ");
			String[] input = Console.readLine().split("");
			
			for(int i=0;i<input.length;i++) {
				if(input.length != 3) {
					throw new IllegalArgumentException();
				}
			}

			String result = judgeNumber(create,input);
			System.out.println(result);
			
			if(result.equals("3스트라이크")) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");	
				if(nextGame() == true)
					create = createNumber();
				else
					System.out.println("게임 종료");
					System.exit(0);
			}
		}
		
	}
	
	private boolean nextGame() throws IllegalArgumentException {
		boolean check = true;
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String answer = Console.readLine();
		
		if(!answer.equals("1") && !answer.equals("2"))
			throw new IllegalArgumentException();

		if(answer.equals("2")) {
			check = false;
		}
		
		return check;
	}

	private List<String> createNumber() {
		List<String> number = new ArrayList<String>();
		while(number.size() < 3) {
			String rand = Integer.toString(Randoms.pickNumberInRange(1, 9));
			if(!number.contains(rand))
				number.add(rand);
		}
		return number;
	}
	
	private String judgeNumber(List<String> create, String[] input) {
		String result = "";
		int strike = 0;
		int ball = 0;
		
		for(int i=0;i<input.length;i++) {
			if(create.contains(input[i])) {
				if(create.get(i).equals(input[i])) 
					strike += 1;
				else 
					ball += 1;
			}
		}
		if(ball > 0) 
			result += ball+"볼";
		if(strike > 0) {
			if(ball > 0) 
				result += " ";
			result += strike+"스트라이크";
		}
		if(ball == 0 && strike == 0) 
			result += "낫싱";
		
		return result;
	}
	
}
