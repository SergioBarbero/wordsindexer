package words.indexer;

import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        WordsIndexer indexer = new WordsIndexer("ala ma kota, kot koduje w Javie Kota");
        Map<Character, Set<String>> map = indexer.getLettersMap();
        for (Map.Entry<Character, Set<String>> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
        }
    }
}
