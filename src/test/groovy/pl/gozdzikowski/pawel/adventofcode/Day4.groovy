package pl.gozdzikowski.pawel.adventofcode

import pl.gozdzikowski.pawel.adventofcode.day4.PrintingDepartment
import pl.gozdzikowski.pawel.adventofcode.shared.input.FileInput
import pl.gozdzikowski.pawel.adventofcode.shared.input.Input
import pl.gozdzikowski.pawel.adventofcode.shared.input.StringInput
import spock.lang.Specification

class Day4 extends Specification{
    PrintingDepartment printingDepartment = new PrintingDepartment()
    def 'count how many can be lifted'() {
        given:
            String input = """..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@."""
        expect:
            printingDepartment.printDepartment(new StringInput(input)) == 13
    }

    def 'part 1'() {
        given:
            Input input = new FileInput("day4.txt")
        expect:
            printingDepartment.printDepartment(input) == 1351
    }

    def 'remove until has anything to remove'() {
        given:
            String input = """..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@."""
        expect:
            printingDepartment.removeUntilSmthRemoved(new StringInput(input)) == 43
    }

    def 'part 2'() {
        given:
            Input input = new FileInput("day4.txt")
        expect:
            printingDepartment.removeUntilSmthRemoved(input) == 8345
    }
}
