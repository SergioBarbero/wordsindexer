package words.indexer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class WordsIndexer {

    private List<String> words;

    public WordsIndexer(String text) {
        this.words = Arrays.stream(text.toLowerCase().split("\\W+")).collect(toList());
    }

    /**
     * Gets the map with the information of the letter and words
     * @return map
     */
    public Map<Character, Set<String>> getLettersMap() {
        return getCharactersSet().stream().collect(toMap(Function.identity(), this::getContainedWordsByLetter));
    }

    /**
     * Gets a character set in lower case from the List of words
     * @return character set
     */
    private Set<Character> getCharactersSet() {
        return words.stream().flatMap(word -> word.chars().mapToObj(character -> (char) Character.toLowerCase(character))).collect(toSet());
    }

    /**
     * Gets Set of words that contains such letter
     * @param letter
     * @return set of words that contains the letter
     */
    private SortedSet<String> getContainedWordsByLetter(char letter) {
        return words.stream().filter(x -> x.contains(String.valueOf(letter).toLowerCase())).collect(Collectors.toCollection(TreeSet::new));
    }

}
