package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int[] com = Creator.getComputer();
        int[] user;
        while (true) {
            Counter counter = new Counter();
            user = Creator.getUser();
            counter.checkCounts(com, user, counter);
            if (counter.isCorrect()) {
                if (Manager.restart()) {
                    com = Creator.getComputer();
                } else {
                    break;
                }
            }
        }
    }
}
