import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1053/
class ReplaceWords{
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split("\\s+");

        Set<String> dictSet = new HashSet<>();
        for(String word: dict) dictSet.add(word);

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < words.length; i++)
        {
            String word = words[i];

            String prefix = "";

            for(int j = 1; j <= word.length(); j++)
            {
                prefix = word.substring(0, j);
                if(dictSet.contains(prefix)) break;
            }

            if(builder.length() > 0) builder.append(" ");
            builder.append(prefix);
        }

        return builder.toString();

    }
}