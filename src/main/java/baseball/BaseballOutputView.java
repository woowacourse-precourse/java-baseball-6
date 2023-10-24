package baseball;

public class BaseballOutputView {
    // 게임 시작 메세지
    public void outputGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 판정 결과 출력 - 볼, 스트라이크, 낫싱
    public void outputCount(int count) {
        System.out.print(count);
    }

    public void outputResultBallWithoutStrike() {
        System.out.println("볼");
    }

    public void outputResultBallWithStrike() {
        System.out.print("볼 ");
    }

    public void outputResultStrike() {
        System.out.println("스트라이크");
    }

    public void outputResultNothing() {
        System.out.println("낫싱");
    }

    // 게임 종료 메세지
    public void outputFinishGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
