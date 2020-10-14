class Solution 
{
	public List<List<Integer>> fourSum(int[] A, int target) 
	{
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(A);

		for(int i = 0; i < A.length; i++) 
		{
			if(i == 0 || A[i] != A[i - 1])
			{
				threeSum(list, A, i + 1, A.length - 1, target - A[i], A[i]);
			}	
		}
		return list;
	}

	// Three Sum Problem: list.add(Arrays.asList(w, the three numbers))
	private void threeSum(List<List<Integer>> list, int[] A, int start, int end, int target, int w) 
	{
		for(int j = start; j < end; j++) 
		{
			if(j == start || A[j] != A[j - 1])
			{
				twoSum(list, A, j + 1, A.length - 1, target - A[j], w, A[j]);
			}
		}
	}

	// Two Sum Problem: list.add(Arrays.asList(w, x, the two numbers))
	private void twoSum(List<List<Integer>> list, int[] A, int start, int end, int target, int w, int x) 
	{
		while(start < end) 
		{
			int y = A[start];
			int z = A[end];

			if(y + z == target) 
			{
				list.add(Arrays.asList(w, x, y, z));
				while(start < end && A[start] == A[start + 1]) start++;
				while(start < end && A[end] == A[end - 1]) 	   end--;
                start++; end--;
			}
			else if(y + z < target)
			{
				start++;
			}
			else
			{
				end--;
			}
		}
	}
}
