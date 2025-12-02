package pl.gozdzikowski.pawel.adventofcode

import pl.gozdzikowski.pawel.adventofcode.day1.SecretEntrance
import pl.gozdzikowski.pawel.adventofcode.shared.input.FileInput
import pl.gozdzikowski.pawel.adventofcode.shared.input.Input
import pl.gozdzikowski.pawel.adventofcode.shared.input.StringInput
import spock.lang.Specification

class Day1 extends Specification {

    SecretEntrance secretEntrance = new SecretEntrance()
    //The dial starts by pointing at 50.
    //The dial is rotated L68 to point at 82.
    //The dial is rotated L30 to point at 52.
    //The dial is rotated R48 to point at 0.
    //The dial is rotated L5 to point at 95.
    //The dial is rotated R60 to point at 55.
    //The dial is rotated L55 to point at 0.
    //The dial is rotated L1 to point at 99.
    //The dial is rotated L99 to point at 0.
    //The dial is rotated R14 to point at 14.
    //The dial is rotated L82 to point at 32.

    def 'should count number of dials'() {
        given:
        String input = """L68
L30
R48
L5
R60
L55
L1
L99
R14
L82"""
        expect:
            secretEntrance.countHowManyMoved(new StringInput(input)).left() == 3
    }

    def 'solution 1'() {
        given:
            Input input = new FileInput("day1.txt")
        expect:
            secretEntrance.countHowManyMoved(input).left() == 1145
    }

    def 'should count number of dials part2'() {
        given:
            String input = """L68
L30
R48
L5
R60
L55
L1
L99
R14
L82"""
        expect:
            secretEntrance.countHowManyMoved(new StringInput(input)).right() == 6
    }

    def 'solution 2'() {
        given:
            Input input = new FileInput("day1.txt")
        expect:
            secretEntrance.countHowManyMoved(input).right() == 6561

    }

}
