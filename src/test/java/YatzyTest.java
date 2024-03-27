import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class YatzyTest {

    @ParameterizedTest
    @CsvSource(value = {"2,3,4,5,1:15", "3,3,4,5,1:16"}, delimiter = ':')
    public void chance_scores_sum_of_all_dice(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).chance());
    }

    @ParameterizedTest
    @CsvSource(value = {"4,4,4,4,4:50", "6,6,6,6,6:50", "6,6,6,6,3:0"}, delimiter = ':')
    public void yatzy_scores_50(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).yatzy());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5:1", "1,2,1,4,5:2", "6,2,2,4,5:0", "1,2,1,1,1:4"}, delimiter = ':')
    public void test_1s(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).valCount(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,2,6:4", "2,2,2,2,2:10"}, delimiter = ':')
    public void test_2s(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).valCount(2));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,2,3:6", "2,3,3,3,3:12"}, delimiter = ':')
    public void test_threes(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).valCount(3));
    }

    @ParameterizedTest
    @CsvSource(value = {"4,4,4,5,5:12", "4,4,5,5,5:8", "4,5,5,5,5:4"}, delimiter = ':')
    public void fours_test(String dices, int expected)
    {
        assertEquals(expected, yatzyFromString(dices).valCount(4));
    }

    @ParameterizedTest
    @CsvSource(value = {"4,4,4,5,5:10", "4,4,5,5,5:15", "4,5,5,5,5:20"}, delimiter = ':')
    public void fives(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).valCount(5));
    }

    @ParameterizedTest
    @CsvSource(value = {"4,4,4,5,5:0", "4,4,6,5,5:6", "6,5,6,6,5:18"}, delimiter = ':')
    public void sixes_test(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).valCount(6));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,4,3,5,6:6", "5,3,3,3,5:10", "5,3,6,6,5:12"}, delimiter = ':')
    public void one_pair(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).score_pairs(true));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,5,4,5:16", "3,3,5,5,5:16"}, delimiter = ':')
    public void two_Pair(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).score_pairs(false));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,3,4,5:9", "5,3,5,4,5:15", "3,3,3,3,5:9"}, delimiter = ':')
    public void three_of_a_kind(String dices, int expected)
    {
        assertEquals(expected, yatzyFromString(dices).number_of_a_kind(3));
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,3,3,5:12", "5,5,5,4,5:20", "3,3,3,3,3:12"}, delimiter = ':')
    public void four_of_a_knd(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).number_of_a_kind(4));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5:15", "2,3,4,5,1:15", "1,2,2,4,5:0"}, delimiter = ':')
    public void smallStraight(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).straight(true));
    }

    @ParameterizedTest
    @CsvSource(value = {"6,2,3,4,5:20", "2,3,4,5,6:20", "1,2,3,4,5:0"}, delimiter = ':')
    public void largeStraight(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).straight(false));
    }

    @ParameterizedTest
    @CsvSource(value = {"6,3,3,3,6:25", "1,1,1,3,3:25", "2,2,5,5,6:0", "2,3,4,5,6:0"}, delimiter = ':')
    public void fullHouse(String dices, int expected) {
        assertEquals(expected, yatzyFromString(dices).fullHouse());
    }

    private Yatzy yatzyFromString(String dices){
        String[] arr = dices.split(",");
        return new Yatzy(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]), Integer.valueOf(arr[2]), Integer.valueOf(arr[3]),
            Integer.valueOf(arr[4]));
    }
}
