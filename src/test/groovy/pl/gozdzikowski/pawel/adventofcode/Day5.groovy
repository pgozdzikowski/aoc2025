package pl.gozdzikowski.pawel.adventofcode

import pl.gozdzikowski.pawel.adventofcode.day5.Cafeteria
import pl.gozdzikowski.pawel.adventofcode.shared.input.FileInput
import pl.gozdzikowski.pawel.adventofcode.shared.input.Input
import pl.gozdzikowski.pawel.adventofcode.shared.input.StringInput
import spock.lang.Specification

class Day5 extends Specification {
    Cafeteria cafeteria = new Cafeteria()

    def 'count how many are fresh'() {
        given:
            String input = """3-5
10-14
16-20
12-18

1
5
8
11
17
32
"""
        expect:
            cafeteria.howManyIsFresh(new StringInput(input)) == 3
    }

    def 'part 1'() {
        given:
            Input input = new FileInput("day5.txt")
        expect:
            cafeteria.howManyIsFresh(input) == 674
    }

    def 'how many is fresh in ranges'() {
        given:
            String input = """3-5
10-14
16-20
12-18

1
5
8
11
17
32
"""
        expect:
            cafeteria.howManyIsFreshInRanges(new StringInput(input)) == 14
    }

    def 'part 2'() {
        given:
            Input input = new FileInput("day5.txt")
        expect:
            cafeteria.howManyIsFreshInRanges(input) == 352509891817881
    }

}
