package baseball;

public class BallCheck {

	public static int check(int[] coms_ball, int[] myball) {

		int bcnt = 0;

		for (int i = 0; i < coms_ball.length; i++) {
			if (check(myball, coms_ball[i], i)) {
				bcnt++;
			}
		}
		return bcnt;
	}

	private static boolean check(int[] arr, int val, int exval) {
		for (int i = 0; i < arr.length; i++) {
			if (i != exval && arr[i] == val) {
				return true;
			}
		}
		return false;
	}
}
