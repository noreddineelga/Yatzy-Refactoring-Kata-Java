import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Yatzy {

    private List<Integer> dices;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dices = List.of(d1, d2, d3, d4, d5);
    }

    public int chance()
    {
        return dices.stream().reduce(Integer::sum).orElse(0);
    }

    public int yatzy()
    {
        if(dices.stream().distinct().count() == 1)
            return 50;
        return 0;
    }

    public int valCount(int val) {
        return (int) dices.stream().filter(d -> d == val).count() * val;
    }

    public int score_pairs(boolean onePair) {

        Stream<Integer> pairsStream = getDicesOccurrenceMap().entrySet().stream()
            .filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey() * 2);
        if(onePair){
            return pairsStream.max(Integer::compareTo).orElse(0);
        }
        return pairsStream.reduce(Integer::sum).orElse(0);
    }

    public int number_of_a_kind(int numberOfKind)
    {
        return getDicesOccurrenceMap().entrySet().stream()
            .filter(entry -> entry.getValue() >= numberOfKind).mapToInt(entry -> entry.getKey() * numberOfKind).sum();
    }

    public int straight(boolean isSmall)
    {
        if(dices.stream().distinct().count() == 5) {
            int min = dices.stream().min(Integer::compareTo).orElse(0);
            if( isSmall && min == 1)  return  15;
            if( !isSmall && min != 1)  return  20;
        }
        return 0;
    }

    public int fullHouse()
    {
        if(dices.stream().distinct().count() == 2) {
            return 25;
        }
        return 0;
    }

    private Map<Integer, Long> getDicesOccurrenceMap() {
        return dices.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
    }
}



