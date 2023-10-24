package baseball;

import baseball.controller.BaseballGame;
import baseball.model.RetryNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        OutputView.printGameStart();
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        } while (askRetry());
    }

    public static boolean askRetry() {
        RetryNumber retryNumber = new RetryNumber(InputView.setRetryNumber());

        if (retryNumber.getRetryNumber().equals("1")) {
            return true;
        }

        return false;
    }

//        List<Integer> computer = new ArrayList<>();
//        while (computer.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
//            if (!computer.contains(randomNumber)) {
//                computer.add(randomNumber);
//            }
//        }
//        System.out.println(computer);

//        String tmp = Console.readLine();
//        System.out.println(tmp);

//        list = Randoms.pickUniqueNumbersInRange(1, 9, 3);
//        for (int i = 0; i < 3; i++) {
//            System.out.println(Randoms.pickNumberInList(list));
//        }
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Randoms.pickNumberInRange(1, 9));
//        }

//        System.out.println(list);
//        for (int i = 0; i < 3; i++) {
//            int temp = Randoms.P
//        }
//
//        Console.readLine()
//        Randoms.
//    }
}
