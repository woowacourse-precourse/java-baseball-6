package baseball;

public class Output {
    static final String startMessage = "숫자 야구 게임을 시작합니다.";
    static final String inputNumberMessage = "숫자를 입력해주세요 : ";
    static final String victoryMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String newGameOrGameEndMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    static void printStartMessage(){
        System.out.println(startMessage);
    }
    static void printInputNumberMessage(){
        System.out.println(inputNumberMessage);
    }
    static void printVictoryMessage(){
        System.out.println(victoryMessage);
    }
    static void printNewGameOrGameEndMessage(){
        System.out.println(newGameOrGameEndMessage);
    }

}
