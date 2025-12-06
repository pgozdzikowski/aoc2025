package pl.gozdzikowski.pawel.adventofcode.day6;

import pl.gozdzikowski.pawel.adventofcode.shared.input.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrashCompactor {

    private static final String SPACE = " ";

    public long findSumOfOperations(Input input) {
        List<String> lines = input.get();
        List<List<Long>> grid = lines.subList(0, lines.size() - 1).stream().map((el) -> Arrays.stream(el.split("\\s")).filter((s) -> !s.isEmpty()).map(Long::valueOf).toList()).toList();
        List<String> ops = Arrays.stream(lines.get(lines.size() - 1).split("\\s")).filter((el) -> !el.isEmpty()).toList();
        Long finalSum = 0L;
        for(int i = 0; i < grid.get(0).size(); i++) {
            Long partialResult = grid.get(0).get(i);
            for(int j = 1; j < grid.size(); j++) {
                switch(ops.get(i)) {
                    case "+" -> partialResult += grid.get(j).get(i);
                    case "*" ->partialResult *= grid.get(j).get(i);
                }
            }
            finalSum += partialResult;
        }
        return finalSum;
    }

    public long findSumOfOperationsInColumns(Input input) {
        List<String> lines = input.get();
        String[][] grid = lines.stream().map((el) -> el.split("")).toArray(String[][]::new);
        Long finalSum = 0L;
        List<Long> numbersToPerformOperations = new ArrayList<>();
        for(int i = grid[0].length - 1; i >= 0; i--) {
            StringBuilder currentNumber = new StringBuilder();
            for(int y = 0; y < grid.length; y++) {
                if(y == grid.length - 1) {
                    if(currentNumber.isEmpty())
                        continue;

                    numbersToPerformOperations.add(Long.parseLong(currentNumber.toString()));

                    if(!grid[y][i].equals(SPACE))  {
                        switch(grid[y][i]) {
                            case "+" -> finalSum += numbersToPerformOperations.stream().reduce(Long::sum).get();
                            case "*" -> finalSum += numbersToPerformOperations.stream().reduce(1L, (acc, el) -> acc * el);
                        }
                        numbersToPerformOperations.clear();
                    }
                } else {
                    if(!grid[y][i].equals(SPACE)) {
                        currentNumber.append(grid[y][i]);
                    }
                }
            }
        }

        return finalSum;
    }
}
