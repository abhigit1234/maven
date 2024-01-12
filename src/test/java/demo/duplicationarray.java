package demo;

public class duplicationarray{
	
	public static void main(String[] args) {
		
		String arr[]= {"naidu","hyd","abhi","babu","delhi"};
		boolean flag = false;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					System.out.println("duplicate value is: "+arr[i]);
					flag=true;
				}
			}
		}
		if(flag==false) {
			System.out.println("no duplicates found ");
		}
		
		
	}
	
	
	
}

