import java.beans.Customizer;
import java.util.Scanner;


public class main {

	private static Scanner nhap;

	public static void main(String[] args) {
		System.out.print("Son");
		int a = 10;
		float b = (float) 11.5;
		System.out.print("\n");
		System.out.print(+a + b);
		nhap = new Scanner(System.in);
		int num = nhap.nextInt();
		System.out.print(num);
		
	}

}
