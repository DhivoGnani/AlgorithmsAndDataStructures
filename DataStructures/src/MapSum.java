import java.util.HashMap;

// LeetCode (Trie Question): https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1058/
class MapSum {

    public class MapSumNode
    {
        public char c;
        public boolean isWord;
        public int runningValue;

        public HashMap<Character, MapSumNode> children;

        public MapSumNode(char c)
        {
            this.c = c;
            children = new HashMap<>();
        }

    }

    private MapSumNode root;
    private HashMap<String, Integer> valueMap;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new MapSumNode(' ');
        valueMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        MapSumNode curr = root;

        int previousValue = valueMap.getOrDefault(key, 0);
        valueMap.put(key, val);

        int delta = val - previousValue;

        for(int i = 0; i < key.length(); i++)
        {
            char c = key.charAt(i);
            if(!curr.children.containsKey(c))
            {
                curr.children.put(c, new MapSumNode(c));
            }

            curr =  curr.children.get(c);
            curr.runningValue += delta;
        }

        System.out.println(curr.c);
        curr.isWord = true;
    }

    public int sum(String prefix) {
        int sum = 0;

        MapSumNode curr = root;

        for(int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if(curr.children.get(c) == null)
            {
                return 0;
            }

            curr = curr.children.get(c);
        }

        return curr.runningValue;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */