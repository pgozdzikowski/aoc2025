package pl.gozdzikowski.pawel.adventofcode

import pl.gozdzikowski.pawel.adventofcode.day6.TrashCompactor
import pl.gozdzikowski.pawel.adventofcode.shared.input.FileInput
import pl.gozdzikowski.pawel.adventofcode.shared.input.Input
import pl.gozdzikowski.pawel.adventofcode.shared.input.StringInput
import spock.lang.Specification

class Day6 extends Specification{
    TrashCompactor trashCompactor = new TrashCompactor()
    def 'find sum of operations'() {
        given:
            String input = """123 328  51 64 
 45 64  387 23 
  6 98  215 314
*   +   *   +  
"""
        expect:
            trashCompactor.findSumOfOperations(new StringInput(input)) == 4277556
    }

    def 'part 1'() {
        given:
            Input input = new FileInput("day6.txt")
        expect:
            trashCompactor.findSumOfOperations(input) == 5733696195703
    }

    def 'find sum of operations 2'() {
        given:
            String input = """123 328  51 64 
 45 64  387 23 
  6 98  215 314
*   +   *   +  
"""
        expect:
            trashCompactor.findSumOfOperationsInColumns(new StringInput(input)) == 3263827
    }

    def 'part 2'() {
        given:
            Input input = new FileInput("day6.txt")
        expect:
            trashCompactor.findSumOfOperationsInColumns(input) == 10951882745757
    }
}
