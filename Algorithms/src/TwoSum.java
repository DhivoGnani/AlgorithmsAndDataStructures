// Problem: https://leetcode.com/problems/two-sum/

public class TwoSum {
    public int[] twoSum(int[] nums, int target)
    {
        //Map<Integer, Integer> characterIndiceMap = new HashMap<>();
        HashTable<Integer, Integer> characterIndiceMap = new HashTable<Integer, Integer>();

        int[] indices = {-1, -1};

        for(int i = 0; i < nums.length; i++)
        {
            int currentNum = nums[i];
            int difference = target - currentNum;
            if(characterIndiceMap.get(difference) != null)
            {
                indices[0] = characterIndiceMap.get(difference);
                indices[1] = i;
                return indices;
            }
            else
            {
                characterIndiceMap.add(currentNum, i);
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
