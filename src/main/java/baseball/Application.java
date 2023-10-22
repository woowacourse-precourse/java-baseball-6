package baseball;

import baseball.controller.BaseballController;


public class Application {
	// 게임 시작
	public static void main(String[] args) {
		BaseballController baseballController = BaseballController.getInstance();
		baseballController.runGame();
	}
	
//	public static class Baseball {
//		private final static int MAX_DIGIT = 3;
//		private Counter counter = new Counter(); 
//		// 게임 진행
//		public void play() {
//			List<Integer> computer = randomNumberGenerate();
//			String userInput = ""; // 사용자가 입력한 값을 받음.
//
//			while (true) {
//				this.counter = new Counter();
//				System.out.print("숫자를 입력해주세요 : ");
//				userInput = Console.readLine();
//				exceptionHandling(userInput);
//				compare(computer, userInput);
//				System.out.println(userInput);
//				showResults();
//				if (threeStrike())
//					break;
//			}
//		}
//
//		// 예외 처리
//		public void exceptionHandling(String userInput) {
//			int inputLength = userInput.length();
//
//			if(inputLength != MAX_DIGIT)
//				throw new IllegalArgumentException();
//
//			Set<Character> set = new HashSet<>();
//			for(int i = 0; i < inputLength; i++) {
//				char digit = userInput.charAt(i);
//				// 1~9 사이 수가 아니라면
//				if (digit < '1' || digit > '9')
//					throw new IllegalArgumentException();
//
//				set.add(digit);
//			}
//			// 길이 조건 3자리 및 중복 검사
//			if(set.size() != MAX_DIGIT)
//				throw new IllegalArgumentException();
//		}
//
//		// 랜덤 3자리 번호 생성
//		public List<Integer> randomNumberGenerate() {
//			List<Integer> computer = new ArrayList<>();
//
//			while(computer.size() < MAX_DIGIT) {
//				int randomNumber = Randoms.pickNumberInRange(1, 9);
//				if (!computer.contains(randomNumber))
//					computer.add(randomNumber);
//			}
//
//			return computer;
//		}
//
//		// 컴퓨터와 사용자 숫자 비교 함수
//		public void compare( List<Integer> computer, String userInput) {
//			for(int i = 0; i < computer.size(); i++) {
//				int computerNumber = computer.get(i);
//				int userNumber = Integer.valueOf(userInput.charAt(i)) - '0';
//
//				if (computerNumber == userNumber)
//					this.counter.strikeCount++;
//				else if (computer.contains(userNumber))
//					this.counter.ballCount++;
//			}
//		}
//
//		// 결과 보여주기
//		public void showResults() {
//			int strikeCount = this.counter.strikeCount;
//			int ballCount = this.counter.ballCount;
//
//			StringBuffer result = new StringBuffer();
//			if (ballCount == 0 && strikeCount == 0) {
//				result.append("낫싱");
//			} else {
//				if (ballCount != 0) {
//					result.append(ballCount + "볼 ");
//				}
//				if (strikeCount != 0)
//					result.append(strikeCount + "스트라이크");
//			}
//
//			System.out.println(result.toString().trim());
//		}
//
//		// 종료 조건
//		public Boolean threeStrike() {
//			int strikeCount = this.counter.strikeCount;
//
//			if (strikeCount == MAX_DIGIT) {
//				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//				return true;
//			}
//			return false;
//		}
//
//		// 재시작 종료 분기
//		public Boolean quit() {
//			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//
//			String userInput = Console.readLine();
//
//			if (userInput.equals("1")) {
//				return false;
//			} else if (userInput.equals("2")) {
//				System.out.println("게임을 종료합니다");
//				return true;
//			} else {
//				throw new IllegalArgumentException();
//			}
//		}
//
//	}
}

