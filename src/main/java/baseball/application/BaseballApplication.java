package baseball.application;

import baseball.application.config.BaseballConfig;
import baseball.application.config.IoConfig;
import baseball.application.context.BaseballContext;
import baseball.application.context.IoContext;
import baseball.application.process.base.BaseballProcess;
import baseball.application.process.container.ProcessContainer;

public class BaseballApplication {

    private final BaseballContext baseballContext;
    private final IoContext ioContext;
    private final ProcessContainer processContainer = new ProcessContainer();

    public BaseballApplication(BaseballConfig baseballConfig, IoConfig ioConfig) {
        this.baseballContext = new BaseballContext(baseballConfig);
        this.ioContext = new IoContext(ioConfig);
    }

    public void play() {
        BaseballProcess process = processContainer.get("gameStartProcess");
        while(process.hasNext()) {
            process.execute(baseballContext, ioContext);
            process = processContainer.get(process.next());
        }
    }
}
