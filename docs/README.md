# 야구 게임

### 구현할 기능 목록

- 컴퓨터
    - 1~9까지 서로 다른 임의의 수 3개를 랜덤으로 생성
        - `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용
            - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
            - 사용 예시

                ```java
                List<Integer> computer = new ArrayList<>();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
                ```

- 사용자
    - 사용자 입력
        - 게임중
            - 1~9까지 서로 다른 수로 이루어진 3자리만 입력 가능
        - 게임끝
            - 1 또는 2만 입력 가능
        - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
        - 입력 예외
            - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생 시키고 앱을 종료
    - 야구 로직
        - 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트
- 게임
    - 시작
    - 종료

### 요구사항

- Java 코드 컨벤션
    - 블럭 들여쓰기: +4 스페이스
    - 열 제한: 120
    - 들여쓰기 지속은 최소 +8 스페이스
        - 줄 바꿈 시 그 다음 줄은 원래 줄에서 +8 이상 들여씁니다.
    - 수직 빈 줄
        - 빈 줄은 가독성을 향상시키기 위해서라면 어디든(예를 들면 논리적으로 코드를 구분하기 위해 문장 사이) 사용 될 수 있습니다. 클래스의 첫 번째 멤버나 초기화(initializer) 또는 마지막 멤버 또는 초기화( initializer) 뒤의 빈 줄은 권장되지도 비권장하지도 않습니다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.