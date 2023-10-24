## 기능목록

#### Java 코드컨벤션 체크
- 클래스이름 -> UpperCamelCase - O
- 메서드이름 -> lowerCamelCase - O
- 파라미터, 지역변수 -> lowerCamelCase - O
- 상수 이름은 AAA_BBB 의형태 - O
- 블럭 들여쓰기 4칸 - O
- 열 제한 : 120 - O
- 와이들 카드 가져오기 없음 - O
- import 문 줄바꿈 없음(static -> non-static 순서) - O
  - static non-static 사이에 줄바꿈 - O
- 중괄호 무조건 사용하기 - O
- @Override 쓸일 있으면 항상 적용하기 - O



Ball
- 생성자에서 생성시 1~9범위가 맞는지 확인 - O
- 다른 ball과 비교해서 스트라이인지 확인 - O
- 다른 ball과 비교해서 볼인지 확인 - O

Balls
- Ball의 개수가 3개가 맞는지 확인 - O
  - 생성자에서 생성할 때 3개가 맞는지 확인하였다. - O
  - 생성자에서 생성할 때 서로다른 수인지 확인하였다. - O
- 다른 Balls와 비교해서 스트라이크 개수 찾기 - O
- 다른 Balls와 비교해서 볼 개수 찾기 - O
- 다른 Balls와 비교해서 삼진아웃인지 확인하기 - O
- 다른 Balls와 비교해서 낫싱인지 확인하기 - O

NumberGenerator
- 랜덤숫자 Balls를 생성 - O
  - 생성된 숫자가 1~9범위인지 확인하였다. - O

ResponseStatus
- 재시작, 종료에 대한 사용자 응답을 담고있는 Enum생성 - O
  - 생성 시 "1", "2" 외에 다른 응답이 들어온다면 예외를 반환한다. - O


RoundResult
- target Balls, userInputBalls 정보를 토대로 출력 결과를 생성한다. - O
- 사용자가 아직 정답을 맞추지 못했는지 판단한다 - O

Input
- 사용자로부터 숫자 입력받기 - O
- 재시작 여부 입력받기 - O

Output
- 게임시작문구 출력하기 - O
- 스트라이크/볼/낫싱인지 결과 출력하기 - O

---
- 모든 예외는 IllegalArgumentException로 발생시킨다. 
  - 나중에 예외 메세지도 별도로 만들어서 출력해보자.
- 게임 결과에 대한 정보를 어떻게 출력할지 생각해보자.
- 기능목록은 구현하면서 '꼼꼼'하게 수정해나가자.
- public 메서드에 모두 단위테스트를 작성하자.