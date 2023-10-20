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
    - [ ]  `camp.nextstep.edu.missionutils`  에서 제공하는 `Random` , `Console` 의 API를 사용해서 구현 [링크](https://github.com/muyaaho/java-baseball-6#%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC)
- [x]  반복: 한 게임이 끝날 때 까지(맞추거나 잘못된 값을 입력하는 동안)
- [x]  한 숫자를 계속 맞춰야 됨
    - 처음에는 수를 입력 받는 동안 새로운 랜덤한 수를 만들었었음..
- [x]  잘못된 값이 입력되었을 때 IllegalArgumentException
    - [x]  '`숫자를 입력해주세요`' 입력에서 3자리 수가 나오지 않았을 때
        
        ![image](https://github.com/muyaaho/java-baseball-6/assets/76798969/a22feb58-3a94-4bf5-8352-600ce424684f)
        
        ![image](https://github.com/muyaaho/java-baseball-6/assets/76798969/c52896db-fc37-46e0-90aa-e954bd3bf631)
        
        ![image](https://github.com/muyaaho/java-baseball-6/assets/76798969/7da04efd-229b-4d37-8d30-ec2c87edb279)
        
    - [x]  `숫자를 입력해주세요` 입력에서 숫자가 아닌 영어나 다른 문자가 입력되었을 때
        
        ![image](https://github.com/muyaaho/java-baseball-6/assets/76798969/ddac06f8-f4e9-4d0f-9161-6da70b15231d)

        ![image](https://github.com/muyaaho/java-baseball-6/assets/76798969/62867aa9-5b29-46c9-8e4f-7a61612bcee9)
        
    - [x]  `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 입력에서 1,2 가 아닌 다른 입력이 들어왔을 때
        
        ![image](https://github.com/muyaaho/java-baseball-6/assets/76798969/22b6c36b-26c6-4b24-b565-c5d583f81789)

        ![image](https://github.com/muyaaho/java-baseball-6/assets/76798969/3ab611b6-6e7e-45f8-8cb4-a10b212aebc8)

        
- [x]  숫자 비교
    - ~~한 게임이 시작 될 때 랜덤으로 각자 다른 수가 만들어진 배열 만들기~~
    - ~~입력도 배열로 만들기~~
    - ~~입력 숫자를 반복문 돌면서 자리가 같은지 아닌지 확인하기~~
    - 아니면 둘 다 스트링으로 하고 index로 접근할 수 있으면 그렇게 하기
    - string은 indexOf()를 사용할 수 있음., 아니면 이중 for문 쓰기
- [x]  볼: 숫자만 맞는 것, 스트라이크: 숫자도 맞고 자리도 맞고
- [ ]  [https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/jav](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/javㅁ)a  자바 스타일 가이드
    - [x]  테스트 위한 output 관리하는 변수(상수) 생성
    - [x]  메소드로 바꾸기
        
        > https://myeonguni.tistory.com/1596
        > 
        > 
        > **9. 4 Methods**
        > 
        > 명명 규칙은 다음과 같다.
        > 
        > - 메서드의 이름은 동사이어야 하며, 복합 단어일 경우 첫 단어는 소문자로 시작하고 그 이후에 나오는 단어의 첫 문자는 대문자로 사용해야 한다.
        > 
        > 예제는 다음과 같다.
        > 
        > - run();
        > - runFast();
        > - getBackground();
        - [x]  strike, ball 2 개의 output을 갖고 싶을 때: 이 변수들을 관리하는 클래스를 만들고 이 안에서 strike, ball을 써먹는 메소드를 만든 후 객체명.변수 해서 가져오기
            - 반복문이 새로 실행되면 strike, ball을 초기화 하는 함수
            - strike ball을 알려주는 함수 (getter인가)
            - 문자열을 비교해 strike, ball을 count 하는 함수
            - 적절한 메시지를 출력하거나 에러를 발생시키는 함수
        - [x]  랜덤 수 만드는 메소드
        - [x]  예외 처리 하는 함수
            - 두 가지로 할 일을 쪼개야 됨
                1. ischeck면 함수에서 1, 2 입력받고
                2. 예외 처리하고 1, 2 return (잘못된 입력은 예외 처리를 하고 종료하게 되니까)
        - [x]  게임 실행 함수
        - [ ]  메소드 내 강한 결합? 많이 엮여 있는 개념 풀기
            - [ ]  모두 Application java 파일 안의 Baseball 클래스 안에 집어넣었는데 먼저 자바 클래스 분리하기
            - [ ]  startGame 메소드 2가지로 분리하기 - 게임이 실질적으로 실행되는 부분은 따로 만들기
            
    - [ ]  새로 생성한 메소드 설명 적기
    - [ ]  변수 이름 변경
        
        > https://myeonguni.tistory.com/1596
        > 
        > 
        > **9. 5 Variables**
        > 
        > 명명 규칙은 다음과 같다.
        > 
        > - 변수 이름의 첫 번째 문자는 소문자로 시작하고, 각각의 내부 단어의 첫 번째 문자는 대문자로 시작해야 한다.
        > - 변수 이름이 언더바 (_) 또는 달러 표시 문자로 시작하는 것이 허용되기는 하지만, 이 문자들로 시작하지 않도록 주의하자.
        > - 이름은 짧지만 의미 있어야 한다.
        > - 이름의 선택은 그 변수의 사용 의도를 알아낼 수 있도록 의미적이어야 한다.
        > - 한 문자로만 이루어진 변수 이름은 암시적으로만 사용하고 버릴 변수일 경우를 제외하고는 피해야 한다.
        > - 보통의 임시 변수들의 이름은 integer 일 경우에는 i, j, k, m, n을 사용하고, character 일 경우에는 c, d, e를 사용한다.
        > 
        > 예제는 다음과 같다.
        > 
        > - int i;
        > - char c;
        > - float myWidth;
        > 
        > **9. 6  Constants**
        > 
        > - 명명 규칙은 다음과 같다.
        > - 클래스 상수로 선언된 변수들과 ANSI 상수들의 이름은 모두 대문자로 쓰고 각각의 단어는 언더바("_")로 분리 해야 한다.
        > - 디버깅을 쉽게 하기 위해서 ANSI 상수들의 사용은 자제하도록 한다.
        > 
        > 에제는 다음과 같다.
        > 
        > - static final int MIN_WIDTH = 4;
        > - static final int MAX_WIDTH = 999;
        > - static final int GET_THE_CPU = 1;

## 수정해야 할 기능

- [x]  사용자 입력 값
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- [x]  랜덤 값 추출
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
- [x]  3자리 숫자에 0 포함되면 다시 입력하라 하는지 아님 예외 넘기는지
    - 예외 처리
- [ ]  공백이 들어간 입력이 들어온다면?
    - `1 2 3`
    - `123  `
    - `   123`
- [ ]  연속된 숫자가 들어온다면?
    - `111`

## 확인

- [ ]  제출 전 테스트 가이드 사용
- [x]  요구 사항에 명시된 출력 값이 나왔는지 확인
- [ ]  커밋 메시지는 `소문자: 영어 내용` 으로 작성
- [ ]  [미션 제출 방법](https://github.com/muyaaho/java-baseball-6#-%EB%AF%B8%EC%85%98-%EC%A0%9C%EC%B6%9C-%EB%B0%A9%EB%B2%95) 확인해서 제출, pull & request, 사이트 제출
