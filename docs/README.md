# 1주차 숫자 야구 게임
## 코드 작성 전 기능 정리
### 있어야할 기능
- 컴퓨터 수를 랜덤으로 생성하는 기능
- 사용자의 입력값을 입력받는 기능
- 사용자가 잘못된 값을 입력할 경우 ”IllegalArgumentException”을 발생시킨 후 프로그램을 종료하는 기능
- 컴퓨터의 수와 사용자의 수를 비교하는 기능
    - 사용자의 수가 컴퓨터의 수에서 인덱스는 일치하지 않지만 수는 포함되어 있을 때는 ball
    - 인덱스까지 일치하면 strike
    - 수가 모두 틀리면 “낫싱”
    - 모두 맞으면 프로그램 종료

### 기능들의 구현 생각해보기
- 프로그래밍 요구사항에 의해 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    
    [우테코 1주차 제공 API 알아보기](https://polite-railway-368.notion.site/1-API-5cd0111db0b645b1b6594c75e9c596f1?pvs=4)
    
- 컴퓨터 수를 랜덤으로 생성하는 기능
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 클래스의 pickNumberInRange함수에 매개변수로 랜덤생성할 수의 범위(startnumber,endnumber) 랜덤수를 생성하여 준다.
    - startnumber와 endnumber를 포함하여 랜덤수를 생성하니 100,999를 매개변수로 준다.
- 사용자의 입력값을 입력받는 기능
    - `camp.nextstep.edu.missionutils` 의 Console 클래스의 readLine함수를 통해 사용자의 수를 입력해야한다.
    - Console의 readLine함수를 통해 사용자의 수를 한 줄씩 입력받고 필요한 사용자의 수를 받았다면 close를 통해 scanner를 해제하고 null값으로 초기화해준다.
    - 받은 입력값이 int가 아니거나 세자리의 수가 아니라면 try-catch문을 통해 IllegalArgumentException을 발생시켜준다.
- 컴퓨터의 수와 사용자의 수를 비교하는 기능
    - int 배열로 0번째 인덱스에는 strike와 1번째 인덱스에는 ball의 변수를 선언해준다.
    - 사용자의 수와 컴퓨터의 수를 /연산과 %연산을 통해 한자리씩 자른다.
    - 이중 for 문으로 사용자의 수 하나하나를 컴퓨터의 for문과 비교한다.
    - 만약 컴퓨터의 수와 같으면 자릿수가 맞는지 비교하고 자릿수까지 같으면 strike +=1
    - 자릿수가 다르면 ball+=1
    - 모든 for문이 종료되면 strike와 ball의 갯수를 알 수 있다.
- 결과를 출력하는 기능
    - strike가 3이면 “3스트라이크\n 3개의 숫자를 모두 맞히셨습니다! 게임 종료”라는 문자열을 출력하며 게임 종료
    - strike와 ball이 0이라면 “낫싱” 출력
    - 둘 다 아니라면 맞힌 갯수에 따라 “n볼 m스트라이크” 출력
    - 상황에 따라 유동적으로 출력하려면 StringBuilder를 통해 구현하는 편이 나을듯
- 사용자의 입력값을 받는 기능부터 출력하는 기능까지를 실행해주는 클래스를 구현해서 3스트라이크가 아니거나 게임이 종료된 후 사용자가 계속 하기를 원하면 다시 반복되게 해야할 듯

### 플로우 차트
![image](https://github.com/alswp006/java-baseball-6/assets/102672547/61b34e61-abeb-406f-a6b9-b7b9642c5a65)

## 의문
- 클래스에 static으로 사용하는 메소드가 한개밖에 존재하지않는다. 이 메소드를 생성자로 바꿔서 원하는 기능으로 출력하는건 어떨까
    - 자주 쓰는 메소드라면 쓸 때마다 객체를 생성해서 비효율적
- 자주 쓰는 메소드는 static? 아니면 객체생성?

[객체지향 생활 체조](https://polite-railway-368.notion.site/e57970306a4a4204b5512ef2c5f5ca03?pvs=4)

[Test코드 분석](https://polite-railway-368.notion.site/Test-2609638d0cba41cf9e46ada6328a660f?pvs=4)

[여러가지 문제 상황들](https://polite-railway-368.notion.site/e1c04741ab0141f3ae63ed9f361f14b2?pvs=4)
