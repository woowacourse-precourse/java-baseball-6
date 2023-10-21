package baseball;

import baseball.service.BaseBallService;

public class Application {
	public static void main(String[] args) {
		BaseBallService baseBallService = new BaseBallService();
		baseBallService.run();
	}
}
