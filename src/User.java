import javax.swing.JOptionPane;

public class User extends Person{
	private int i;

	/**
	 * 
	 */
	public User() {
		super();
	}
	
	
	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}


	
	public boolean LogIn(int []Id,String []Pass) {
		int flag =1;
		int a=Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
		for (int i1 = 0; i1 < Id.length; i1++) {
			
			if (a==Id[i1]) {
				if(JOptionPane.showInputDialog("Enter Password: ").equals(Pass[i1])) {
					flag = 0;
					i=i1;
					break;
				}
			}
		}
		if(flag==0)
			return true;
		else 
			return false;
		
		
		
		
	}

}
