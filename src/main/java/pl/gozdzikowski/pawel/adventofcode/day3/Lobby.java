package pl.gozdzikowski.pawel.adventofcode.day3;

import pl.gozdzikowski.pawel.adventofcode.shared.input.Input;

public class Lobby {

    public long findSumOfMaxVoltageOfLength(Input input, int length) {
        return input.get().stream()
                .map((el) -> findAllDigitsOfLength(el ,length))
                .mapToLong(Long::valueOf)
                .sum();
    }

    private Long findAllDigitsOfLength(String input, int length) {
        String[] splitNumbers = input.split("");
        StringBuilder finalNumber = new StringBuilder();
        int currentMaxIndex = 0;
        while (length > 0) {
            for (int i = currentMaxIndex; i < splitNumbers.length - length + 1; i++) {
                if (Long.parseLong(splitNumbers[i]) > Long.parseLong(splitNumbers[currentMaxIndex])) {
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
