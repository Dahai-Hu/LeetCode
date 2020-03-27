package aimoffer;

/**
 * @hurusea
 * @create2020-03-19 11:44
 */
public class findRepeatNumber {
    public static void main(String[] args) {
        findRepeatNumber question03 = new findRepeatNumber();
        int[] nums ={3, 1, 2, 3};
        question03.findRepeatNumber(nums);
    }

    public int findRepeatNumber(int[] nums) {
        int repeat=-1;
        for (int i=0;i<nums.length;i++){
            for (int j = 0; j <nums.length; j++) {
                if (i!=j&&nums[i] == nums[j]) {
                    repeat=nums[i];
                    break;
                }
            }
            if (repeat!=-1) {
                break;
            }
        }
        return repeat;
    }
}
