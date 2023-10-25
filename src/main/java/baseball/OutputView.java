package baseball;

public class OutputView {

	private OutputView() {
	}

	public static void print(PrintMessage message) {
		System.out.print(message.getMessage());
	}

	private static void print(Integer message) {
		System.out.print(message);
	}

	public static void print(Result result) {
		if (result.isNothing()) {
			print(PrintMessage.NOTHING);
			print(PrintMessage.ENTER);
			return;
		}

		if (result.getCount(ResultKind.BALL)>0 && result.getCount(ResultKind.STRIKE) > 0) {
			print(result.getCount(ResultKind.BALL));
			print(PrintMessage.BALL);
			print(PrintMessage.SPACE);
			print(result.getCount(ResultKind.STRIKE));
			print(PrintMessage.STRIKE);
			print(PrintMessage.ENTER);
			return;
		}

		if (result.getCount(ResultKind.BALL)>0) {
			print(result.getCount(ResultKind.BALL));
			print(PrintMessage.BALL);
			print(PrintMessage.ENTER);
			return;
		}

		if (result.getCount(ResultKind.STRIKE) > 0) {
			print(result.getCount(ResultKind.STRIKE));
			print(PrintMessage.STRIKE);
			if (result.isSize(ResultKind.STRIKE, 3)) {
				print(PrintMessage.ENTER);
				print(PrintMessage.SUCCESS);
			}
			print(PrintMessage.ENTER);
		}
	}
}
