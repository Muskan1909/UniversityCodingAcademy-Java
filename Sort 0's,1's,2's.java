class Solution {
    public void sortColors(int[] nums) {
            int n = nums.length;
		        HashMap <Integer,Integer> hm = new HashMap<Integer,Integer>();
            for(int j=0;j<n;j++){
              if(hm.containsKey(nums[j])){
              int val = hm.get(nums[j]);
                  hm.put(nums[j],++val);
              }
		        else{
                 hm.put(nums[j],1);
		          }
		      }
                        
            int start=0;
            if(hm.containsKey(0)){
                int count0 = hm.get(0);
                
                for(int p=0;p<count0;p++){
                    nums[start] = 0;
                    start++;
                }	
            }
            if(hm.containsKey(1)){
                int count1 = hm.get(1);
              
                for(int p=0;p<count1;p++){
                    nums[start]=1;
                    start++;
                }
            }
            if(hm.containsKey(2)){
                int count2 = hm.get(2);
               
                for(int p=0;p<count2;p++){
                    nums[start]=2;
                    start++;
                }
            }
            for(int k=0;k<n;k++)
                System.out.print(nums[k]+ " ");
    }
}
