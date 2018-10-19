import org.junit.jupiter.api.Test;

public class TestHashTable {
    @Test
    public void testHashTable() {
        HashTable<String, Integer>map = new HashTable<>();
        map.add("Charizard",1 );
        map.add("is",2 );
        map.add("the",4 );
        map.add("best.",5 );

        assert(map.get("Charizard") == 1);
        assert(map.get("is") == 2);
    }
}
