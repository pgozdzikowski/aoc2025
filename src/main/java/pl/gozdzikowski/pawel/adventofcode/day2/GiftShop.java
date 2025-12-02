package pl.gozdzikowski.pawel.adventofcode.day2;

import pl.gozdzikowski.pawel.adventofcode.shared.collections.ListExt;
import pl.gozdzikowski.pawel.adventofcode.shared.input.Input;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class GiftShop {

    public long sumOfInvalidRepeatedOnce(Input input) {
        return sumOfInvalidIds(input, GiftShop::isInvalid);
    }

    public long sumOfInvalidRepeatedManyTimes(Input input) {
        return sumOfInvalidIds(input, GiftShop::isRepeatedNTimes);
    }

    private long sumOfInvalidIds(Input input, LongPredicate predicate) {
        return parseRanges(input.getContent())
                .stream()
                .flatMap((el) -> el.findInvalidIds(predicate).stream())
                .mapToLong(Long::valueOf)
                .sum();
    }

    private List<Range> parseRanges(String ranges) {
        String[] rangesAsString = ranges.split(",");
        return Arrays.stream(rangesAsString).map(el -> {
            String[] split = el.split("-");
            return new Range(Long.parseLong(split[0].replace("\n", "")), Long.parseLong(split[1].replace("\n", "")));
        }).toList();
    }

    record Range(
            long start,
            long end
    ) {
        public List<Long> findInvalidIds(LongPredicate predicate) {
            return LongStream.rangeClosed(start, end)
                    .filter(predicate)
                    .boxed().toList();
        }
    }

    public static boolean isInvalid(long current) {
        String stringRep = Long.valueOf(current).toString();
        int middle = stringRep.length() / 2;
        return stringRep.substring(0, middle).equals(stringRep.substring(middle));
    }

    public static boolean isRepeatedNTimes(long current) {
        String stringRep = Long.valueOf(current).toString();
        int middle = stringRep.length() / 2;
        for(int i = 1; i <= middle; i++) {
            List<List<String>> partition = ListExt.partition(Arrays.stream(stringRep.split("")).toList(), i);
            if(allElementsEquals(partition)) {
                return true;
            }
        }
        return false;
    }

    private static boolean allElementsEquals(List<List<String>> partitions) {
        if(partitions.size() == 1) {
            return false;
        }
        Set<List<String>> set = new HashSet<>(partitions);
        return set.size() == 1;
    }
}
