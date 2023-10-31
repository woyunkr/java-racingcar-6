package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final String NAME_SEPARATOR = ",";
    private static final String ROUND_RESULT_TEMPLATE = "%s : %s%n";

    private final List<Car> cars = new ArrayList<>();
    private final int tryCount;

    public RacingGame(String names, int tryCount) {
        String[] carNames = names.split(NAME_SEPARATOR);
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.tryCount = tryCount;
    }

    public void run() {
        for (int i = 0; i < tryCount; i++) {
            playRound(i + 1);
        }
        determineWinner();
    }

    private void playRound(int round) {
        for (Car car : cars) {
            car.move();
        }
        printRoundResult(round);
    }

    private void printRoundResult(int round) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.printf(ROUND_RESULT_TEMPLATE, car.getName(), car.getProgress());
        }
        System.out.println();
    }

    private void determineWinner() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        printWinners(winners);
    }

    private void printWinners(List<String> winners) {
        String winnersString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersString);
    }
}