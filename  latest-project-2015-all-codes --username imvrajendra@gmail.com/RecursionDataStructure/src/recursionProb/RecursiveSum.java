package recursionProb;

public class RecursiveSum {

	public static boolean groupSum(int start, int[] nums, int target) {
		if (target == 0) {
			return true;
		}
		if (start >= nums.length) {
			return false;
		}
		for (int i = start; i < nums.length; ++i) {
			if (nums[i] > target) {
				continue;
			}
			if (groupSum(i + 1, nums, target - nums[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(groupSum(0, new int[]{2, 4, 8}, 10));
	}
}
