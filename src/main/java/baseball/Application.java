package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Human human = new Human();
        Computer computer = new Computer();

        computer.setNumbers();

        int endFlag = 0;

        do {
            Judger judger = new Judger();

            human.setNumbers();

            judger.compareNumbers(human.getNumbers(), computer.getNumbers());

            if(endFlag == 1) {
                computer.setNumbers();
                endFlag = 0;
            }
        } while (endFlag != 2);
    }
}
