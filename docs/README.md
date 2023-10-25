## 구현할 기능 목록 


## 1. 생성자
   1-1.생성자를 통해 변수 초기화<br/>
        Baseball 객체를 생성하게 될 경우, ball과 strike변수를 0으로 초기화하고<br/>
        user_input은 입력받아야하기때문에 3자리 값 0인 배열로,<br/>
        정답인 answer 배열은 Randoms.pickupNumberInRage(1,9);를 이용해 초기화한뒤,<br/>
        자리수에 같은 수가 있을경우 다시 진행한다.<br/>

## 2. start() 메소드
   2-1. userInput 입력<br/>
   정답을 맞출때까지 userInput을 계속 입력받아야하므로, while문을 사용해주고,<br/>
   3자리가 아니거나 0을 포함할경우 IllegalArgumentException 예외를 던진다.<br/><br/>
   2-2. 입력받은 userInput 정수로 parsing<br/>
   readLine()을 통해 입력받은 userInput을 정수로 parsing 한뒤에,<br/>
   배열에 숫자 자리수대로 하나씩 넣는다<br/><br/>
   2-3. strike, ball 처리<br/>
   user_input[k]과 answer[z]배열의 값이 같은 경우,<br/>
   k와 z가 같을경우 strike의 값을 +1,<br/>
   k와 z가 다를경우 ball의 값을 +1진행하고,<br/>
   break를 통해 해당 반복문을 탈출한다.<br/><br/>
   2-4. 출력 처리<br/>
   ball과 strike 모두 0인경우 "낫싱을 출력하고,<br/>
   이외의 경우 가지고있는 값만큼 출력하도록 처리한다.<br/>
   strike가 3일 경우, "3개의 숫자를 모두 맞히셨습니다! 게임 종료"를 출력한뒤 break문을 통해 해당 반복문을 종료하고,<br/>
   그렇지 않을경우 ball과 strike를 0으로 다시 초기화한뒤 반복문을 수행한다.<br/><br/>
   2-5. 함수 종료 관련<br/>
   반복문을 끝낸뒤에, 1을 입력할 경우 새로운 Baseball 객체를 생성해 start()메소드를 통해, 숫자 야구를 진행하고,<br/>
   2를 입력할 경우 종료하도록 구현한다.<br/>