package practice;

interface methods {
	abstract void login();

	abstract void gettitle();

	abstract void logout();

}

public class test {

	
	public	void login() {
		System.out.println("login");
	
	}
	public void gettitle() {
		System.out.println("gettitle");
	}
	public void logout() {
		System.out.println("logout");
	}
	
	public static void main(String[] args) {
		test t = new test();
		t.gettitle();
		t.login();
		t.logout();
		
	}
}