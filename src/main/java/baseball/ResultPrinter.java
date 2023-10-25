package baseball;

import java.util.List;

public class ResultPrinter {
	public void printGameResult() {

		ComNumberGenerator comNumGenerator = new ComNumberGenerator();
		UserNumInputManager userNumInputManager = new UserNumInputManager();
		ExceptionHandler exceptionHandler = new ExceptionHandler();


		comNumGenerator.comGenerateNum();

		List<String> toCompareComNumList = comNumGenerator.getComGenerateNumList();
		
		while (true) {
			userNumInputManager.inputUserNum();

			List<String> toCompareUserNumList = userNumInputManager.getUserInputNumList();
			
			int strike = 0;
			int ball = 0;
			
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					if ((i==j) && (toCompareComNumList.get(i).equals(toCompareUserNumList.get(j)))) {
						strike = strike + 1;
						}
					else if ((i!=j) && (toCompareComNumList.get(i).equals(toCompareUserNumList.get(j)))) {
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
			
			else if (strike==0 && ball!=0) {
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
	
		
		
