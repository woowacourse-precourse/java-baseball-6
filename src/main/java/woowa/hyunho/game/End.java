package woowa.hyunho.game;

import woowa.hyunho.messages.Messages;
import woowa.hyunho.utilities.Parse;
import woowa.hyunho.handler.Selector;

public class End {
	int selectorNumber;
	
	public int endProcess() {
		printEndMessages();
		getSelector();
		return selectorNumber;
	}
	
	private void printEndMessages() {
		Messages.askRestart();
	}
	
	private void getSelector() {
		Selector selector = new Selector();
		String num = selector.selectorNumberHandler();
		selectorNumber = Parse.parseStringToInt(num);
	}
	
}