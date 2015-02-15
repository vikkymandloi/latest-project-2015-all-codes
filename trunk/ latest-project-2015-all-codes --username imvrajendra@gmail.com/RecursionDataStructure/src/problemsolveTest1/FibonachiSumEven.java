package problemsolveTest1;

public class FibonachiSumEven {
	
	public static int getSum(int range) {
		int a = 1;
		int b = 2;
		int c = 0;
		int sum = 2;
		while(b<=range || a<=range) {
			c = a+b;
			a=b;
			b=c;
			if(c%2==0)
				sum=sum+c;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(getSum(4000000));
	}

}
