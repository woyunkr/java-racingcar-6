package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final String PROGRESS_SYMBOL = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getProgress() {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < position; i++) {
            progress.append(PROGRESS_SYMBOL);
        }
        return progress.toString();
    }
}
