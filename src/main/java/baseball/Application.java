package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean endToggle = true;

        ComputerNumbers computerNumbers = new ComputerNumbers();

        RandomPickNumbers randomPickNumbers = new RandomPickNumbers(computerNumbers);

        randomPickNumbers.randomPick(3);

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(computerNumbers.getComputer());

    }


}
