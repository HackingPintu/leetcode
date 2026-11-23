class ProductOfNumbers {

    private ArrayList<Integer> list;

    public ProductOfNumbers() {
        this.list = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int size = list.size() - 1;
        int result = 1;
        for (int i = 0; i < k; i++){
            result *= list.get(size--);
        }
        return result;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */