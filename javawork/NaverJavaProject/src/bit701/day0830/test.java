package bit701.day0830;

public class test {

	public static void main(String[] args) {

		for(int i =2; i<10; i++) {
			for(int j=1; j<10; j++)
			System.out.println(i+"x"+j+"="+ i*j);
			
		}
		
		for(int i =1; i<10; i++) {
			for(int j=2; j<10; j++)
			System.out.print(j+"x"+i+"="+ i*j+"  ");
			System.out.println();
			
		}
		
		for(int i =1; i<10; i++) {
			for(int j=1; j<i; j++) {
				System.out.print("*");
				
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		for(int i =1; i<10; i++) {
			for(int j=10; j>i; j--) {
				System.out.print("*");
				
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		for(int i =1; i<10; i++) {
			for(int j=10; j>0; j--) {
				if(i>j){
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
				
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		for(int i =1; i<10; i++) {
			for(int j=1; j<10; j++) {
				if(i<=j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		

		for(int i =0; i<10; i++) {
			for(int j=1; j<10-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	
		
		
	}
	
}
