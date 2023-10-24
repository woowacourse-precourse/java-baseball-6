package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class View{
    private static final String START_SENTENCE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
    private static final String RESTART_EXIT_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ANSWER_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void startMassage(){
        System.out.println(START_SENTENCE);
    }
    public void inputText(){
        System.out.print(INPUT_SENTENCE);
    }
    public void printHint(String message){
        System.out.println(message);
    }
    public void printEndGame(){
        System.out.println(ANSWER_SENTENCE);
    }
    public void printRestartOrExit(){
        System.out.print(RESTART_EXIT_SENTENCE);
    }

}