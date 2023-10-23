package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballController {

    private BaseballException baseballException = new BaseballException();
    private BaseballView baseballView = new BaseballView();
    private BaseballService baseballService = new BaseballService();

    // 게임 시작 함수
    public void startBaseball() {
        int strike = 0;

        baseballView.printBaseballStart();

        String computer = baseballService.getComputerNum();

        // 3스트라이크가 될 때까지 반복
        while (strike<3) {

            String randomNum = baseballView.inputRandomNum();

            baseballException.isLengthValid(randomNum);

            baseballException.isCharinString(randomNum);

            // 플레이어가 입력한 수에 문자가 있는 경우 예외처리
            if (baseballService.isCharacterExist(randomNum)){
                throw new IllegalArgumentException();
            }

            strike = 0;
            int ball = 0;

            // 컴퓨터가 임의로 뽑은 수 3개와 플레이어가 입력한 숫자 3개 비교
            for (int i=0; i<3; i++) {
                int index = 0;
                String number = Character.toString(computer.charAt(i));
                if (randomNum.contains(number)){
                    index = randomNum.indexOf(number);
                    if (i==index) {
                        strike+=1;
                    } else {
                        ball+=1;
                    }
                }
            }

            // 스트라이크, 볼, 낫싱 개수 세기
            if (strike==0 && ball==0) {
                System.out.println("낫싱");
            } else if (ball==0) {
                System.out.println(strike+"스트라이크");
            } else if (strike==0) {
                System.out.println(ball+"볼");
            } else {
                System.out.println(ball+"볼 "+strike+"스트라이크");
            }
        }

        // 3스트라이크인 경우, 게임 종료
        if (strike==3) {
            // 게임 종료 문구 출력
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            // 재시작 또는 종료 입력받기
            String restart = Console.readLine();

            // 플레이어가 입력한 수가 1 또는 2가 아닌 경우
            if (!"1".equals(restart) && !"2".equals(restart)){
                throw new IllegalArgumentException();
            }

            if ("1".equals(restart)) {
                startBaseball();
            } else if("2".equals(restart)) {
                System.out.println("게임 종료");
            }
        }
    }
}
