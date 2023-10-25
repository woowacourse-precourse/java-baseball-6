package baseball;

public class CheckUtil {
	// checkSt가 true면 스트라이크 검사
	// checkSt가 False면 볼 검사
	public static int check(int[] coms_ball, int[] myball, boolean checkSt) {
		
		int count = 0;

		for (int i = 0; i < coms_ball.length; i++) {
			if ((checkSt && coms_ball[i] == myball[i])
					|| (!checkSt && DuplicateChecker.containsDuplicatesExcept(myball, coms_ball[i], i))) {
				count++;
			}
		}
		return count;
	}
}