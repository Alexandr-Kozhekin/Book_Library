package servis.BookServis;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueWordFinder {

   public Set<String> find(String text) {

        String word [] = text.split(" ");

        return Arrays.stream(word).collect(Collectors.toSet());

    }

}
