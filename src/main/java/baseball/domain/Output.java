package baseball.domain;

public class Output {

    public boolean printResult(int[] result) {

        if (result[0] == 3) {
            System.out.println("3스트라이크");
        } else if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] == 0) {
            System.out.println(result[1] + "볼");
        } else if (result[1] == 0) {
            System.out.println(result[0] + "스트라이크");
        } else if (result[0] != 0 && result[1] != 0) {
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        }
        return result[0] == 3;
    }
}