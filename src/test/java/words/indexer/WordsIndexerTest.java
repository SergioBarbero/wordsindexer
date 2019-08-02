package words.indexer;

import org.junit.Test;
import java.util.*;
import static junit.framework.TestCase.assertEquals;

public class WordsIndexerTest {

    @Test
    public void getLettersMapTest() {
        WordsIndexer indexer = new WordsIndexer("ala ma kota, kot koduje w Javie Kota");
        Map<Character, Set<String>> actual = indexer.getLettersMap();
        Map<Character, Set<String>> expected = new HashMap<>();
        expected.put('a', new TreeSet<>(Set.of("ala", "ma", "kota", "javie")));
        expected.put('d', new TreeSet<>(Set.of("koduje")));
        expected.put('e', new TreeSet<>(Set.of("koduje", "javie")));
        expected.put('l', new TreeSet<>(Set.of("ala")));
        expected.put('m', new TreeSet<>(Set.of("ma")));
        expected.put('k', new TreeSet<>(Set.of("koduje", "kot", "kota")));
        expected.put('o', new TreeSet<>(Set.of("koduje", "kot", "kota")));
        expected.put('t', new TreeSet<>(Set.of("kot", "kota")));
        expected.put('w', new TreeSet<>(Set.of("w")));
        expected.put('j', new TreeSet<>(Set.of("koduje", "javie")));
        expected.put('v', new TreeSet<>(Set.of("javie")));
        expected.put('u', new TreeSet<>(Set.of("koduje")));
        expected.put('i', new TreeSet<>(Set.of("javie")));
        assertEquals(expected, actual);
    }

}
