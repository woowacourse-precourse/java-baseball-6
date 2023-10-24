## 🚀 기능 요구 사항

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한
  숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

***

## 기능 요구사항 및 체크리스트 정리

### 1. 문제풀이 기본 요구사항 정리

✅ 1~9 사이의 서로 다른 임의의 수 3개를 정하는 setRandomDistinctNumbers() 메소드 구현

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.

✅ 게임 시작 문구를 출력하는 startGame() 메소드 구현  
✅ 게임을 끝난 후, 종료할 것인지 묻는 confirmGameEnd() 메소드 구현

- 3개를 모두 맞추면 게임을 종료하거나 다시 진행해야 한다.

✅ 두 수의 자리를 비교하는 compareDigitNumbers() 메소드 구현  
✅ 서로 다른 자리를 갖고 있지만 겹치는 숫자의 개수를 세는 countCommonNumbers() 메소드  
✅ 비교 결과에 따라 볼, 스트라이크, 낫싱을 출력하는 showBaseballOutcome() 메소드 구현  
✅ 예외 1번~3번을 처리하는 checkInputValidation() 메소드 구현  
✅ 예외 4번을 처리하는 checkExitChoiceValidation() 메소드 구현

### 2. 예외처리 

1. 숫자가 아닌 다른 문자열을 입력한 경우 (빈 문자열 포함)
2. 중복된 숫자값이 있는 경우
3. 입력받은 숫자의 값이 3자리가 아닌 경우
4. 게임이 끝난 경우, 재시작/종료를 구분하는 1과 2숫자 외의 다른 문자열 (빈 문자열 포함)  

### 3. 리팩토링  
1. countCommonNumbers() 메소드 이름을 countBall() 로 변경
2. compareDigitNumbers() 메소드 이름을 countStrike() 로 변경
3. String 변수를 arrayList로 변환하는 convertToList() 메소드 추가 구현
4. 게임을 진행하는 playNumberBaseballGame() 메소드 추가 구현
 
### 4. 수정사항
1. checkInputValidation() 메소드의 테스트 코드 실패 후, 예외처리 1번 경우에 대한 로직 수정
