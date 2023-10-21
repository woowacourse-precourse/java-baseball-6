package baseball;

import baseball.generator.ComputerRandomNumberGenerator;
import baseball.generator.RandomNumberGenerator;
import baseball.input.BaseBallGameUserInput;
import baseball.input.UserInput;
import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {

    private final RandomNumberGenerator<BaseBallNumberCollection> randomNumberGenerator =
        new ComputerRandomNumberGenerator();
    private final UserInput<BaseBallNumberCollection> baseBallUserInput = new BaseBallGameUserInput();
    private final Integer baseBallGameSize;

    private static final String CONTINUE_GAME_CODE = "1";
    private static final String STOP_GAME_CODE = "2";
    private static final String BASE_BALL_GAME_START_FORMAT = "숫자 야구 게임을 시작합니다.";
    private static final String WIN_GAME_FORMAT = "%s개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String CONTINUE_GAME_QUESTION_FORMAT =
        String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",CONTINUE_GAME_CODE, STOP_GAME_CODE);

    public BaseBallGame(final Integer gameSize) {
        baseBallGameSize= gameSize;
    }

    public void startGame(){
        System.out.println(BASE_BALL_GAME_START_FORMAT);
        do{
            final BaseBallNumberCollection randomNumberList = generateNumber();
            BaseBallNumberCollection userInput;
            do{
                userInput=baseBallUserInput.input(baseBallGameSize);
            }while(matchingNumber(userInput, randomNumberList));
        }while(checkContinuationGame());
        baseBallUserInput.close();
    }

    private BaseBallNumberCollection generateNumber(){
        return randomNumberGenerator.generate(baseBallGameSize);
    }

    private Boolean matchingNumber(final BaseBallNumberCollection userInput, final BaseBallNumberCollection randomNumber){
        if(randomNumberGenerator.match(userInput, randomNumber)){
            System.out.println(String.format(WIN_GAME_FORMAT,baseBallGameSize));
            return false;
        }else{
            return true;
        }
    }

    private Boolean checkContinuationGame(){
        System.out.println(CONTINUE_GAME_QUESTION_FORMAT);
        final String inputString = Console.readLine();
        if(inputString.equals(CONTINUE_GAME_CODE)){
            return true;
        }else if(inputString.equals(STOP_GAME_CODE)){
            return false;
        }else{
            throw new IllegalArgumentException();
        }
    }

}
