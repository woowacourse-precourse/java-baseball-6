package baseball.domain;

public class Output {

    public boolean printResult(int[] result) {

        if (result[0] == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] == 0) {
            System.out.println(result[1] + "볼");
        } else if (result[1] == 0) {
            System.out.println(result[0] + "스트라이크");
        } else if (result[0] != 0 && result[1] != 0) {
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        }
        // false가 나오면 GameController에 Recursive 함수 중단.
        return result[0] < 3;
    }
}