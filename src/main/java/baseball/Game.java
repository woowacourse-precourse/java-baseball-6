package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final boolean playingGame = true;
    public Game(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void playing(){
        String computeNumber = BaseBall.creatNumber();
        System.out.println(computeNumber);
        while(playingGame) {
            System.out.print("숫자를 입력해주세요 : ");
            String userNumber = Console.readLine();

            if(!ExceptionHandler.isAllDigit(userNumber)){
                throw new IllegalArgumentException("숫자가 아닌 입력이 들어왔습니다.");
            }
            if(!ExceptionHandler.isValidLength(userNumber)){
                throw new IllegalArgumentException("3자리를 초과한 숫자가 입력으로 들어왔습니다.");
            }
            if(!ExceptionHandler.isValidNumber(userNumber)){
                throw new IllegalArgumentException("0이 포함되거나 중복된 숫자가 입력으로 들어왔습니다.");
            }

            int cntBS = GameRule.countBallAndStrike(computeNumber, userNumber);
            int cntS = GameRule.countStrike(computeNumber, userNumber);
            int cntB = cntBS - cntS;

            System.out.printf("cntB %d cntS %d".formatted(cntBS, cntS));
            System.out.println();
            if (cntS == 3) {
                System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String reGame = Console.readLine();
                System.out.println(reGame);
                if (reGame.equals("2")) {
//                    playingGame = false; -> "예외_테스트" 에러
                    break;
                }
                else {
                    computeNumber = BaseBall.creatNumber();
                    System.out.println(computeNumber);
                }
            }
            else {
                System.out.print("힌트: ");
                System.out.println(GameRule.hintProvider(cntB, cntS));
            }
        }
        System.out.println("게임이 종료되었습니다.");
    }
}
