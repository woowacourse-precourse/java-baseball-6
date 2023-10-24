package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		Message.getStartMsg();
		Computer alice = new Computer();
		Room.gameStart(alice);
	}
}

class Room{
	private static final int SIZE = 3;
	public static void gameStart(Computer alice){
		User coh = new User();
		String userInput = coh.getUserInput();
		Computer.checkResult(userInput, alice);
		Message.makeMessage(alice.baseballFlag);
		if (alice.baseballFlag[0] != SIZE){
			gameStart(alice);
			return;
		}
		Message.getSuccessMsg();
		Message.newGameMsg();
		if (User.newGameFlag() == 1){
			Computer newGame = new Computer();
			gameStart(newGame);
		}
	}
}

class Computer {
	private static final int SIZE = 3;
	int[] baseballFlag = {0, 0};
	int[] numbers = new int[SIZE];
	Computer() {
		int randomNumber;
		for (int i = 0; i < SIZE;){
			randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!isDup(numbers, randomNumber))
				numbers[i++] = randomNumber;
		}
	}
	public static boolean isDup(int[] numberOfArr, int randomNumber){
		//Make Code About check duplication.
		for (int number : numberOfArr){
			if (randomNumber == number)
				return true;
		}
		return false;
	}

	public static void checkResult(String userInput, Computer alice){
		int tempNumber;
		alice.baseballFlag[0] = 0;
		alice.baseballFlag[1] = 0;
		for (int i = 0; i < SIZE; i++){
			tempNumber = Integer.parseInt(userInput.charAt(i) + "");
			updateFlag(tempNumber, i, alice);
		}
	}

	private static void updateFlag(int userInput, int digit, Computer alice){
		for (int currentDigit = 0; currentDigit < SIZE; currentDigit++){
			if (digit == currentDigit && userInput == alice.numbers[currentDigit]) {
				alice.baseballFlag[0] += 1; // strike
				return;
			}
			if (digit != currentDigit && userInput == alice.numbers[currentDigit]) {
				alice.baseballFlag[1] += 1; // ball
				return;
			}
		}
	}
}

class Message {
	private static final String strike = "스트라이크";
	private static final String ball = "볼";
	private static final String nothing = "낫싱";
	private static final String startMsg = "숫자 야구 게임을 시작합니다.%n";
	private static final String inputMsg = "숫자를 입력해 주세요 : ";
	private static final String success = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String newGame = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
	public static void makeMessage(int[] flag){
		String message = "";
		if (flag[1] > 0)
			message += flag[1] + ball;
		if (flag[1] > 0 && flag[0] > 0)
			message += " ";
		if (flag[0] > 0)
			message += flag[0] + strike;
		if (flag[1] <= 0 && flag[0] <= 0)
			message += nothing;
		System.out.println(message);
	}
	public static void getSuccessMsg(){
		System.out.println(success);
	}
	public static void inputMsg(){
		System.out.print(inputMsg);
	}
	public static void newGameMsg(){
		System.out.println(newGame);
	}
	public static void getStartMsg(){
		System.out.printf(startMsg);
	}
}

class User {
	private static final int INPUT_SIZE = 3;
	private static final int FLAG_SIZE = 1;
	public String getUserInput(){
		Message.inputMsg();
		String userInput = Console.readLine();
		if (!isLenError(userInput, INPUT_SIZE))
			throw new IllegalArgumentException("Invalid Length: " + userInput);
		if (!isWordError(userInput))
			throw new IllegalArgumentException("Word error is occurred : " + userInput);
		if (!isDupError(userInput))
			throw new IllegalArgumentException("Duplication Error is occurred : " + userInput);
		return userInput;
	}
	static public int newGameFlag(){
		String userInput = Console.readLine();
		int num;
		if (!isLenError(userInput, FLAG_SIZE))
			throw new IllegalArgumentException("Invalid Length: " + userInput);
		if (!isWordError(userInput))
			throw new IllegalArgumentException("Word error is occurred : " + userInput);
		num = Integer.parseInt(userInput);
		if (num < 1 || 2 < num)
			throw new IllegalArgumentException("range error is occurred : " + num);
		return num;
	}
	static private boolean isLenError(String input, int size){
		return input.length() == size;
	}

	static private boolean isWordError(String input){
		char word;
		for(int i = 0; i < input.length(); i++) {
			word = input.charAt(i);
			if(!Character.isDigit(word))
				return false;
		}
		return true;
	}

	static private boolean isDupError(String input){
		int[] tempArr = new int[INPUT_SIZE];
		int tempNumber;
		for (int i = 0; i < INPUT_SIZE; i++){
			tempNumber = Integer.parseInt(input.charAt(i) + "");
			if (Computer.isDup(tempArr, tempNumber))
				return false;
			tempArr[i] = tempNumber;
		}
		return true;
	}
}