package baseball;

import baseball.controller.BaseballGameController;
import baseball.io.InputView;
import baseball.io.OutputView;
import baseball.service.NumberService;
import java.io.*;

import static baseball.utils.message.GameInfoMessage.*;
import static baseball.utils.message.IOMessage.*;

public class Application {

    public static final String CONTINUE = "1";
    public static void main(String[] args) {
        /***
         * 사용자 입력과 컴퓨터가 생성하는 '숫자'는 모두 공통사항이라고 생각
         * 검증 로직조차 동일하기 때문에 Number 도메인 객체를 정의
         *
         * Controller > Service > Domain으로 가는 흐름
         *
         * I/O 과정은 InputView , OutputView 를 통해서 Controller에서 사용자 입출력 받기
         * 예외 메시지, 입출력 메시지는 utils 패키지의 message 패키지에서 관리
         */

        // TODO: 프로그램 구현
        NumberService numberService = new NumberService();
        BaseballGameController baseballGameController = new BaseballGameController(numberService);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputView inputView = new InputView(reader);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        OutputView outputView = new OutputView(writer);

        outputView.write(START_GAME);
        boolean continueGame = true;

        while (continueGame) {
            outputView.write(INPUT_NUMBER);
            String userInput = inputView.readLine();

            boolean match = baseballGameController.match(userInput);
            String hint = baseballGameController.hint(userInput);
            outputView.write(hint +"\n");

            if(match) {
                outputView.write(CORRECT_NUMBER);
                outputView.write(CONTINUE_INPUT);

                userInput = inputView.readLine();
                continueGame = userInput.equals(CONTINUE);

                if (continueGame) {
                    baseballGameController.nextGame();
                }
            }
        }

        outputView.write(END_GAME);

    }
}
