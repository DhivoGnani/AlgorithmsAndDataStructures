import java.util.HashMap;
import java.util.Map;

public class Trie
{
    // Array Implementation
    public class TrieNode
    {
        public static final int N = 26;
        public TrieNode[] children = new TrieNode[N];
    }

    // Map Implementation
    // Slower than array implementation, but uses less space since we only store children nodes that are needed.
    // More flexible because not limited by fix length and fixed range.
    public class TrieNodeMap
    {

        boolean isWord;
        public Map<Character, TrieNodeMap> children = new HashMap<>();
    }

    TrieNodeMap root;

    public Trie()
    {
        root = new TrieNodeMap();
    }

    public void insert(String word)
    {
        TrieNodeMap curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children.get(c) == null)
            {
                curr.children.put(c, new TrieNodeMap());
            }

            curr = curr.children.get(c);
        }

        curr.isWord = true;
    }

    public boolean isWord(String word)
    {
        TrieNodeMap curr = root;

        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(curr.children.get(c) == null)
            {
                return false;
            }

            curr = curr.children.get(c);
        }

        return curr.isWord;
    }

    public boolean startsWord(String prefix)
    {
        TrieNodeMap curr = root;

        for(int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if(curr.children.get(c) == null)
            {
                return false;
            }

            curr = curr.children.get(c);
        }

        return true;
    }

}
