package baseball;

public class GameOver {

    GameOver() {
    }

    public void print() { // 정답을 맞춘경우 처리하는 함수
        printGameOver();
    }

    void printGameOver() { // 정답을 맞춘경우 출력문을 출력하는 함수
        System.out.println("3스트라이크");
        System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
        System.out.print("게임 종료");
    }
}
