# 구현할 기능

### 주요 기능

입출력 기능    
입력 값의 유효성 검사 기능  
숫자 야구 게임 기능  
유효 난수 생성 기능  
예외 처리 기능

### 주요 클래스, 메소드

```  

Class Game:
    start <- 게임의 시작점, start() 메소드를 통해서만 게임을 플레이할 수 있다.
    play <- 숫자 야구의 주요 로직이 들어가 있다. 
    generateRandomNumber <- 게임에 유효한 난수을 생성하고 반환한다.
    checkUserGuessingNumberInput <- 게임 도중의 유저입력(서로 다른 세자리 수)의 유효성을 검사한다.
    checkuserOneOrTwoInput <- 게임이 끝난 후의 유저입력(1,2)의 유효성을 검사한다.
    userGuessingNumberInput <- 게임 도중의 유저의 유효한 입력만 반환한다.
    userOneOrTwoInput <- 게임 이후 유저의 유효한 입력만 반환한다.
    calculateStrike <- 스트라이크 횟수를 계산하고 반환한다.
    calculateBall <- 볼 횟수을 계산하고 반환한다.
    printResult <- 볼,스트라이크에 따른 문구를 출력한다.
    endGame <- 종료 메세지를 출력한다. 사용자 입력을 받고 검사하고 게임이 끝났는지 반환한다.
    
```

### 주요 로직

```


start는 메소드는 play메소드가 false를 반활할 떄까지 play 메소드를 호출한다. play 메소드는 사용자가 게임 종료를 했을 때 false를 반환한다.
play 메소드는 시작되면 게임 시작 문구를 출력한다. generateRandomNumber 메소드를 통해 유효 난수를 생성한다. 그 후 
사용자가 정답을 맞출 때까지 userGuessingNumberInput 메소드를 통해 입력을 받고 calculateStrike, calculateBall 메소드를
통해 스트라이크, 볼을 계산한 뒤 printResult 메소드로 결과를 출력한다. 만약 스트라이크가 3이라면 반복문을 빠져나온다. 마지막으로
endGame 메소드를 통해 사용자가 게임을 더 할 것인지 끝낼 것인지 묻는다. 게임을 더 한다면 endGame이 true를 반환하여 play 메소드가
한 번 더 실행 되고, false라면 start메소드의 반복문에서 빠져나와 프로그램이 자동으로 종료된다.


``` 

# 기능 요구 사항

✅ 볼,스트라이크, 낫싱  
✅ "1~9"까지의 "서로 다른 수"  
✅ 게임 종료 후 다시 시작, 종료 선택  
✅ 잘못된 값 입력시 IllegalArgumentException을 발생시키고 어플리케이션을 종료한다.

# 입출력 요구 사항

### 입력

✅ 서로 다른 3자리의 수  
✅ 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

### 출력

✅ 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

# 프로그래밍 요구 사항

✅ JDK17 버전 사용  
✅ 프로그램의 시작점은 Application의 main()  
✅ build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.  
✅ Java 코드 컨벤션 가이드를 준수  
✅ System.exit()를 호출하지 않는다.  
✅ ApplicationTest의 모든 테스트가 성공해야 한다.  
✅ 파일, 패키지 이름을 수정하거나 이동하지 않는다.  
✅ JDK 17 버전에서 실행 가능해야 한다. JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.  
✅ 프로그램 실행의 시작점은 Application의 main()이다.  
✅ build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.  
✅ camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.  
✅ Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.  
✅ 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

# 과제 진행 요구 사항

✅ 미션은 java-baseball-6 저장소를 Fork & Clone해 시작한다.  
✅ 기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가한다.  
✅ 과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고한다.
