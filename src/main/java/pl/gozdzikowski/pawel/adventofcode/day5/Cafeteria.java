package pl.gozdzikowski.pawel.adventofcode.day5;

import pl.gozdzikowski.pawel.adventofcode.shared.input.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Cafeteria {

    public long howManyIsFresh(Input input) {
        String[] split = input.getContent().split("\\n\\n");
        List<Range> ranges = Arrays.stream(split[0].split("\\n")).map(this::toRange).toList();
        List<Long> ingiridients = Arrays.stream(split[1].split("\\n")).map(Long::valueOf).toList();
        return ingiridients.stream().filter((el) ->
                ranges.stream().anyMatch((range) -> range.contains(el))
        ).count();
    }

    public long howManyIsFreshInRanges(Input input) {
        String[] split = input.getContent().split("\\n\\n");
        List<Range> ranges = Arrays.stream(split[0].split("\\n")).map(this::toRange).toList();
        return mergeRanges(ranges)
                .stream()
                .map(Range::howManyInRange)
                .mapToLong(Long::longValue).sum();
    }

    private List<Range> mergeRanges(List<Range> ranges) {
        List<Range> leftToMerge = new ArrayList<>(ranges.stream()
                .sorted(Comparator.comparing(Range::lower))
                .toList());

        List<Range> finalRanges = new ArrayList<>();
        while (!leftToMerge.isEmpty()) {
            Range currentRangeToMerge = leftToMerge.removeFirst();
            List<Range> mergedRanges = new ArrayList<>();
            for (Range range : leftToMerge) {
                if (currentRangeToMerge.overlaps(range)) {
                    currentRangeToMerge = currentRangeToMerge.mergeWith(range);
                    mergedRanges.add(range);
                }
            }

            leftToMerge.removeAll(mergedRanges);
            finalRanges.add(currentRangeToMerge);
        }

        return finalRanges;
    }

    private Range toRange(String range) {
        String[] splited = range.split("-");
        return new Range(Long.parseLong(splited[0]), Long.parseLong(splited[1]));
    }

    public record Range(long lower, long upper) {
        public boolean contains(long value) {
            return value >= lower && value <= upper;
        }


        public boolean overlaps(Range range) {
            return lower <= range.upper && upper >= range.lower;
        }

        Range mergeWith(Range range) {
            return new Range(Math.min(lower, range.lower), Math.max(upper, range.upper));
        }

        public Long howManyInRange() {
            return upper - lower + 1;
        }
    }
}
