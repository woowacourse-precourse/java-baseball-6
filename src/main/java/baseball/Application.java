package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {

		//게임진행 상태 변수
		int flag = 1;

		while(flag == 1) {
			List<Integer> computer = new ArrayList<>();
			while (computer.size() < 3) {
				int randomNumber = Randoms.pickNumberInRange(1, 9);
				if (!computer.contains(randomNumber)) {
					computer.add(randomNumber);
				}
			}
			System.out.println("숫자 야구 게임을 시작합니다.");
			int strike = 0;
			int ball = 0;
			while(strike < 3) {
				strike = 0;
				ball = 0;

				System.out.print("숫자를 입력해주세요 : ");

				String user = Console.readLine();
				
				//유효성 검사 - 숫자인지, 3자리수인지, 중복된 숫자인지 판별
				if(!Pattern.matches("^[1-9]{3}$", user)
						|| user.charAt(0) == user.charAt(1)
						|| user.charAt(0) == user.charAt(2)
						|| user.charAt(1) == user.charAt(2)) 
				{
					throw new IllegalArgumentException();
				}

				for(int i=0;i<3;i++) {
					if(computer.contains(Character.getNumericValue(user.charAt(i)))) {
						if(computer.get(i) == Character.getNumericValue(user.charAt(i))) {
							strike += 1;
						}
						else {
							ball += 1;
						}
					}
				}
				if(strike == 0 && ball == 0)
					System.out.println("낫싱");
				else if (strike > 0 && ball > 0)
					System.out.println(ball+"볼 "+strike+"스트라이크");
				else if (ball > 0)
					System.out.println(ball+"볼");
				else if (strike > 0) {
					System.out.println(strike+"스트라이크");
				}
			}
			if(strike == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			}
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			flag = Integer.parseInt(Console.readLine());
			
		}
		if(flag == 2) {
			
		}
		
		//유효성 검사 - 게임이 종료된 뒤 사용자가 1 또는 2가 아닌 값을 입력했을 때
		if(flag != 1 && flag !=2) {
			throw new IllegalArgumentException();
		}
	}
	
}
