package baseball;

import baseball.service.BaseballGame;

public class Application {

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.baseballGameStart();
    }
		/*Number num = new Number(); //랜덤 숫자매소드 받아오기 위해 생성
        GenerateNumber generateNumber=new GenerateNumber();
        BaseballGame baseballGame=new BaseballGame();
        int restart=1;
		BaseBallGameLogic comp = new BaseBallGameLogic(); //숫자야구 로직 처리하기위해 생성//마지막
        while(restart==1) {}
            Count.setStrike(0);
            generateNumber.createRandomNumber();
			int ranNum[] = num.getComputerNumber(); // 맞춰야 하는 수
			int sepNum[] = new int[3]; // 입력한 수를 분리한 수
			int restart = 0; //3스트라이크 입력받을 변수
			String inputNum; //입력받은 숫자 넣는 변수
			System.out.println("숫자 야구 게임을 시작합니다.");
			while (Count.getStrike()!=3) {
				System.out.printf("숫자를 입력해주세요 : ");
				Illegal illegal=new Illegal();
                illegal.checkIllegal(Console.readLine());
                comp.countBallAndStrike(num.getUserNumber(), num.getComputerNumber());
                if(Count.getStrike()==3){
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
                        gameStopNumber=false;
                        break;
                    }else {
                        throw new IllegalArgumentException();
                    }
                }
                if(restart==1)
                    break;

				*//*if (comp.nothing(ranNum, sepNum)) { //다 다르면 낫싱 출력
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

				}*//*

			}*/

}

