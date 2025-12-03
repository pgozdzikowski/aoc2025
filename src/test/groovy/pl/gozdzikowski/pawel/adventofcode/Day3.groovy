package pl.gozdzikowski.pawel.adventofcode

import pl.gozdzikowski.pawel.adventofcode.day3.Lobby
import pl.gozdzikowski.pawel.adventofcode.shared.input.FileInput
import pl.gozdzikowski.pawel.adventofcode.shared.input.Input
import pl.gozdzikowski.pawel.adventofcode.shared.input.StringInput
import spock.lang.Specification

class Day3 extends Specification{
    Lobby lobby = new Lobby()

    def 'should find sum of digits'() {
        given:
            String input = """987654321111111
811111111111119
234234234234278
818181911112111"""
        expect:
            lobby.findSumOfMaxVoltageOfLength(new StringInput(input), 2) == 357
    }

    def 'part 1'() {
        given:
            Input input = new FileInput("day3.txt")
        expect:
            lobby.findSumOfMaxVoltageOfLength(input, 2) == 17278
    }

    def 'part 2 sample'() {
        given:
            String input = """987654321111111
811111111111119
234234234234278
818181911112111"""
        expect:
            lobby.findSumOfMaxVoltageOfLength(new StringInput(input), 12) == 3121910778619
    }

    def 'part 2'() {
        given:
            Input input = new FileInput("day3.txt")
        expect:
            lobby.findSumOfMaxVoltageOfLength(input, 12) == 171528556468625
    }
}
