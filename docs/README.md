

## 기능 요구사항
1. 기본적으로 1부터 9까지 "서로 다른 수"로 이루어진 3자리의 수를 맞추는 게임이다.
   -> 즉 0이 들어가지 않음 + 중복 불가.
2. 조건
    * 스트라이크 : 같은 수 같은 자리
    * 볼 : 같은 수 다른 자리
    * 낫싱 : 다른 수 다른 자리
3. 사용자가 답을 맞출 때까지 입력하는 동작 방식.
   -> 답을 맞추면 사용자는 종료(1), 재도전(2)할 수 있음
   -> 옳지 않은 답 입력시 즉시 IllegalArgumentException을 발생		
   (예를 들어 3자리의 정수가 아닌 수, 문자형 등)

    
---

## 입출력 요구사항
* 입력
    * 서로 다른 3자리의 수
    * 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

* 출력
  : 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
  ex1) 1볼 1스트라이크
  ex2) 맞는 수가 하나도 없는 경우
  -> 낫싱
  ex3) 3개의 숫자를 모두 맞춘 경우
  -> 3스트라이크
  ->3개의 숫자를 모두 맞히셨습니다! 게임 종료
  ex4) 시작문구 출력
  ->숫자 야구 게임을 시작합니다.

---


## 프로그래밍 요구사항
1. 외부 라이브러리 사용금지
2. JAVA 코드 컨벤션 가이드를 준수할 것!!(아주중요)
3. 프로그램 종료 시 System.exit()를 호출하지 않는다.
4. 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. (테스트가 실패할 경우 0점 처리한다.)

---

## 라이브러리

: camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
* Random 값 추출
:  camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
* 사용자가 입력하는 값
: camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

사용예시
```
코드를 List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```

---

## 함수설명

아래 코드는 숫자 야구 게임을 구현한 Application 클래스입니다. 주요 기능과 메서드에 대한 설명은 다음과 같습니다:

### 1. main 메서드
: 프로그램 실행 진입점입니다. 아래 기능들을 반복하여 수행합니다.

1. Game 객체 생성 및 초기화
   : Game 클래스에서 제공되는 메서드를 사용하여 게임 객체를 생성하고, 랜덤한 정답을 설정합니다.

2. 사용자 입력 받기
   : Console.readLine() 메서드를 사용하여 사용자로부터 세 자리 수를 입력받습니다.

3. 유효성 검사 및 처리:
* checkCorrectInput 메서드 호출: 사용자가 올바른 형식(세 자리 수인지, 숫자인지 등)으로 입력했는지 확인합니다.
* game.judgeGame() 호출 및 결과 저장: Game 객체의 judgeGame() 메서드를 호출하여 사용자가 추측한 수와 실제 정답 사이의 비교 결과(judge 값)를 반환받아 저장합니다.
4. 성공 여부 확인:
* 성공(SUCCESS)일 경우:
  : 축하 메시지 출력 후, 게임 재시작 여부 확인 메시지 출력
  * 재시작 여부(GAME_RESTART) 받기: 다시 시작할 것인지 종료할 것인지 사용자에게 선택권을 제공합니다.
  * 유효성 검사 및 처리:
  * checkCorrectRestart_Input() 호출: 재시작 여부 값이 올바른 범위 내(1 또는 2)에 있는지 확인합니다.
  * 재시작(GAME_RESTART)일 경우, 새로운 정답 생성 (game.createAnswer())
  * 반복적으로 위 과정 실행

5. 유틸리티 메서드:
* checkCorrectInput: 사용자가 올바른 형식으로 세 자리 수(숫자만 포함된 문자열)를 입력했는지 검사하는 메서드입니다. 만약 조건에 어긋나면 예외(IllegalArgumentException)가 발생됩니다.
* checkCorrectRestart_Input: 재시작 여부 값이 올바른 범위 내(1 또는 2)에 있는지 확인하는 유틸리티 메소드입니다. 그렇지 않으면 예외(IllegalArgumentException)가 발생됩니다.  

---

### 2. Game 클래스
:  Game 클래스는 숫자 야구 게임의 주요 로직을 담고 있습니다. 주요 기능과 메서드에 대한 설명은 다음과 같습니다.

* judgeGame 메서드: 사용자가 입력한 수와 정답을 비교하여 결과를 판정합니다.
    * num: 사용자가 입력한 세 자리 수
    * strike: 현재 판정 중인 수의 스트라이크 개수
    * ball: 현재 판정 중인 수의 볼 개수
* createAnswer 메서드: 랜덤하게 세 자리 정답을 생성합니다.
    * Randoms.pickNumberInRange(min, max): 주어진 범위 내에서 랜덤한 숫자를 선택하는 유틸리티 메서드입니다.
* makePrintln 메서드: 스트라이크와 볼 개수에 따라 결과를 출력합니다

