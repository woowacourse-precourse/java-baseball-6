## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


## 🚀 기능 요구 사항
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.<br>
1. 같은 수가 같은 자리에 있으면 "스트라이크" <br> 
2. 다른 자리에 있으면 "볼" <br>
3. 같은 수가 전혀 없으면 "낫싱"<br>
4. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
5. 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
6. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

## ✏️ 필요기능 
1. 사용자가 숫자를 입력하는 기능
2. 입력받은 숫자를 검증하는 기능
3. 사용자의 숫자를 저장하는 기능
4. 상대방의 숫자를 검증하는 기능
5. 상대방의 숫자를 저장하는 기능
6. 사용자의 숫자와 상대방의 숫자를 비교하며 결과를 확인하는 기능
7. 정답을 맞추면 재시작 또는 종료하는 기능

## ✏️ 필요기능 구현
### 프로그램 구현  
#### 검색 도움 없이 제가 구현할 수 있는 방법으로 구현을 해 보았습니다. 

````
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = computer();                <=== 1
        boolean gameEnd = true;

        while (gameEnd){
            List<Integer> user = user();                    <=== 2
            gameEnd = gameStart(user,computer);             <=== 3
        }
    }
````
### 1. computer() 
* 필요기능 3. 상대방의 숫자를 검증하는 기능
* 필요기능 4. 상대방의 숫자를 저장하는 기능
  ````
      public static List<Integer> computer(){
       List<Integer> computer = new ArrayList<>();
       while (computer.size() < 3) {
           int randomNumber = Randoms.pickNumberInRange(1, 9);
           if (!computer.contains(randomNumber)) {
               computer.add(randomNumber);
           }
       }
       return computer;
   }
  ````
  * computer() 메서드에서 상대방(컴퓨터)의 숫자를 검증합니다.  
  * 활용 가능한 라이브러리를 사용하여 1~9까지 랜덤한 수를 가져옵니다.  
    Randoms.pickNumberInRange(1, 9)
  * computer.contains()을 사용하여 랜담한 수가 포함되는 지 확인하고 중복된 수가 없으면  computer.add()을 사용하여 랜덤한 수를 computer에 추가합니다.
  *  while (computer.size() < 3)을 사용하여 중복되지 않은 랜덤한 수 3개가 추가될 때까지 반복하여 상대방의 수를 검증하고 설정합니다.

