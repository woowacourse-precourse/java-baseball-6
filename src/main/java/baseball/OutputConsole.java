package baseball;

public class OutputConsole {
    public void printResult(int numOfBalls, int numOfStrikes){
        if (numOfBalls != 0 && numOfStrikes != 0){
            System.out.println(numOfBalls + "볼 " + numOfStrikes + "스트라이크");
        }
        else if (numOfBalls != 0 & numOfStrikes == 0){
            System.out.println(numOfBalls + "볼");
        }
        else if (numOfStrikes != 0) {
            System.out.println(numOfStrikes + "스트라이크");
        }
        else {
            System.out.println("낫싱");
        }
    }
    public void printInputForm(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printRegameMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printGameFinishedMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
