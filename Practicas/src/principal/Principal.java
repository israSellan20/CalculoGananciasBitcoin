package principal;

public class Principal {
	public static void main(String[] args ) {
		 String str_Sample = "a1";
	        System.out.println("Compare To 'a' b is : " + str_Sample.compareTo("a2"));
	        str_Sample = "b";
	        System.out.println("Compare To 'b' a is : " + str_Sample.compareTo("a"));
	        str_Sample = "b";
	        System.out.println("Compare To 'b' b is : " + str_Sample.compareTo("b"));
	}
}
