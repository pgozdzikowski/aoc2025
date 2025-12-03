package pl.gozdzikowski.pawel.adventofcode.day3;

import pl.gozdzikowski.pawel.adventofcode.shared.input.Input;

import java.util.Arrays;

public class Lobby {

    public long findSumOfMaxVoltageOfLength(Input input, int length) {
        return input.get().stream()
                .map((el) -> findAllDigitsOfLength(el ,length))
                .mapToLong(Long::valueOf)
                .sum();
    }

    private Long findAllDigitsOfLength(String input, int length) {
        Long[] splitNumbers = Arrays.stream(input.split("")).map(Long::valueOf).toArray(Long[]::new);
        StringBuilder finalNumber = new StringBuilder();
        int currentMaxIndex = 0;
        while (length > 0) {
            for (int i = currentMaxIndex; i < splitNumbers.length - length + 1; i++) {
                if (splitNumbers[i] > splitNumbers[currentMaxIndex]) {
                    currentMaxIndex = i;
                }
            }
            finalNumber.append(splitNumbers[currentMaxIndex]);
            currentMaxIndex++;
            length--;
        }

        return Long.parseLong(finalNumber.toString());
    }
}
