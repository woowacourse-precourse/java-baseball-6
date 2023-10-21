package baseball;

import baseball.controller.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.baseballGameStart();
    }
		/*Number num = new Number(); //랜덤 숫자매소드 받아오기 위해 생성
		CompareLogic comp = new CompareLogic(); //숫자야구 로직 처리하기위해 생성
		boolean game = true; //마지막 
		while (game) {
			int ranNum[] = num.CreateRanNum(); // 맞춰야 하는 수
			int sepNum[] = new int[3]; // 입력한 수를 분리한 수
			int restart; //3스트라이크 입력받을 변수
			String inputNum; //입력받은 숫자 넣는 변수
			System.out.println("숫자 야구 게임을 시작합니다.");
			while (true) {
				System.out.printf("숫자를 입력해주세요 : ");
				inputNum = Console.readLine(); //입력받기
				Illegal illiegal = new Illegal(); //예외처리하기 위해 생성
				illiegal.illegalIntNumber(inputNum); // 입력한 숫자가 정수값아니면 예외처리
				int intNum = Integer.parseInt(inputNum); // 스트링을 정수값으로 변환
				illiegal.illegalNotThree(intNum); // 세자리수아니면 예외처리
				sepNum = illiegal.illegalZeroOrDuplicate(intNum); // 중복된 숫자거나 0이 포함되어 있으면 예외처리

				if (comp.nothing(ranNum, sepNum)) { //다 다르면 낫싱 출력
					System.out.println("낫싱");
					continue;
				}else {
					if(comp.ball(ranNum, sepNum)>0) {
						System.out.print(comp.ball(ranNum, sepNum)+"볼 ");
						if(comp.strike(ranNum, sepNum)==0) {
							System.out.println();
						}
					}
					if(comp.strike(ranNum, sepNum)>0) {
						System.out.println(comp.strike(ranNum, sepNum)+"스트라이크");
						if(comp.strike(ranNum, sepNum)==3) {
							System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
							System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
							try {
								restart=Integer.parseInt(Console.readLine());
							}catch (Exception e) {
								// TODO: handle exception
								throw new IllegalArgumentException();
							}
							
							if(restart==1) {
								break;
							}else if(restart==2){
								game=false;
								break;
							}else {
								throw new IllegalArgumentException();
							}
						}
					}

				}

			}
		}
	}*/
}
