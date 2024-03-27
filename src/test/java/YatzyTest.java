import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        Yatzy yatzy1 = new Yatzy(2,3,4,5,1);
        Yatzy yatzy2 = new Yatzy(3,3,4,5,1);
        int expected = 15;
        int actual = yatzy1.chance();
        assertEquals(expected, actual);
        assertEquals(16, yatzy2.chance());
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        Yatzy yatzy1 = new Yatzy(4,4,4,4,4);
        Yatzy yatzy2 = new Yatzy(6,6,6,6,6);
        Yatzy yatzy3 = new Yatzy(6,6,6,6,3);
        assertEquals(expected, yatzy1.yatzy());
        assertEquals(expected, yatzy2.yatzy());
        assertEquals(0, yatzy3.yatzy());
    }

    @Test public void test_1s() {
        Yatzy yatzy1 = new Yatzy(1,2,3,4,5);
        Yatzy yatzy2 = new Yatzy(1,2,1,4,5);
        Yatzy yatzy3 = new Yatzy(6,2,2,4,5);
        Yatzy yatzy4 = new Yatzy(1,2,1,1,1);
        assertEquals(1, yatzy1.valCount(1));
        assertEquals(2, yatzy2.valCount(1));
        assertEquals(0, yatzy3.valCount(1));
        assertEquals(4, yatzy4.valCount(1));
    }

    @Test
    public void test_2s() {
        Yatzy yatzy1 = new Yatzy(1,2,3,2,6);
        Yatzy yatzy2 = new Yatzy(2,2,2,2,2);
        assertEquals(4, yatzy1.valCount(2));
        assertEquals(10, yatzy2.valCount(2));
    }

    @Test
    public void test_threes() {
        Yatzy yatzy1 = new Yatzy(1,2,3,2,3);
        Yatzy yatzy2 = new Yatzy(2,3,3,3,3);
        assertEquals(6, yatzy1.valCount(3));
        assertEquals(12, yatzy2.valCount(3));
    }

    @Test
    public void fours_test() 
    {
        Yatzy yatzy1 = new Yatzy(4,4,4,5,5);
        Yatzy yatzy2 = new Yatzy(4,4,5,5,5);
        Yatzy yatzy3 = new Yatzy(4,5,5,5,5);
        assertEquals(12, yatzy1.valCount(4));
        assertEquals(8, yatzy2.valCount(4));
        assertEquals(4, yatzy3.valCount(4));
    }

    @Test
    public void fives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).valCount(5));
        assertEquals(15, new Yatzy(4,4,5,5,5).valCount(5));
        assertEquals(20, new Yatzy(4,5,5,5,5).valCount(5));
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Yatzy(4,4,4,5,5).valCount(6));
        assertEquals(6, new Yatzy(4,4,6,5,5).valCount(6));
        assertEquals(18, new Yatzy(6,5,6,6,5).valCount(6));
    }

    @Test
    public void one_pair() {
        assertEquals(6, new Yatzy(3,4,3,5,6).score_pairs(true));
        assertEquals(10, new Yatzy(5,3,3,3,5).score_pairs(true));
        assertEquals(12, new Yatzy(5,3,6,6,5).score_pairs(true));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, new Yatzy(3,3,5,4,5).score_pairs(false));
        assertEquals(16, new Yatzy(3,3,5,5,5).score_pairs(false));
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, new Yatzy(3,3,3,4,5).number_of_a_kind(3));
        assertEquals(15, new Yatzy(5,3,5,4,5).number_of_a_kind(3));
        assertEquals(9, new Yatzy(3,3,3,3,5).number_of_a_kind(3));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, new Yatzy(3,3,3,3,5).number_of_a_kind(4));
        assertEquals(20, new Yatzy(5,5,5,4,5).number_of_a_kind(4));
        assertEquals(12, new Yatzy(3,3,3,3,3).number_of_a_kind(4));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, new Yatzy(1,2,3,4,5).straight(true));
        assertEquals(15, new Yatzy(2,3,4,5,1).straight(true));
        assertEquals(0, new Yatzy(1,2,2,4,5).straight(true));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, new Yatzy(6,2,3,4,5).straight(false));
        assertEquals(20, new Yatzy(2,3,4,5,6).straight(false));
        assertEquals(0, new Yatzy(1,2,3,4,5).straight(false));
    }

    @Test
    public void fullHouse() {
        assertEquals(25, new Yatzy(6,3,3,3,6).fullHouse());
        assertEquals(25, new Yatzy(1,1,1,3,3).fullHouse());
        assertEquals(0, new Yatzy(2,2,5,5,6).fullHouse());
        assertEquals(0, new Yatzy(2,3,4,5,6).fullHouse());
    }
}
