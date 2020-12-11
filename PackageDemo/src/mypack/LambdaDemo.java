package mypack;

interface MyFunc
{
	int func(int n);
}

public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=10;
		MyFunc mylambda = (n)->{
			int a = 2;
			int v = num + n;
//			num++;
			a++;
			return v;
		};
		
		System.out.println(mylambda.func(2));
		
//		num=9;

	}

}