### 2. user()
* 필요기능 1. 사용자가 숫자를 입력하는 기능
* 필요기능 2. 입력받은 숫자를 검증하는 기능
* 필요기능 3. 사용자의 숫자를 저장하는 기능
  ````
   public static List<Integer> user(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> numberInRange = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
  
        // 3자리 숫자 검증 
        if(!(3 == input.length())){
            throw new IllegalArgumentException("잘못 입력하셨습니다. 3자리 수를 입력해 주세요.");
        }

        List<Integer> user = new ArrayList<>();
  
        // 1~9범위의 숫자 검증
        for (int i = 0 ; i < input.length() ; i++){
            try {
                int inputNumber = Integer.parseInt(String.valueOf(input.charAt(i)));

                if(numberInRange.contains(inputNumber)){
                    user.add(inputNumber);
                }else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e){
                throw new IllegalArgumentException("잘못 입력하셨습니다. 1~9사이 숫자를 입력하세요.");
            }
        }
  
        //중복되지 않은 3가지의 숫자 검증 
        for(int i = 0 ; i < user.size(); i++){
            Integer num = user.get(i);
            if(numberInRange.contains(num)){
                numberInRange.remove(num);
            }else {
                throw new IllegalArgumentException("잘못 입력하셨습니다. 숫자를 중복없이 입력하세요.");
            }
        }
        return user;
    }
  ````
  * user() 메서드에서 사용자의 숫자를 검증하고 저장합니다.
  * 활용가능한 라이브러리를 사용하여 사용자한테 값을 입력받습니다.  
    Console.readLine()
  * 입력받은 값을 input.length()를 사용하여 3자리 인지 검증하고 3자리가 아니면  IllegalArgumentException 예외를 발생시킵니다.  
    if(!(3 == input.length())
  * 입력받은 문자열을 길이만큼 순회하며 문자열을 input.charAt(i)를 사용하여 i번째 문자를 추출한다.
  * 입력 값이 숫자인지를 검증하기 위해 추출한 문자를 Integer.parseInt() int 타입으로 파싱하는 과정을 거치는데 입력한 문자열 중 숫자형이 아닌 문자형이 있으면 파싱에 실패하고 java.lang.NumberFormatException 예외가 발생합니다. 발생한 예외는 try-catch의 catch에서 받아 IllegalArgumentException을 발생하도록 하여 검증하였습니다.
  * 1~9범위의 숫자인지를 검증하기 위해 numberInRange를 생성하여 1~9까지를 가지는 List를 생성하여 범위를 설정하였고, numberInRange.contains(inputNumber)을 사용하여 1~9범위에 존재하는지 검증하여 존재하면 user.add()를 사용하여 저장하고 존재하지 않으면 IllegalArgumentException 예외를 발생하도록 하여 검증하였습니다.
  * 중복되지 않은 숫자 3가지를 검증하기 위해 user.size 만큼 순회하여 user.get(i)의 수가 numberInRange.contains(num) 1~9의 범위에 포함되면  numberInRange.remove(num)으로 범위에 해당되는 숫자를 하나씩 제거합니다. 다음 i번째 숫자가 중복된 숫자라면 numberInRange에는 이미 중복된 숫자가 제거된 상태이기 때문에 numberInRange.contains(num) 의값이 false가 되고 else로 가서 IllegalArgumentException 예외를 발생하게 하여 검증하였습니다.     

### 3. gameStart()
* 필요기능 6. 사용자의 숫자와 상대방의 숫자를 비교하며 결과를 확인하는 기능
* 필요기능 7. 정답을 맞추면 재시작 또는 종료하는 기능
  ````
    public static boolean gameStart(List<Integer> user ,List<Integer> computer){
        int strike = 0;
        int ball = 0;

        for (int i = 0 ; i < user.size(); i++){
            if(user.get(i)==computer.get(i)){
                strike++;
                continue;
            }
            if(computer.contains(user.get(i))){
                ball++;
            }
        }
        String result = "";

        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        }

        if(ball>0){
            result += ball+"볼 ";
        }

        if(strike>0){
            result += strike+"스트라이크";
        }

        if(strike==3){
            System.out.println(result);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            
            if(input.equals("1")){
                computer.clear();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
                return true;
            }else if(input.equals("2")){
                return false;
            }else {
               throw new IllegalArgumentException("잘못 입력하셨습니다.");
            }

        }else {
            System.out.println(result);
            return true;
        }
    }
  ````
 * gameStart() 메서드에서 사용자의 숫자와 컴퓨터(상대방)의 숫자를 비교하여 결과를 확인하고 정답을 맞출경우 재시작 또는 종료합니다.
 * user.size()만큼 순회하여  if(user.get(i)==computer.get(i))조건을 주어 사용자의 i번째 값과 컴퓨터의 i번째 값이 같으면  strike++ 증감연산자를 사용하여 strike를 카운트 하고 continue를 이용하여 다음 순회로 넘어감니다.
 * 사용자의 i번째 값과 컴퓨터의 i번째 값이 같지 않으면 if(computer.contains(user.get(i))) 조건을 주어 사용자의 값이 컴퓨터의 값에 포함되는지 확인하고 포함이 되면 ball++ 하여  ball을 카운트 합니다.
 * strike와 ball 두개의 카운트만큼 힌트를 발생합니다.
 * strike와 ball 두개의 카운트가 0이면 같은 수가 전혀 없기 떄문에 낫싱이라는 힌트를 발생합니다.
 * 숫자 비교가 끝나면 true값을 반환하여 strike가 3일떄까지 반복합니다.
 * strike의 카운트가 3이면 모든 숫자를 맞추었기 때문에 게임종료 메세지와 재시작 메세지를 발생합니다.
 * Console.readLine()을 사용하여 사용자한테 1또는 2의 숫자를 입력받습니다.
 * 입력받은 값이 1 또는 2 두 숫자이기 때문에 검증하기 위해 if(input.equals("1")), else if(input.equals("2")) 조건을 주었고 그외 입력받은 값은 IllegalArgumentException 예외를 발생하여 검증하였습니다.  
 * 입력받은 값이 1이면 재시작이기 때문에 computer.clear()을 활용하여 상대방(컴퓨터)의 List를 초기화 하고, 값을 다시 설정한 후 true를 반환하여 재시작하도록 하였습니다.
 * 입력받은 값이 2이면 false를 반환하여 while()을 중지시켜 게임을 종료하도록 하였습니다. 
  


