package baseball;

import baseball.constants.NumberConstants;
import baseball.logic.GameLogic;
import baseball.utils.ComputerUtils;
import baseball.utils.MessageUtils;
import baseball.utils.UserUtils;
import baseball.verification.InputVerification;
import baseball.verification.RestartVerification;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        MessageUtils.startMessage(); // 시작 메세지 출력
        ComputerUtils computerUtils = new ComputerUtils(); // computerUtils 객체 생성
        UserUtils userUtils = new UserUtils(); // userUtils 객체 생성
        List<Integer> computerNumber = computerUtils.generateComputerNumber(); // ComputerUtils 객체를 사용하여 컴퓨터의 숫자를 생성하고, computerNumber 리스트에 저장

        while (true) {
            List<Integer> userNumber = new ArrayList<>(); // user의 세자리 숫자를 저장할 list 선언
            MessageUtils.inputPromptMessage(); // 입력 메세지 출력
            String stringFormInputNumber = userUtils.inputUserNumber(); // user가 입력한 세자리 숫자를 stringFormInputNumber에 저장

            InputVerification.verifyNumber(stringFormInputNumber); // user가 입력한 숫자를 검증

            int intFormInputNumber = Integer.parseInt(stringFormInputNumber); // 검증을 통과하면 String 자료형을 int 자료형으로 형변환

            userNumber = UserUtils.splitDigits(intFormInputNumber); // UserUtils 클래스의 extractDigits 메서드를 사용하여 숫자 추출

            int strike = GameLogic.checkStrike(userNumber, computerNumber); // strike 횟수 측정
            int ball = GameLogic.checkBall(userNumber, computerNumber); // ball 횟수 측정

            MessageUtils.resultMessage(strike, ball);  // 위에서 측정한 strike, ball 횟수를 내부 조건문을 거쳐 출력함

            if (strike == NumberConstants.MAX_STRIKE) { // stirke가 MAX_STRIKE(삼진 아웃)일 경우
                if (!RestartVerification.askForRestart()) { // 종료를 선택하면 break로 while문 탈출
                    break;
                }
                computerNumber = computerUtils.generateComputerNumber(); // 재시작을 선택하면 다시 computer 리스트에 난수를 생성해 추가하고 while 문 반복
            }
        }
    }
}

