# 🌟 구현할 기능 목록 🌟

## `User` 입력 기능

- 게임에서 `숫자를 입력해주세요 : ` 문구가 출력되면, `User`는 3자리 숫자를 입력한다.
- 게임 종료 조건이 충족되면, `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 문구가 출력되고, 사용자는 다음 줄에서 `1` 또는 `2`를 입력한다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 사용자가 잘못된 값을 입력할 경우, `GameManager`가 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - 이때 `GameManager`의 `ValidateUserInput`과 `ValidateUserInputForRestartGame` 메서드를 활용한다.

## 게임 코어 플레이(숫자 Guess Stage) 기능

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
    - `Computer`의 `judgeUserGuess` 메서드를 활용한다.
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다.
    - `Computer` 클래스를 활용한다.
- 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
    - `Computer`의 `GenerateRandomNumbers` 메서드를 활용한다.
- `User`는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
    - `User`의 `getConsoleInput()`과 `Computer`의 `printUserGuessJudgmentResult` 메서드를 활용한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
    - `GameManager`의 `checkGameEnd` 메서드를 활용한다.
