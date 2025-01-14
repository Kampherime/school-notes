class Main {
    public static void main(String[] args) {
        int[][] arr = new int[5][10];
        for(int i = 0; i < arr.length; i++) {
            sum = 0;
            inner_arr = arr[i];
            for(int j = 0; j < inner_arr.length; j++) {
                sum += inner_arr[j];
            }
            System.out.println(sum);
            
        }
    }
}
