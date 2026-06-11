import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        int[] nums = new int[] { -4, -1, -1, 0, 1, 2 };

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int fix = nums[i];

            if (fix > 0) {
                break;
            }

            // skip duplicate fix
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            while (left < right) {
                int sum = fix + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(List.of(fix, nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }

        // System.out.println(result);

        double target = 4;

        double[] weights = new double[] { 2.5, 3.5, 4, 6 };

        int left = 0;
        int right = weights.length - 1;
        int weightIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (weights[mid] - target < 1e-7) {
                weightIndex = mid;
                break;
            } else if (weights[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        LinkedList linkedList = new LinkedList(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.append(8);
        // linkedList.printList();

        linkedList.removeLast();
        // linkedList.printList();

        linkedList.prepend(3);
        // linkedList.printList();

        linkedList.removeFirst();
        // linkedList.printList();

        // System.out.println(linkedList.get(3).value + "\n");

        linkedList.set(2, weightIndex);
        // linkedList.printList();

        linkedList.insert(1, weightIndex);
        // linkedList.printList();

        linkedList.remove(4);
        linkedList.printList();

        LinkedList linkedList1 = new LinkedList(1);
        linkedList1.append(2);
        linkedList1.append(3);
        linkedList1.append(4);
        linkedList1.append(5);
        linkedList1.append(6);

        linkedList1.findKthFromEnd(1);

        //linkedList.removeDuplicates();
        linkedList.printList();

        //linkedList.partitionList(2);
        linkedList.printList();

        linkedList.append(6);

        LinkedList revLinkedList = new LinkedList(1);
        revLinkedList.append(2);
        revLinkedList.append(3);
        revLinkedList.append(4);
        revLinkedList.append(5);
        revLinkedList.append(6);
        revLinkedList.append(7);
        revLinkedList.printList();
        //revLinkedList.reversBetween(1, 3);
        //revLinkedList.printList();
        revLinkedList.swapInPais();
        revLinkedList.printList();

    }
}

class Transaction {
    @Override
    public String toString() {
        return "Transaction [txId=" + txId + ", accId=" + accId + ", amount=" + amount + ", ts=" + ts + "]";
    }

    private String txId;
    private String accId;
    private int amount;
    private int ts;

    public Transaction(String txId, String accId, int amount, int ts) {
        this.txId = txId;
        this.accId = accId;
        this.amount = amount;
        this.ts = ts;
    }

    public String getTxId() {
        return this.txId;
    }

    public String getAccId() {
        return this.accId;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getTs() {
        return this.ts;
    }
}

class NumArray {

    // Step 1: declare your prefix array here

    int[] prefix;

    // Step 2: constructor — build the prefix array
    // nums = [-2, 0, 3, -5, 2, -1]
    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        prefix[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

    }

    // Step 3: answer range query in O(1)
    public int sumRange(int left, int right) {

        return prefix[right + 1] - prefix[left];

    }
}

/*
 * Input: nums = [1, 1, 1], k = 2
 * Output: 2
 * Explanation: [1,1] appears twice — index(0,1) and index(1,2)
 */

class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;

        // 1. a HashMap to store prefixSum → frequency

        Map<Integer, Integer> map = new HashMap<>();

        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (prefix[i + 1] - prefix[i] == k) {
                map.put(null, null);
            }
        }

        return count;
    }

    public boolean isPalindrome(String s) {

        // 1. two pointers — left and right
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (Character.isLetterOrDigit(s.charAt(left)) && Character.isLetterOrDigit(s.charAt(right))) {
                char c = Character.toLowerCase(s.charAt(left));
                char d = Character.toLowerCase(s.charAt(right));
                if (c != d)
                    return false;
                left++;
                right--;
            } else if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();

        Map<Character, Integer> charOccMap = new HashMap<>();

        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < chars.length; right++) {
            if (charOccMap.containsKey(chars[right]) && charOccMap.get(chars[right]) >= left) {
                left = charOccMap.get(chars[right]) + 1;
            }
            charOccMap.put(chars[right], right);
            maxLen = Math.max(maxLen, right - left + 1);

        }

        System.out.println(maxLen);

        return maxLen;
    }
}
