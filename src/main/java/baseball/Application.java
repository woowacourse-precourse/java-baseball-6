package baseball;

public class Application {
    public static void main(String[] args) {
        ComNumber comNumber = new ComNumber();
        comNumber.pickNumbers();
        PlayerNumber playerNumber = new PlayerNumber();
        CompareNumbers compareNumbers = new CompareNumbers();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            playerNumber.input();

            String result = compareNumbers.compare(comNumber, playerNumber);
            System.out.println(result);
            if ("3스트라이크".equals(result)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
