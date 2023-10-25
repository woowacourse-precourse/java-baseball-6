# 기존 구현 기능

ComputerControl.`generateRandomNum()`

- List<Integer> 형으로, NUM_LENGTH인 3만큼의 랜덤 숫자를 발생시키는 기능입니다. while문 내에서 중복 여부를 확인해 computerNum에 추가합니다.

# 구현한 기능

UserView.`requestInput()`

- 사용자에게 숫자를 입력하라는 메세지를 전달하는 기능입니다.

UserView.`requestReply()`

- 사용자가 3스트라이크를 맞췄을 시, 게임 종료와 재시작 혹은 종료를 위한 입력을 안내하는 기능입니다.

---
InputControl.`getNumber()`

- 사용자에게 숫자를 입력 받는 기능입니다.

InputControl.`getRestartCode()`

- 사용자에게 재시작 혹은 종료에 대한 숫자를 입력 받는 기능입니다.

---
Validation.`validateUserInput`

- 아래에 나올 세개의 메서드(1~3)를 하나의 기능으로 만들어놓은 것입니다.
- `validateNumberLength` 기능은 String으로 받아 진행하고 이후 2개의 검증 과정은 Arraylist로 변경해 검증 진행할 수 있도록 만들었습니다.

(1) `validateNumberLength`

사용자가 입력한 숫자의 길이가 3과 같지 않으면 예외를 던지는 기능입니다. String으로 받아 .length()를 통해 길이를 측정하고 3과 비교합니다.

(2) `validateNumberDuplicated`

사용자가 입력한 숫자에 중복되는 수가 있을 때 예외를 던지는 기능입니다. stream.distinct()는 stream의 중복을 모두 제거하고, .count()는 stream의 사이즈를 리턴합니다. 사용자가 입력한
숫자 리스트와 stream().distinct().count()가 다른 경우, 사용자의 입력에 중복된 요소가 있었음을 알 수 있습니다.

(3) `validateNumberRange`

사용자가 입력한 숫자가 1~9 사이가 아니라면 예외를 던지는 기능입니다. 1보다 작거나, 9보다 큰 경우, 오류가 출력됩니다.

(4) `validateReply`

위의 세 개의 검증 메서드는 전부 사용자가 입력한 세자리 숫자와 관련한 검증 기능입니다. 이 기능은 사용자가 3스트라이크에 성공한 후, 사용자가 재시작이나 종료를 위한 입력과 관련한 검증 기능입니다. 1이나 2를
입력하지 않을 경우 예외를 던지는 기능입니다.
---
Converter.`toIntegerList`

- Console.readline()을 통해 String을 입력받아 Integer 형태의 Arraylist로 변환해주는 기능입니다. 이후 CountResult 클래스에서 ball과 strike를 세기 위해
  구현했습니다.

---
CountResult.`countingResult`

- 밑의 countingBall과 countingStrike를 함께 넣어놓은 기능입니다.
- CountResult.`countingBall`
    - ball의 개수를 세주는 기능입니다. 컴퓨터의 랜덤 넘버에 사용자의 입력 숫자가 있으나, 같은 자리에 있는 것은 제외하도록 구현했습니다.
- CountResult.`countingStrike`
    - strike의 개수를 세주는 기능입니다. 컴퓨터의 랜덤 넘버의 위치와 사용자의 입력 숫자의 위치가 같아야 카운팅되도록 만들었습니다.

---
ResultView.`givingResult`

- 이 기능은 CountResult 클래스에서 리턴받은 ball과 strike를 통해 사용자에게 개수 현황을 알려주는 기능입니다. StringBuilder로 정답을 쌓아나가는 방법을 사용하였습니다.
- 만약 3스트라이크가 되면 Baseball클래스의 `restartOrExit` 메서드로 이동합니다.

---
Baseball.`playGame()`

- 게임 진행 기능입니다. while문 밖은 첫 시작 때만 실행됩니다. 재시작되면 while문 안의 기능만 진행됩니다. 사용자에게 입력을 요청하는 메세지를 띄우고, String inputNum으로 입력 받은 후
  이를 `validateUserInput`을 통해 올바른 입력인지 검증합니다. 올바른 입력이라면, inputNum을  `toIntegerList`*에서 Arraylist인 userNum으로 변환합니다. 변환된
  입력에서 `countingResult`을 통해 ball과 strike 개수를 셉니다. 이후 사용자에게 `givingResult`을 통해 개수 현황을 알려주는 메세지를 띄웁니다.

Baseball.`startGame()`

- 첫 시작 때에만 실행되는 메서드로 사용자에게 WELCOME 메세지를 출력하고 컴퓨터로부터 랜덤값을 받습니다.

Baseball.`restartOrExit()`

- 사용자로부터 재시작과 종료에 대한 입력을 받고 이를 1인지 2인지 감별 및 검증하는 기능입니다. 만약 1이면 여기에서 새롭게 랜덤 숫자를 발생시키고, 2와 같다면 boolean 값을 변경시켜 프로그램을
  종료합니다.

