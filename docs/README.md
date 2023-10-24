# 숫자 야구 게임
이 프로젝트는 숫자 야구 게임을 구현한 어플리케이션입니다.

## 과제 정보
- 구현 언어: Java 17
- 라이브러리: camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 기능 목록
- 무작위로 생성된 3자리 숫자를 맞히는 숫자 야구 게임을 플레이합니다.
- 게임을 반복하여 새로 시작하거나 종료할 수 있습니다.
- 각 라운드에서 숫자를 입력하고 결과를 확인합니다.
- 스트라이크 및 볼 수를 표시하여 게임 진행 상황을 알 수 있습니다.
 
## 예제 입력
게임에서 숫자를 입력할 때 다음과 같은 형식을 사용하세요:

- "123" 또는 "456" 등 3자리 숫자를 입력합니다.
- 각 숫자는 1에서 9 사이의 정수여야 하고, 각 자리의 숫자가 달라야 합니다.

