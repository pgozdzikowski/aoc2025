package pl.gozdzikowski.pawel.adventofcode.day1;

import pl.gozdzikowski.pawel.adventofcode.shared.collections.Pair;
import pl.gozdzikowski.pawel.adventofcode.shared.input.Input;

import java.util.List;

public class SecretEntrance {


    public Pair<Long, Long> countHowManyMoved(Input input) {
        long currentPosition = 50;
        long countEach = 0;
        long countAfterMove = 0;
        List<Pair<String, Long>> moves = input.get()
                .stream().map(this::parseInput)
                .toList();
        for (Pair<String, Long> move : moves) {
            int direction = switch (move.left()) {
                case "L" -> -1;
                case "R" -> 1;
                default -> 0;
            };

            long stepsLeft = move.right();
            while(stepsLeft > 0) {
                currentPosition += direction;
                stepsLeft--;

                currentPosition %= 100;
                if (currentPosition < 0) {
                    currentPosition += 100;
                }
                if(currentPosition == 0) {
                    countEach++;
                }
            }

            if(currentPosition == 0) {
                countAfterMove++;
            }

            System.out.println("Current position: " + currentPosition + " After " + move);
        }

        return Pair.of(countAfterMove, countEach);
    }



    private Pair<String, Long> parseInput(String input) {
        return Pair.of(input.substring(0, 1), Long.parseLong(input.substring(1)));
    }

}
