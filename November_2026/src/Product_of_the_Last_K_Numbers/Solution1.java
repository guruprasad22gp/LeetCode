package Product_of_the_Last_K_Numbers;

import java.util.ArrayList;

class ProductOfNumbers {
	ArrayList<Integer> list;

	public ProductOfNumbers() {
		list = new ArrayList<>();
	}

	public void add(int num) {
		list.add(num);
	}

	public int getProduct(int k) {
		int sum = 1;
		int i = list.size() - 1;

		while (k > 0 && i >= 0) {
			sum *= list.get(i);
			i--;
			k--;
		}

		return sum;
	}
}

public class Solution1 {
	public static void main(String[] args) {
		ProductOfNumbers pon = new ProductOfNumbers();
		pon.add(3);
		pon.add(0);
		pon.add(2);
		pon.add(5);
		pon.add(4);

		System.out.println(pon.getProduct(2));
		System.out.println(pon.getProduct(3));
		System.out.println(pon.getProduct(4));
		pon.add(8);
		System.out.println(pon.getProduct(2));
	}
}
