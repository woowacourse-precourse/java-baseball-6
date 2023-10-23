## 클래스 아키텍처
<img width="1080" alt="Pasted Graphic 6" src="https://github.com/Team-BuddyCon/BACKEND_V2/assets/69676101/402c4b4c-3e1a-4aa7-b109-fef3ac3e01dd">
<br><small>전체 아키텍처를 파악하는데 중요하지 않은 클래스(상수를 가지는 enum클래스 등)는 포함되어있지 않습니다.</small>

## 클래스 책임
- `Digit.java`
  - 1에서 9사이의 수를 가진다.
  - 게임내에서 사용되는 세자리수 (Random하게 생성되는 컴퓨터의 세자리수, 사용자 입력값인 세자리수)의 각 자릿수를 맡는다.
  - Collection에 담겨 사용하기 때문에, equals and hashcode가 구현되어있어야한다.
- `Digits.java`
  - 3개의 Digit 객체를 List내에 담아 가지고있는 일급 컬렉션 클래스
  - 필드의 `List<Digit>`과 인자로 들어온 `List<Digit>`를 비교하여 스스로 볼과 스트라이크 점수를 센다.
  - 컬렉션 객체이므로, equals and hashcode가 구현되어있어야 한다.
- `Computer.java`
  - '게임내의 경쟁상대'라는 책임을 가진다.
  - 필드로 `Digits`객체를 가진다.
  - 사용자의 입력값을 받아 점수를 반환해주는 책임을 가진다.
  - 사용자가 게임을 재시작할때, 가지고있는 `Digits`객체를 업데이트한다.
- `GameServer.java`
  - `Input.java`, `Output.java`와 협력하여 전반적인 게임 진행을 총괄한다.

## 기능목록
### 입력
- [x] 입력값 조건
  - 사용자의 입력값은 `camp.nextstep.edu.missionutils.Console`의 메소드를 사용한다.
  - 게임 시작
    - [x] 입력값은 3자리 숫자이다.
    - [x] 입력값은 서로 다른 수로 이루어져있다.
  - 게임 종료
    - [x] 재시작시 '1'을 입력한다.
    - [x] 종료시 '2'를 입력한다.
  - 입력값 예외시
    - [x] 잘못된 값이 입력될 경우 `IllegalArgumentException` 을 발생시킨다.
### 출력
- [x] 출력값 조건
  - [x] 컴퓨터는 랜덤값은 `camp.nextstep.edu.missionutils.Randoms`의 메소드를 사용한다. 
  - [x] 컴퓨터의 랜덤값과 일치할때까지 게임을 계속해서 진행한다.
  - [x] 랜덤값과 일치하는 것이 하나도 없는 경우 '낫싱'을 출력한다.
  - [x] 랜덤값과 같은 자리에 동일한 숫자가 있으면 스트라이크, 다른자리에 동일한 수가 있으면 볼의 갯수가 증가한다.
  - [x] 3개의 숫자를 모두 맞힌 경우 게임을 종료하고, 게임을 다시시작할지/종료할지 입력받는다.