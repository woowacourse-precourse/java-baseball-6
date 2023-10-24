### 기능 요구사항

- 같은 수가 같은 자리에 있으면 **스트라이크**, 다른 자리에 있으면 **볼**, 없으면 **낫싱**
- 힌트를 이용하여 먼저 상대방의 수를 맞추면 승리한다.
- 컴퓨터는 **1에서 9까지 서로 다른 3개의 임의의 숫자를 선택**한다.
- 플레이어는 **서로 다른 3개의 숫자를 입력**하고 결과를 출력한다.
- 이 과정을 반복하여 숫자를 모두 맞히면 게임이 종료된다.
- **게임 종료 후 다시 시작하거나 완전히 종료할 수 있다.**
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다.

### 기능 목록

- 컴퓨터가 난수를 생성하는 기능 (o)
    - 난수 생성이 1 ~ 9 범위를 가지는지 고려한다. (o)
    - 난수가 3자리인지 고려한다. (o)
- 생성한 난수와 사용자의 수를 비교하는 기능 o)
    - 사용자의 수가 1~9 범위의 3자리 정수인지 확인한다. (o)
    - 생성한 난수가 1~9 범위의 3자리 정수인지 확인한다. (o)
- 생성한 난수와 사용자의 수를 비교하여 힌트를 주는 기능 (o)
    - 사용자의 수가 1~9 범위의 3자리 정수인지 확인한다. (o)
    - 생성한 난수가 1~9 범위의 3자리 정수인지 확인한다. (o)
    - 비교할 때, 볼, 스트라이크 순서로 제공하는지 확인한다. (o)

### 제약사항

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다. (o)
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
    
    ```java
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < 3) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
    ```