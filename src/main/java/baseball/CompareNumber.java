package baseball;

import java.util.ArrayList;
import java.util.List;

public class CompareNumber {
	public void CompareEachList() {
		
		ComputerOutput com_num = new ComputerOutput();
		UserInput user_num = new UserInput();
		
		// UserInput 클래스 내 메소드 실행 (유저 숫자 입력)
		
		com_num.MakeComNum();
		List<String> compareComNum = com_num.getComNum();
		
		while (true) {	
			user_num.InputUserNum();
			List<String> compareUserNum = user_num.getUserNum();
			
			int strike = 0;
			int ball = 0;
			
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					if ((i==j) && (compareComNum.get(i).equals(compareUserNum.get(j)))) {   
						strike = strike + 1;
						}
					else if ((i!=j) && (compareComNum.get(i).equals(compareUserNum.get(j)))) {
						ball = ball + 1;
					}
					else {
					}
				}
			}
		
			if (strike==0 && ball==0) {
				System.out.printf("낫싱%n");
			}
		
			else if (strike!=3 && strike!=0 && ball == 0) {
				System.out.printf("%d스트라이크%n", strike);
			}
			else if (strike==3) {
				System.out.printf("%d스트라이크%n", strike);
				System.out.printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
			}
			
			else if (strike==0 && ball != 0) {
				System.out.printf("%d볼%n", ball);
			}
			else {
				System.out.printf("%d볼 %d스트라이크%n", ball, strike);
			}
			if (strike==3) {
				break;
			}
		}
	}
}
	
		
		
