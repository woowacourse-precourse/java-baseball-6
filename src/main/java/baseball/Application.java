package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean endToggle = true;

        final int numOfNumbers = 3;

        ComputerNumbers computerNumbers = new ComputerNumbers();

        RandomPickNumberService randomPickNumbers = new RandomPickNumberService(computerNumbers);

        randomPickNumbers.randomPick(numOfNumbers);

        PlayerNumbers playerNumbers = new PlayerNumbers();

        ReadPlayerNumberService readPlayerNumberService = new ReadPlayerNumberService(playerNumbers);

        readPlayerNumberService.readPlayerNumber(numOfNumbers);

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(computerNumbers.getList());
        System.out.println(playerNumbers.getList());

    }


}
