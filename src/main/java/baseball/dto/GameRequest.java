package baseball.dto;

import java.util.List;

public record GameRequest(String cmd, List<String> args) {
}
