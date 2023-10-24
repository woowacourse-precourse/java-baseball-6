## [🔍 진행 방식](https://github.com/muyaaho/java-baseball-6#-%EC%A7%84%ED%96%89-%EB%B0%A9%EC%8B%9D)

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만든다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## [✏️ 과제 진행 요구 사항](https://github.com/muyaaho/java-baseball-6#%EF%B8%8F-%EA%B3%BC%EC%A0%9C-%EC%A7%84%ED%96%89-%EC%9A%94%EA%B5%AC-%EC%82%AC%ED%95%AD)

- 미션은 [java-baseball-6](https://github.com/woowacourse-precourse/java-baseball-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.

## [🧑‍💻 구현해야 할 기능](https://github.com/muyaaho/java-baseball-6/blob/muyaaho/docs/README.md#%EA%B5%AC%ED%98%84%ED%95%B4%EC%95%BC-%ED%95%A0-%EA%B8%B0%EB%8A%A5)

- [x]  서로 다른 3자리의 랜덤한 수를 만든다.
    - [x]  String 으로 구현
    - [x]  1~9의 서로 다른 숫자
    - [x]  `camp.nextstep.edu.missionutils` 에서 제공하는 `Random` , `Console` 의 API를 사용해서 구현 [링크](https://github.com/muyaaho/java-baseball-6#%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC)
- [x]  반복: 한 게임이 끝날 때 까지(맞추거나 잘못된 값을 입력하는 동안)
- [x]  한 숫자를 맞추는 게임
    - [x]  틀리면 스트라이크, 볼, 낫싱으로 힌트를 준다
    - [x]  맞추면 3스트라이크를 입력하고 새로운 게임을 시작하거나 종료한다
- [x]  잘못된 값이 입력되었을 때 IllegalArgumentException
    - [x]  '`숫자를 입력해주세요`' 입력에서 3자리 수가 나오지 않았을 때
        - output image
            
            ![image](https://user-images.githubusercontent.com/76798969/276845450-a22feb58-3a94-4bf5-8352-600ce424684f.png)
            
            ![image](https://user-images.githubusercontent.com/76798969/276845498-c52896db-fc37-46e0-90aa-e954bd3bf631.png)
            
            ![image](https://user-images.githubusercontent.com/76798969/276845553-7da04efd-229b-4d37-8d30-ec2c87edb279.png)
            
    - [x]  `숫자를 입력해주세요` 입력에서 숫자가 아닌 영어나 다른 문자가 입력되었을 때
        - output image
            
            ![image](https://user-images.githubusercontent.com/76798969/276845655-ddac06f8-f4e9-4d0f-9161-6da70b15231d.png)
            
            ![image](https://user-images.githubusercontent.com/76798969/276845705-62867aa9-5b29-46c9-8e4f-7a61612bcee9.png)
            
    - [x]  `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 입력에서 1,2 가 아닌 다른 입력이 들어왔을 때
        - output image
            
            ![image](https://user-images.githubusercontent.com/76798969/276845797-22b6c36b-26c6-4b24-b565-c5d583f81789.png)
            
            ![image](https://user-images.githubusercontent.com/76798969/276845846-3ab611b6-6e7e-45f8-8cb4-a10b212aebc8.png)
            
- [x]  숫자 비교
    - ~~한 게임이 시작 될 때 랜덤으로 각자 다른 수가 만들어진 배열을 만든다~~
    - ~~입력도 배열로 만든다~~
    - ~~string은 indexOf()를 사용할 수 있음~~
    - [x]  입력 숫자와 정답을 인덱스 별로 비교하면서 자리가 같은지 아닌지 확인한다.
    - [x]  컴퓨터, 입력 둘 다 String으로 만든다.
    - [x]  이중 for문을 사용하여 strike, ball을 카운트한다.
- [x]  볼: 숫자만 맞는 것, 스트라이크: 숫자도 맞고 자리도 맞고
- [https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java 자바](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java%C2%A0%EC%9E%90%EB%B0%94) 스타일 가이드
    - [x]  테스트 위한 output 관리하는 변수(상수)를 생성한다.
    - [x]  기능별로 메소드로 묶는다.
        - [x]  strike, ball 2 개의 output을 갖고 싶을 때: 이 변수들을 관리하는 클래스를 만들고 이 안에서 strike, ball을 써먹는 메소드를 만든 후 객체명.변수 해서 가져온다.
            - ~~strike ball을 알려주는 함수 (getter인가)~~
            - [x]  반복문이 새로 실행되면 strike, ball을 초기화 하는 함수를 만든다.
            - [x]  문자열을 비교해 strike, ball을 count 하는 함수를 만든다.
            - [x]  적절한 메시지를 출력하거나 에러를 발생시키는 함수를 만든다.
        - [x]  랜덤한 수를 만드는 함수를 만든다.
        - [x]  예외 처리 기능을 하는 함수를 만든다.
            - [x]  두 가지로 할 일을 쪼개야 한다.
                1. ischeck면 함수에서 1, 2 입력받고
                2. 예외 처리하고 1, 2 return (잘못된 입력은 예외 처리를 하고 종료하게 되니까)
        - [x]  게임 실행 함수를 만든다.
        - [x]  새로운 파일로 클래스를 분리한다.
    - [x]  새로 생성한 메소드 설명을 적는다.

## [🪄 수정해야 할 기능](https://github.com/muyaaho/java-baseball-6/blob/muyaaho/docs/README.md#%EC%88%98%EC%A0%95%ED%95%B4%EC%95%BC-%ED%95%A0-%EA%B8%B0%EB%8A%A5)

- [x]  사용자 입력 값
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- [x]  랜덤 값 추출
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
- [x]  3자리 숫자에 0 포함되면 다시 입력하라 하는지 아님 예외 넘기는지
    - 예외 처리
- [x]  공백이 들어간 입력이 들어온다면?
    - `1 2 3`, `123` , `123`
    - 예외 처리
- [x]  연속된 숫자가 들어온다면?
    - `111`
    - 새롭게 입력을 받도록 수정
        
        ![image](https://user-images.githubusercontent.com/76798969/277250009-beb949ce-d969-46d8-bfa8-c44e5e78e751.png)
        

## [✅ 확인](https://github.com/muyaaho/java-baseball-6/blob/muyaaho/docs/README.md#%ED%99%95%EC%9D%B8)

- [x]  제출 전 테스트 가이드 사용
- [x]  요구 사항에 명시된 출력 값이 나왔는지 확인
- [x]  **`IS_TEST` 변수 false로 수정하고 제출**
- [x]  커밋 메시지는 `소문자: 영어 내용` 으로 작성
- [x]  [미션 제출 방법](https://github.com/muyaaho/java-baseball-6#-%EB%AF%B8%EC%85%98-%EC%A0%9C%EC%B6%9C-%EB%B0%A9%EB%B2%95) 확인해서 제출, pull & request, 사이트 제출
