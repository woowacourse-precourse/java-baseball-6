package baseball.application.process.container;

import baseball.application.process.ApplicationEndProcess;
import baseball.application.process.DetermineRestartProcess;
import baseball.application.process.GameEndProcess;
import baseball.application.process.GameInitProcess;
import baseball.application.process.GameProgressProcess;
import baseball.application.process.GameStartProcess;
import baseball.application.process.PlayerInputProcess;
import baseball.application.process.base.BaseballProcess;
import java.util.HashMap;
import java.util.Map;

public class ProcessContainer {

    private Map<String, BaseballProcess> map = new HashMap<>();

    public ProcessContainer() {
        map.put("gameStartProcess", new GameStartProcess());
        map.put("gameInitProcess", new GameInitProcess());
        map.put("playerInputProcess", new PlayerInputProcess());
        map.put("gameProgressProcess", new GameProgressProcess());
        map.put("gameEndProcess", new GameEndProcess());
        map.put("determineRestartProcess", new DetermineRestartProcess());
        map.put("applicationEndProcess", new ApplicationEndProcess());
    }

    public BaseballProcess get(String key) {
        return map.get(key);
    }
}
