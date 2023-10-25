package baseball;

import baseball.service.BaseballGameService;

public class Application {
    public static void main(String[] args) {
        BaseballGameService baseballGameService = new BaseballGameService();

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean flag = true;
        int size = 3;
        while (flag) {
            baseballGameService.run(size);
            flag = baseballGameService.replay();
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
