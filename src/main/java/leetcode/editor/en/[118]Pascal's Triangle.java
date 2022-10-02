package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

/**
Given an integer numRows, return the first numRows of Pascal's triangle. 

 In Pascal's triangle, each number is the sum of the two numbers directly above 
it as shown: 
 
 
 Example 1: 
 Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 
 Example 2: 
 Input: numRows = 1
Output: [[1]]
 
 
 Constraints: 

 
 1 <= numRows <= 30 
 

 Related Topics Array Dynamic Programming 👍 7511 👎 247

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(first);

        if (numRows == 1) {
            return list;
        }

        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        list.add(second);

        if (numRows == 2) {
            return list;
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(list.get(i-1).get(0));
            for (int j = 1; j < i; j++) {
                int tmpSum = list.get(i-1).get(j-1) + list.get(i-1).get(j);
                tmpList.add(tmpSum);
            }
            tmpList.add(list.get(i-1).get(i-1));
            list.add(tmpList);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
