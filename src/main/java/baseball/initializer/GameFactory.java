package baseball.initializer;

import baseball.utils.input.Selector;
import baseball.utils.viewer.Viewer;

public interface GameFactory {

    Viewer getViewer();

    Selector getSelector();
}
