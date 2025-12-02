package pl.gozdzikowski.pawel.adventofcode

import pl.gozdzikowski.pawel.adventofcode.day2.GiftShop
import pl.gozdzikowski.pawel.adventofcode.shared.input.FileInput
import pl.gozdzikowski.pawel.adventofcode.shared.input.Input
import pl.gozdzikowski.pawel.adventofcode.shared.input.StringInput
import spock.lang.Specification

class Day2 extends Specification {

    GiftShop giftShop = new GiftShop()

    def 'should identify as invalid id'() {
        given:
            String input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"
        expect:
            giftShop.sumOfInvalidRepeatedOnce(new StringInput(input)) == 1227775554
    }

    def 'solution 1'() {
        given:
            Input input = new FileInput("day2.txt")
        expect:
            giftShop.sumOfInvalidRepeatedOnce(input) == 24747430309
    }

    def 'example part 2'() {
        given:
            String input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"
        expect:
            giftShop.sumOfInvalidRepeatedManyTimes(new StringInput(input)) == 4174379265
    }

    def 'solution 2'() {
        given:
            Input input = new FileInput("day2.txt")
        expect:
            giftShop.sumOfInvalidRepeatedManyTimes(input) == 30962646823
    }
}
