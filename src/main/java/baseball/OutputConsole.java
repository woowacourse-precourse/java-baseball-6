package baseball;

public class OutputConsole {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String PREDICTIONINPUTFORM = "숫자를 입력해주세요 : ";
    private static final String STARTMESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String REGAMEMESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAMEFINISHEDMESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printResult(int numOfBalls, int numOfStrikes){
        if (numOfBalls != 0 && numOfStrikes != 0){
            System.out.println(numOfBalls + BALL + " " + numOfStrikes + STRIKE);
        }
        else if (numOfBalls != 0 & numOfStrikes == 0){
            System.out.println(numOfBalls + BALL);
        }
        else if (numOfStrikes != 0) {
            System.out.println(numOfStrikes + STRIKE);
        }
        else {
            System.out.println(NOTHING);
        }
    }
    public void printInputForm(){
        System.out.print(PREDICTIONINPUTFORM);
    }

    public void printStartMessage(){
        System.out.println(STARTMESSAGE);
    }

    public void printRegameMessage(){
        System.out.println(REGAMEMESSAGE);
    }

    public void printGameFinishedMessage(){
        System.out.println(GAMEFINISHEDMESSAGE);
    }
}
