package baseball;

import baseball.controller.gameSet;

public class Application {
    public static void main(String[] args) {

        gameSet baseball = new gameSet();

        /*
        int gameswitch = 1;
        //게임 진행
        while(gameswitch == 1) {
            //랜덤 값(정답 번호) 생성
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computerNumber = new ArrayList<>();
            while (computerNumber.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNumber.contains(randomNumber)) {
                    computerNumber.add(randomNumber);
                }
            }

            while(true){
                int strike = 0;
                int ball = 0;
                System.out.printf("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                NumberCheck.DigitNumber(input);
                NumberCheck.NonNumber(input);
                NumberCheck.RangeOut(input);
                NumberCheck.DuplicateNumber(input);
                List<Integer> playerNumber = new ArrayList<>();

                for(String number: input.split("")){
                    playerNumber.add(Integer.parseInt(number));
                }

                for (int i = 0; i<playerNumber.size(); i++){
                    if (computerNumber.get(i) == playerNumber.get(i)){
                        strike++;
                    }else if(computerNumber.contains(playerNumber.get(i))){
                        ball++;
                    }
                }
                if(strike+ball == 0){
                    System.out.println("낫싱");
                }else {
                    if(strike>0 && ball>0){
                        System.out.println(ball+"볼 "+strike+"스트라이크");
                    }else if(ball>0 && strike == 0){
                        System.out.println(ball+"볼");
                    }else if(strike>0 && ball == 0) {
                        System.out.println(strike + "스트라이크");
                        if(strike == 3){
                            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                            break;
                        }
                    }
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameswitch = Integer.parseInt(Console.readLine());
        }*/

    }
}
