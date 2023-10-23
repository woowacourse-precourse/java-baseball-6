package baseball;

public class BallCheck {

	public static int check(int[] coms_ball, int[] myball) {

		int bcnt = 0;

		for (int i = 0; i < coms_ball.length; i++) {
			if (DuplicationCheck.hasDuplicatesExcept(myball, coms_ball[i], i)) {
				bcnt++;
			}
		}
		return bcnt;
	}
}
