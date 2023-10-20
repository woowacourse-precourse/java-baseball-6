## [🔍 진행 방식](https://github.com/muyaaho/java-baseball-6#-%EC%A7%84%ED%96%89-%EB%B0%A9%EC%8B%9D)

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만든다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## [✏️ 과제 진행 요구 사항](https://github.com/muyaaho/java-baseball-6#%EF%B8%8F-%EA%B3%BC%EC%A0%9C-%EC%A7%84%ED%96%89-%EC%9A%94%EA%B5%AC-%EC%82%AC%ED%95%AD)

- 미션은 [java-baseball-6](https://github.com/woowacourse-precourse/java-baseball-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.

## 구현해야 할 기능

- [x]  3개의 랜덤한 수 고르기 - str로
    - [x]  1~9의 서로 다른 숫자
- [x]  반복: 한 게임이 끝날 때 까지(맞추거나 잘못된 값을 입력 하는 동안)
- [x]  한 숫자를 계속 맞춰야 됨
    - 처음에는 수를 입력 받는 동안 새로운 랜덤한 수를 만들었었음..
- [x]  잘못된 값이 입력되었을 때 IllegalArgumentException
    - [x]  `숫자를 입력해주세요` 입력 에서 3자리 수가 나오지 않았을 때
    - [x]  `숫자를 입력해주세요` 입력 에서 숫자가 아닌 영어나 다른 문자가 입력되었을 때
    - [x]  `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 입력에서 1,2 가 아닌 다른 입력이 들어왔을 때
- [x]  숫자 비교
    - ~~한 게임이 시작 될 때 랜덤으로 각자 다른 수가 만들어진 배열 만들기~~
    - ~~입력도 배열로 만들기~~
    - ~~입력 숫자를 반복문 돌면서 자리가 같은지 아닌지 확인하기~~
    - 아니면 둘 다 스트링으로 하고 index로 접근할 수 있으면 그렇게 하기
    - string은 indexOf()를 사용할 수 있음., 아니면 이중 for문 쓰기
- [x]  볼: 숫자만 맞는 것, 스트라이크: 숫자도 맞고 자리도 맞고
- [ ]  [https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/jav](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/javㅁ)a  자바 스타일 가이드

## 수정해야 할 기능

- [ ]  (10.19) 사용자 입력 값
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- [ ]  (10.19) 랜덤 값 추출
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.

## 확인

- [ ]  제출 전 테스트 가이드 사용
- [ ]  요구 사항에 명시된 출력값이 나왔는지 확인
- [ ]  커밋 메시지는 `소문자: 영어 내용` 으로 작성
- [ ]  [미션 제출 방법](https://github.com/muyaaho/java-baseball-6#-%EB%AF%B8%EC%85%98-%EC%A0%9C%EC%B6%9C-%EB%B0%A9%EB%B2%95) 확인해서 제출, pull & request, 사이트 제출