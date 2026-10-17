import java.util.Arrays;

class Solution {
    static class Item {
        int num, idx, sum;

        public Item(int num, int idx, int sum) {
            this.num = num;
            this.idx = idx;
            this.sum = sum;
        }
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(nums[i], i, digitSum(nums[i]));
        }

        Arrays.sort(items, (a, b) -> {
            if (a.sum != b.sum) {
                return Integer.compare(a.sum, b.sum);
            }
            return Integer.compare(a.num, b.num);
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || items[i].idx == i) {
                continue;
            }

            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = items[curr].idx;
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    public int digitSum(int num) {
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            sum += (temp % 10);
            temp /= 10;
        }
        return sum;
    }
}