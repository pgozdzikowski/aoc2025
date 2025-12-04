package pl.gozdzikowski.pawel.adventofcode.day4;

import pl.gozdzikowski.pawel.adventofcode.shared.collections.Pair;
import pl.gozdzikowski.pawel.adventofcode.shared.input.Input;

import java.util.ArrayList;
import java.util.List;

public class PrintingDepartment {

    private List<Pair<Integer, Integer>> DIRECTIONS = directions();

    public int printDepartment(Input input) {
        String[][] grid = input.get().stream().map((el) -> el.split(""))
                .toArray(String[][]::new);
        List<Pair<Integer, Integer>> result = findRemovable(grid);

        return result.size();
    }

    public int removeUntilSmthRemoved(Input input) {
        String[][] grid = input.get().stream().map((el) -> el.split(""))
                .toArray(String[][]::new);
        List<Pair<Integer, Integer>> result = new ArrayList<>();

        while(true) {
            List<Pair<Integer, Integer>> partialResults = findRemovable(grid);
            removeFromGrid(partialResults, grid);

            if(partialResults.isEmpty()) {
                break;
            }

            result.addAll(partialResults);
        }

        return result.size();
    }

    private List<Pair<Integer, Integer>> findRemovable(String[][] grid) {
        List<Pair<Integer, Integer>> partialResults = new ArrayList<>();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x].equals("@") && canBeAccessedByForklift(grid, x, y)) {
                    partialResults.add(new Pair<>(x, y));
                }
            }
        }
        return partialResults;
    }

    private static void removeFromGrid(List<Pair<Integer, Integer>> partialResults, String[][] grid) {
        for(Pair<Integer, Integer> partialResult : partialResults) {
            grid[partialResult.right()][partialResult.left()] = ".";
        }
    }

    private boolean canBeAccessedByForklift(String[][] grid, int x, int y) {
        int count = 0;
        for(Pair<Integer, Integer> direction : DIRECTIONS) {
            int newX = x + direction.left();
            int newY = y + direction.right();
            if(newX >= 0 && newX < grid[y].length && newY >= 0 && newY < grid.length) {
                if(grid[newY][newX].equals("@")) {
                    count++;
                }
            }

        }
        return count < 4;
    }

    public static List<Pair<Integer, Integer>> directions() {
        List<Pair<Integer, Integer>> result = new ArrayList<>();
        for(int y = - 1; y <= 1; y++) {
            for(int x = - 1; x <= 1; x++) {
                if(x == 0 && y == 0)
                    continue;
                result.add(new Pair<>(x, y));
            }
        }
        return result;
    }
}
