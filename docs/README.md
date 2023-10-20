# :beginner: 우아한테크코스 프리코스 1주차 : 숫자 야구

## 목차

- [1. 구현 기능 목록](#ballotboxwithcheck-구현-기능-목록) <br/>
- [2. 문제 해결 과정](#bookmark_tabs-문제-해결-과정)
  - [2.1 ❓ MVC 패턴을 사용한 이유](#-mvc-패턴을-사용한-이유)
  - [2.2 🤔 인터페이스 사용에 대한 고민](#-인터페이스-사용에-대한-고민)
  - [2.3 🚧 getter의 사용을 지양해라?](#-getter의-사용을-지양해라-)
  - [2.4 ⚙️ 일급 컬렉션](#-일급-컬렉션)
- [3. 다음 미션에 적용할 학습 내용](#ledger-다음-미션에-적용할-학습-내용) <br/>

# :ballot_box_with_check: 구현 기능 목록
- [ ] controller Package
  - [ ] BaseballGameController
    - view Package와 domain Package의 데이터를 전달하며 값을 출력하는 클래스
    - 프로그램을 실행하는 run 메서드
    - UserBaseballNumber객체를 반환하여 사용자의 입력값을 받아오는 loadUserValues 메서드
    - user의 숫자 입력값에 따라 ConsoleOutput의 메서드를 출력하는 showGameResult 메서드
    - 게임이 종료됐는지 체크하는 checkGameResult 메서드
    - 게임 종료 후 다음 게임의 상태값에 따른 결과를 실행하는 requestGameChoice 메서드
    

- [ ] domain Package
  - [ ] UserBaseballNumber
    - 게임을 위해 입력한 숫자에 대해서 유효성 검사와 값의 반환을 담당하는 일급 컬렉션
    - 입력한 값이 3자리인지 확인하는 validate 메서드
    - 입력값에 중복된 값이 있는지 확인하는 validateDuplicate 메서드
    - 입력값을 꺼낼 수 있는 getUserValues 메서드
  - [ ] RequestUserChoice
    - 게임 종료 후 다음 게임의 상태값을 정하는 클래스
    - 입력값이 1 혹은 2가 맞는지 확인하는 validate 메서드
    - user가 선택한 값을 반환하는 getUserChoice 메서드
  

- [ ] handler Package
  - [ ] InputHandler
    - view Package의 ConsoleInput의 확장성과 변경 용이성을 위한 인터페이스
    - inputUserValue 메서드의 추상화
    - inputGameResult 메서드의 추상화
  - [ ] OutputHandler
    - view Package의 ConsoleOutput의 확장성과 변경 용이성을 위한 인터페이스
    - printGameResult 메서드의 추상화
    - printGameStart 메서드의 추상화
  - [ ] ErrorHandler
    - Enum 클래스를 활용하여 프로그램에서 발생하는 에러 코드들을 관리하는 클래스
    - ErrorMessage와 함께 IllegalArgumentException 예외를 발생시키는 getException 메서드
  

- [ ] service Package
  - [ ] BaseballGameService
    - 숫자 야구 게임에 대한 비즈니스 로직을 담당하는 클래스
    - 입력한 숫자와 컴퓨터의 숫자가 얼마나 일치하는지 비교하는 compareNumber 메서드
    

- [ ] view Package
  - [ ] ConsoleInput
    - 입력을 담당하는 클래스
    - 서로 다른 3개의 수를 입력받는 inputUserValue 메서드 구현
    - 게임 종료 후 다음 게임의 상태를 결정하는 inputGameResult 메서드 구현
  - [ ] ConsoleOutput
    - 출력을 담당하는 클래스
    - 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시하고 하나도 없는 경우 낫싱, 3개의 숫자를 모두 맞힐 경우 3개의 숫자를 모두 맞히셨습니다! 게임 종료를 보여주는 printGameResult 메서드 구현
    - 게임 시작 문구를 출력하는 printGameStart 메서드 구현

# :bookmark_tabs: 문제 해결 과정

## ❓ MVC 패턴을 사용한 이유

🔹 객체 지향적인 코드를 작성하기 위해 가장 많은 시간을 들였던 부분이다. 첫날에는 기능 목록과 프로젝트의 구조를 생각하다 보니 코드를 작성하지 못하고 하루를 보내게 되었다. 코드를 작성하고 싶은 조바심이 들었지만 아직 1주차 이므로 남은 3주 동안 미션을 진행하며 학습한다면 이런 조바심이 해결될 수 있다고 생각했다.

객체 지향 프로그래밍은 부품 즉, 객체들이 독립적이기 때문에 코드의 변경이 용이하고 코드의 재사용성이 좋아 확장성이 좋아진다는 장점이 있다. 또한 코드에 문제가 생긴다면 컴퓨터가 문제가 생겼을 때 전체를 교체하지 않고 부품만 교체하는 것 처럼 독립적인 객체만 수정할 수 있기 때문에 코드의 유지보수가 용이하다는 장점을 갖는다. 이러한 장점을 가진 객체지향을 코드로 표현하기 위해서는 어떤 방법이 있을까 고민을 한 결과 MVC 패턴을 활용하기로 했다. 

controller는 비즈니스 로직이 들어가지 않고 domain과 view 사이의 정보를 전달하기 위해 service 혹은 domain을 호출하는 역할로 구조를 생각했다. 또한 Application 클래스를 활용한다면 객체들 간의 직접적인 결합을 피하고, 느슨한 관계 설정을 통해 보다 유연하고 변경이 용이한 프로그램을 설계할 수 있다고 생각했다.

domain의 경우 본래는 비즈니스 로직과 데이터를 관리하고 제어하는 역할을 하지만, 이번 경우에는 domain 부분의 역할을 분담하기 위해 service에서 비즈니스 로직을 담당하고 domain은 데이터의 유효성 검사, 저장 등을 처리하도록 했다.

-> 🔹 이 부분은 아직까지 고민 중인 부분이다. domain에서 로직과 유효성 검사 등 모든 부분을 담당할지 service Package를 둬야 할지는 코드를 작성해 보면서 고민을 해보고 미션이 끝난 후에는 피어 리뷰 시스템을 통해서 다른 분들의 의견을 듣고 다음 미션에 적용해야겠다고 생각했다.  

service는 domain 객체와 엔티티를 활용하여 비즈니스 로직을 구현하고 제공하는 역할로 구조를 생각했다.

handler를 통해서는 여러 가지 예외 상황 혹은 요청을 처리할 수 있도록 구현했다.

view 역시 input의 경우 값을 입력받는 역할만 할 수 있도록 구현하고, output도 출력만 구현할 수 있도록 구현했다.

## 🤔 인터페이스 사용에 대한 고민

🔹 인터페이스는 확장성과 변경 용이성의 이유로 사용했다. 하지만, 매번 추상화와 확장성을 고민하며 관리하다 보면 오버엔지니어링이 될 수 있다는 말에 다른 분들과 피드백을 주고받으며 더 생각해 봐야 하는 문제인 것 같다.

## 🚧 getter의 사용을 지양해라?

🔹 학습을 하다 보면 getter와 setter의 사용을 지양하라는 부분을 많이 보게 된다. setter의 경우는 명확하게 객체의 상태 값을 변경할 수 있기 때문에 지양해야 한다는 부분은 이해했지만 getter는 왜 포함되는지 이 부분이 궁금했다. 

이유는 크게 두가지에 대해서 생각을 해봤다. 

1. getter는 편리한 메서드이기 때문에 남발할 가능성이 있다.
2. getter 메서드만으로 외부에서 객체의 상태를 변경하지는 못하지만, 그 결과값이 객체의 상태를 변경시키는데에 사용될 수 있다. 

이 중 2번째 이유에 집중해서 보자면 getter로는 상태를 변경하지 못하지만, 외부에서 그 값을 받아 객체의 상태값을 바꾼다는 판단을 하면 좋지 않겠다는 생각을 했다. 

🔹 이러한 이유로 getter를 사용하지 말아야 한다는 강박이 생기기 시작했다. 그러다보니 코드의 진도가 나가지 않는 어려움을 겪게 되었다. 하지만, getter를 지양하는 이유가 외부에서 상태 값을 바꾸는 경우가 걱정되는 거라면 그렇게 되지 않도록 신경쓰고 사용한다면 문제가 없는게 아닐까라는 생각에 getter가 필요한 부분은 신중하게 사용하고 값을 변경하지 않도록 했다. 

일급 컬렉션의 특징인 불변을 지키기 위해서도 Collections.unmodifiableList를 사용하려 했으나 내부적으로 원본 객체를 그대로 가지고 있다는 특징이 있기 때문에 둘 사이의 아무런 관계가 없이 객체가 원본 객체를 복사한 객체인 List.copyOf()를 사용했다.

```java 
public class UserBaseballNumber {

  private List<String> userValues;

  public UserBaseballNumber(List<String> userValues) {
    // 중략
    this.userValues = userValues;
  }

  // 중략

  public List<String> getUserValues() {
    return List.copyOf(userValues);
  }
}

```

## ⚙️ 일급 컬렉션

🔹 일급 컬렉션(First-Class Collection)은 상태와 행위를 함께 캡슐화하는데 주로 컬렉션을 사용하는 디자인 패턴이다. 일급 컬렉션은 컬렉션을 하나의 객체로 취급하여 해당 컬렉션과 관련된 동작을 통합하고, 높은 응집도와 캡슐화를 통해 코드의 가독성과 유지 보수성을 향상시키는 데 도움이 된다는 내용에 이번 미션에서 일급 컬렉션을 활용했다.

# :ledger: 다음 미션에 적용할 학습 내용