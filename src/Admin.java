import javax.swing.JOptionPane;

public class Admin {
	

	/**
	 * 
	 */
	public Admin() {
		
	}

	
	
	public boolean LogIn() {
		int flag=0;
		if(Integer.parseInt(JOptionPane.showInputDialog("Enter ID=>"))==1971) {
			do {
				if(JOptionPane.showInputDialog("Enter Password=>").equals("password")) {
					flag=1;
					break;
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Password\nSorry....");
				}
			} while (flag==0);
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Wrong ID\nSorry.....");
		}
		if(flag==1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

}
