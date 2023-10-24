package baseball.view;

import baseball.control.GameProgress;
import baseball.domain.NumbersGenerate;
import baseball.string.MyConstants;
import baseball.utill.Utill;
import baseball.utill.ValidException;

import java.util.ArrayList;
import java.util.List;

public class GameStart {
    private static final int NOT_AGAIN_GAME = 2;
    private static final int RESET_NUM = 0;
    private static final int USER_INPUT_SIZE = 3;
    private String hintOfJudge; // 결과를 담는 문자열
    private List<Integer> computerList; // 컴퓨터의 3개의 랜덤 숫자 리스트
    private List<Integer> userList; // 입력을 받는 userList
    private GameProgress gameProgress; // 게임 진행 클래스
    private NumbersGenerate numbersGenerate; // 게임 숫자 설정 객체.


    public GameStart() {
        gameProgress = new GameProgress();
        computerList = new ArrayList<>();
        userList = new ArrayList<>();
        numbersGenerate = new NumbersGenerate();
    }

    public void run() {

        while (true) {
            initGame();

            // resultStr 이 "3스트라이크" 아니면 반복을 한다.
            while (isConditionForPlayGame()) {
                playMainBaseBallGame();
            }

            if (isNotProceedGame()) { // 게임의 종료 상황을 알려주고, 4.1 숫자 2을 누르면 게임 종료 진행
                break;
            }
        }
    }

    /**
     * 게임 진행의 조건 "3스트라이크"이 아니면 된다.
     *
     * @return
     */
    private boolean isConditionForPlayGame() {
        return Utill.isNotSameString(hintOfJudge, MyConstants.MSG_GAME_TERMINATION_CONDITION_STR());
    }

    /**
     * 메인 야구 게임의 진행 상황을 시작한다.
     */
    private void playMainBaseBallGame() {
        makeUserListFromInputTreeNum(); // 유저의 입력을 받아서 userList을 얻는다.
        hintOfJudge = gameProgress.getHintOfJudge(computerList, userList); // judge의 힌트를 얻는다.
        printHintMsg();
    }


    /**
     * 게임을 초기화 할때 사용을 한다. 힌트의 값과, 컴퓨터의 랜덤 리스트를 초기화한다..
     *
     * @return
     */
    private void initGame() {
        hintOfJudge = MyConstants.RESET_STRING(); // 결과 리셋
        computerList = numbersGenerate.createRandomNumList(); // 컴퓨터의 3개의 랜덤 숫자 리스트
    }

    /**
     * 문자열 입력을 받아 List<Integer>의 LIST을 반환한다.
     *
     * @return "123" => {1 , 2, 3}
     */

    private void makeUserListFromInputTreeNum() {
        initUserList();
        printMsgBeforInputNum(); // 입력을 받기 전 출력 문구 "숫자를 입력해주세요 : "
        String numInputOfUser = Utill.inputNum(); // 숫자 입력을 받는다.
        addNumber2userList(userList, numInputOfUser); // 입력을 받은 문자렬을 split을 한다음 userList에 추가를 한다. => [ 1, 2, 3]
    }

    /**
     * userList을 초기화 해주는 메서드
     */
    private void initUserList() {
        userList = new ArrayList<>();
    }

    /**
     * 입력 받은 문자열 "123"을 InputList에 1, 2, 3 을 추가한다.
     *
     * @param inputList      입력받는 문자열을 추가한 리스트 {1, 2, 3}
     * @param numInputOfUser 입력받는 문자열 "123"
     */
    private void addNumber2userList(List<Integer> inputList, String numInputOfUser) {
        String[] inputStrArr = new String[USER_INPUT_SIZE];

        inputStrArr = Utill.getSplitStrArr(numInputOfUser);
        Utill.makeListFromArr(inputList, inputStrArr);
    }

    /**
     * 3스트라이크가 되면 게임 진행을 위한 절차를 호출하는 메서드.
     *
     * @return
     */
    private boolean isNotProceedGame() {
        int inputInt = RESET_NUM;

        printSecondProcessMsg();
        inputInt = Utill.inputIntNum(); // 숫자를 입력받는다.
        ValidException.isValidOnlyInputOneTwo(inputInt); // 1과 2가 아니면 예외처리

        if (Utill.isSameInteger(inputInt, NOT_AGAIN_GAME)) {  // 입력 받는 숫자가 2이면 true - STOP
            return true;
        }

        // 5. 입력 받는 숫자가 1이면 - start
        return false;
    }

    /**
     * 2번째 게임 진행상황의 문자열을 출력한다.
     */
    private void printSecondProcessMsg() {
        System.out.println(MyConstants.MSG_END_GAME_COMMENT_STR()); // "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        System.out.println(MyConstants.MSG_GAME_PROGRESS_SELECTION_STATUS_STR()); // "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    }

    /**
     * 힌트를 출력해주는 메서드
     */
    private void printHintMsg() {
        System.out.println(hintOfJudge); // 힌트를 출력한다.
    }

    /**
     * 입력을 받기전 출력 문구 생성 "숫자를 입력해주세요 : "
     */
    private void printMsgBeforInputNum() {
        System.out.print(MyConstants.MSG_INPUT_NUMBER_STR());
    }
}
