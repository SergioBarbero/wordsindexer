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

    public Map<Character, Set<String>> getLettersMap() {
        return getCharactersSet().stream().collect(toMap(Function.identity(), this::getContainedWordsByLetter));
    }

    private Set<Character> getCharactersSet() {
        return words.stream().flatMap(word -> word.chars().mapToObj(character -> (char) Character.toLowerCase(character))).collect(toSet());
    }

    private SortedSet<String> getContainedWordsByLetter(char letter) {
        return words.stream().filter(x -> x.contains(String.valueOf(letter).toLowerCase())).collect(Collectors.toCollection(TreeSet::new));
    }

}
