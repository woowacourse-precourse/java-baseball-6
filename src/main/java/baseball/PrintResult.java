package baseball;

public class PrintResult {

	public void print(int[] result) {
		if (result[0] == 0 && result[1] == 0) {
			System.out.println("낫싱");
		} else if (result[0] == 0) {
			System.out.println(result[1] + "스트라이크");
		} else if (result[1] == 0) {
			System.out.println(result[0] + "볼");
		} else {
			System.out.println(result[0] + "볼" + " " + result[1] + "스트라이크");
		}
	}
}
