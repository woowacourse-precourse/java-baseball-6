# 개요

BaseballGameManager의 run()은 한 번의 게임을 실행한다.
게임의 시작, 반복, 종료는 Application이 관리한다.
BaseballGameManager는 싱글톤으로 관리하며, 게임 반복 시 공통적으로 사용되는 대표적인 필드를 private 멤버 변수로 선언해 재사용한다.
(재사용 목적: 메모리 절약, 가독성 향상, 변수 이름으로 프로젝트 전체 이해를 용이하게 함)

# 게임 반복 시 공통적으로 사용되는 필드
- 컴퓨터의 랜덤 숫자: List<Integer>
- 사용자의 입력 숫자: List<Integer>
- 사용자의 입력 숫자: Integer
- 두 랜덤 숫자 대조 후 결과(볼, 스트라이크): Map<String, Integer>
- 볼, 스트라이크 숫자 카운트: AtomicInteger

# 기능 구현 목록
## Role 1. 게임 전체 관리자 - Application
public
- [x] main(): 전체 게임 프로세스 관리 

private
- [x] endGame(): 게임 종료 의사 확인

## Role 2. 야구 게임 관리자 - BaseballManager
public
- [x] getInstance() 싱글톤 패턴 구현
- [x] run(): 한 번의 게임 실행 프로세스 관리

private
- [x] generateRandomNumber() 컴퓨터의 랜덤 숫자 생성
- [x] getUserInput() 사용자의 입력 받기(정답 맞추기 시도)
- [x] validateUserInput() 사용자의 입력 유효성 검사 
  - 중복 숫자 입력 유효성 검사 
  - 숫자 입력 범위 유효성 검사(1~9)
  - 3자리 숫자 유효성 검사
- [x] getBaseBallResult() 사용자의 입력에 대한 결과 평가
- [x] printResult() 야구 게임 결과 출력
- [x] isCorrect() 게임 종료 여부 확인


Application.main()과 BaseballGameManager.run()은 게임을 실행하기 위한 전체 프로세스를 관리하며, 보조 함수를 호출한다. 
보조 함수는 최대한 게임 프로세스를 이해하기 쉽도록 이름을 짓는다. 

# Exception 처리

**사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.**

아래는 야구 게임 프로그램에 사용된 Exception 목록이다. 
- NumberFormatException이 발생한 경우 IllegalArgumentException을 던진다. (문자열, 특수기호, 실수형 등을 입력한 경우)
- 사용자가 입력한 숫자가 3자리가 아닌 경우 IllegalArgumentException을 던진다.
- 사용자가 입력한 숫자가 1~9 범위가 아닌 경우 IllegalArgumentException을 던진다.
- 사용자가 입력한 숫자가 중복된 숫자가 있는 경우 IllegalArgumentException을 던진다.

# 기타
### Exception 종류
java.lang.Exception > java.lang.RuntimeException > java.lang.IllegalArgumentException
java.lang.Exception > java.lang.RuntimeException > java.util.NoSuchElementException > java.util.InputMismatchException

Scanner로 입력받을 때 잘못된 타입의 값이 입력되는 경우 InputMismatchException이 발생한다.
과제에서 요구한 IllegalArgumentException과의 상속 관계를 비교해 보니 java.lang과 java.util로 나뉜다는 것을 알 수 있었다.
두 패키지 모두 공통적으로 많이 사용되는 기본 패키지이며 다음과 같은 차이점이 있다. 

java.lang 패키지는 자바의 기본 패키지로 import 없이 사용할 수 있다.
java.util 패키지는 컬렉션 클래스들이 들어있고, import 해야 사용할 수 있다.



### 싱글톤 패턴
우아한 테크코스에서 제공한 camp.nextstep.edu.missionutils.Console 은 자바의 Scanner 클래스를 싱글톤 패턴으로 구현한 라이브러리이다.
하나의 프로세스에서 Scanner를 여러번 생성 해 사용하게 된다면 input Stream 을 여러개 열게 되어 메모리 낭비가 발생하며, 프로그램의 실행 플로우에 예상치 못한 문제를 야기한다. 
따라서 Scanner를 싱글톤 패턴으로 구현하여 프로세스 내에서 하나의 Scanner 객체만 생성하도록 한다.

마찬가지로 BaseballGameManager 또한 하나의 프로세스 내에서 야구 게임의 시작, 종료, 반복을 모두 관리하기 때문에 프로그램의 여러 곳에서 BaseballGameManager 객체를 생성할 필요가 없으므로, 이를 보장하기 위해 싱글톤 패턴으로 구현했다.

### 싱글톤 패턴의 특징
- 생성자를 private으로 선언하여 외부에서 new 키워드를 사용해 직접 객체를 생성할 수 없다.
- 자기 자신의 객체를 생성하여 static 변수에 저장한다.
- static 메서드를 통해 자기 자신의 객체를 반환한다. (ex. getInstance())
