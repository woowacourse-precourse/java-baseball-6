package baseball;

import camp.nextstep.edu.missionutils.Console;
public class GameManager {

    private static final String PLEASE_INPUT_NUMBER_MASSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_ENDING_MASSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String PLAY_OR_STOP_MASSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String START_MASSAGE = "숫자 야구 게임을 시작합니다.";

    private int gameSwitch = 1; // 게임 진행 여부를 체크 하는 변수
    private final AppConfig appConfig;
    private String answerNumber;

    public GameManager(AppConfig appConfig) {
        this.appConfig = appConfig;
        this.answerNumber = appConfig.randomNumberGenerator().makeRandomNumber();

    }

    public void runGame() {
        System.out.println(START_MASSAGE);
        while (gameSwitch == 1) {
            System.out.print(PLEASE_INPUT_NUMBER_MASSAGE);
            String userInputNumber = Console.readLine();

            // 유효성 체크
            appConfig.gameInputValidator().validateInput(userInputNumber);

            // 결과값 반환
            String answerMessage = appConfig.ballStrikeCalculator().calculateAnswer(userInputNumber,answerNumber);
            System.out.println(answerMessage);

            handleThreeStrike(answerMessage);
        }
    }

    public void handleThreeStrike(String answerMessage) {
        if (answerMessage.equals("3스트라이크")) {
            System.out.println(GAME_ENDING_MASSAGE);
            System.out.println(PLAY_OR_STOP_MASSAGE);
            String playOrStopNumber = Console.readLine();

            // 유효성 체크
            appConfig.playOrStopInputValidator().validateInput(playOrStopNumber);
            
            // 결과값 반환
            gameSwitch = Integer.parseInt(playOrStopNumber);

            if (gameSwitch == 1) {
                answerNumber = appConfig.randomNumberGenerator().makeRandomNumber();
            }
        }
    }
}
