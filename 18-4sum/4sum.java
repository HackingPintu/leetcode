class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list= new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j !=(i+1) && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum=nums[i]+nums[j];
                    sum+=nums[k];
                    sum+=nums[l];
                    if(sum>target){
                        l--;
                    }else if(sum<target){
                        k++;
                    }else{
                        list.add(List.of(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                        while(nums[k]==nums[k-1]&&k<l)k++;
                        while(nums[l]==nums[l+1]&&k<l)l--;
                    }
                }
            }
        }
        return list;
    }
}