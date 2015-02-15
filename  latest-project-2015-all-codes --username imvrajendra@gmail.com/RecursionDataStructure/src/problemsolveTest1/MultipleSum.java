package problemsolveTest1;

public class MultipleSum {
	
	public static int multiple35Sum(int range) {
		int sum = 0;
		for(int i=0;i<=range;i++)
	    {
	        if((i%5==0)||(i%3==0))
	        {
	            sum=sum+i;
	        }
	    }
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("sum is = "+MultipleSum.multiple35Sum(1000-1));
	}

}
