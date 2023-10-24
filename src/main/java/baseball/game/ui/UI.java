package baseball.game.ui;

import camp.nextstep.edu.missionutils.Console;

public enum UI {
	START {
		@Override
		public void print(int ... values) {
			System.out.println("숫자 야구 게임을 시작합니다.");
		}
	},
	INPUT {
		@Override
		public void print(int ... values) {
			System.out.print("숫자를 입력해주세요 : ");
		}
	},
	END {
		@Override
		public void print(int ... values) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		}
	},
	NEW_GAME {
		@Override
		public void print(int ... values) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		}
	},
	RESULT {
		@Override
		public void print(int ... values) {
			this.print(values[0], values[1]);
		}

		void print(int strikeCount, int ballCount) {
			StringBuilder sb = new StringBuilder();
			if (ballCount > 0) {
				sb.append(ballCount).append("볼 ");
			}
			if (strikeCount > 0) {
				sb.append(strikeCount).append("스트라이크");
			}
			if (sb.isEmpty()) {
				sb.append("낫싱");
			}
			System.out.println(sb);
		}

	};

	public abstract void print(int ... values);

	public static String input() {
		return Console.readLine();
	}
}
