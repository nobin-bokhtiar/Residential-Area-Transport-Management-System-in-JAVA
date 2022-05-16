import java.util.*;

import javax.swing.*;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int []UserID=new int[50];
		String[] UserPassword=new String[50];
		String []UserName=new String[50];
		String []UserAddress=new String[50];
		int []VehicleID=new int[20];
		String []VehicleNumber=new String[20];
		String []DriverName=new String[20];
		String []TypeOfVehicle=new String[20];
		int i=0;
		
		Scanner z=null;
		try {
			z=new Scanner(new File("User.txt"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		while (z.hasNext()) {
			UserID[i]=z.nextInt();
			UserPassword[i]=z.next();
			UserName[i]=z.next();
			UserAddress[i]=z.next();
			i++;
		}
		z.close();
		Scanner z1=null;
		try {
			z1=new Scanner(new File("Vehicle.txt"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		i=0;
		while (z1.hasNext()) {
			VehicleID[i]=z1.nextInt();
			VehicleNumber[i]=z1.next();
			DriverName[i]=z1.next();
			TypeOfVehicle[i]=z1.next();
			i++;
			
		}
		z1.close();
		
		do {
			switch (Integer.parseInt(JOptionPane.showInputDialog("1.Admin\n2.User\n3.Map\nChoose Option=>"))) {
			case 1:
				Admin a1=new Admin();
				if (a1.LogIn()) {
					int flag=0;
					do {
						switch (Integer.parseInt(JOptionPane.showInputDialog("1.View Infomation\n2.View Vehicle List\n3.Delete Vehicle\n4.View User List\n5.Delete A User Account\n6.Map\n7.LOG OUT\nChoose Option=>"))) {
						case 1:
							JOptionPane.showMessageDialog(null, "ID => 1971\nName => Nsu\nAddress => Bashundhara");
							break;
						case 2:
							for (int j = 0; j < VehicleID.length; j++) {
								if (VehicleNumber[j]!=null) {
									JOptionPane.showMessageDialog(null, "Vehicle ID =>"+VehicleID[j]+"Vehicle Number =>"+VehicleNumber[j]+"Driver Name =>"+DriverName[j]+"Type Of Vehicle =>"+TypeOfVehicle[j]);
								}
								
							}
							break;
						case 3:
							String q=JOptionPane.showInputDialog("Enter Vehicle Number OF Wanted Vehicle =>");
							int q1=-1;
							for (int j = 0; j < VehicleNumber.length; j++) {
								if(q.equals(VehicleNumber[j])) {
									q1=j;
									break;
								}
							}
							if(q1<0) {
								JOptionPane.showMessageDialog(null, "There is no account of this Vehicle Number");
							}
							else {
								if(Integer.parseInt(JOptionPane.showInputDialog("Press 1 to Confrom =>"))==1) {
									VehicleID[q1]=-1;
									VehicleNumber[q1]=null;
									DriverName[q1]=null;
									TypeOfVehicle[q1]=null;
									JOptionPane.showMessageDialog(null,"Vehicle Deleted..");
								}
								
							}
							
							break;
						case 4:
							for (int j = 0; j < UserID.length; j++) {
								if (UserPassword[j]!=null) {
									JOptionPane.showMessageDialog(null, "User ID =>"+UserID[j]+"User Name"+UserName[j]+"UserAddress"+UserAddress[j]);
								}
								
							}
							
							break;
						case 5:
							int w1=-1,w=Integer.parseInt(JOptionPane.showInputDialog("Enter The ID of the User =>"));
							for (int j = 0; j < UserID.length; j++) {
								if(w==UserID[j]) {
									w1=j;
								}
							}
							if(w1<0) {
								JOptionPane.showMessageDialog(null, "There is no account of this ID");
							}
							else {
								if(Integer.parseInt(JOptionPane.showInputDialog("Press 1 to Confrom =>"))==1) {
									UserID[w1]=-1;
									UserPassword[w1]=null;
									UserName[w1]=null;
									UserAddress[w1]=null;
									JOptionPane.showMessageDialog(null, "Account Deleted...");
								}
							}
							
							break;
						case 6:
							map();
							break;
						case 7:
							flag=1;
							break;

						default:
							JOptionPane.showMessageDialog(null, "Wrong Option.\nSorry....");
							break;
						}
					} while (flag==0);
				}
				
				break;
			case 2:
				switch (Integer.parseInt(JOptionPane.showInputDialog("1.LOG IN\n2.Create Account\nChoose Option => "))) {
				case 1:
					Person p1=new User();
					int flag1=0;
					if (p1.LogIn(UserID, UserPassword)) {
						do {
							switch (Integer.parseInt(JOptionPane.showInputDialog("1.View Informaton\n2.Eidt Information\n3.Search Vehicle\n4.Add Vehicle\n5.Tranport Available\n6.Delete Account\n7.Map\n8.LOG OUT\nChoose Option =>"))) {
							case 1:
								int k= p1.getI();
								JOptionPane.showMessageDialog(null, "Your Information :\nID =>"+UserID[k]+"\nName => "+UserName[k]+"Address => "+UserAddress[k]);
								break;
								
							case 2:
								switch (Integer.parseInt(JOptionPane.showInputDialog("1.Edit Name\n2.Edit Address\n3.Edit Password\nChoose Option:"))) {
								case 1:
									UserName[p1.getI()]=JOptionPane.showInputDialog("Enter New Name :");
									JOptionPane.showMessageDialog(null,"Name changed...");
									break;
								case 2:
									UserAddress[p1.getI()]=JOptionPane.showInputDialog("Enter New Address :");
									JOptionPane.showMessageDialog(null,"Address changed...");
									break;
								case 3:
									if(JOptionPane.showInputDialog("Enter Old Password =>").equals(UserPassword[p1.getI()])) {
										String ss=JOptionPane.showInputDialog("Enter New password :");
										if (JOptionPane.showInputDialog("Confirm New password :").equals(ss)) {
											UserPassword[p1.getI()]=JOptionPane.showInputDialog("Enter New password :");
											JOptionPane.showMessageDialog(null,"Password changed...");
										}
										else {
											JOptionPane.showMessageDialog(null, "Wrong Password");
										}
									}
									else {
										JOptionPane.showMessageDialog(null, "Wrong Password");
									}
									
									break;

								default:
									JOptionPane.showMessageDialog(null,"Wrong Option...");
									break;
								}
								break;
							case 3:
								String as=JOptionPane.showInputDialog("Enter Vehicle Number Of Wanted Vehicle =>");
								int flag3=0;
								i=0;
								for (int j = 0; j < VehicleNumber.length; j++) {
									if(VehicleNumber[j].equals(as)) {
										flag3=1;
										i=j;
									}
								}
								if(flag3==0) {
									JOptionPane.showMessageDialog(null, "There is no vehicle with this Number =>");
								}
								else {
									JOptionPane.showMessageDialog(null, "Vehicle ID =>"+VehicleID[i]+"Vehicle Number =>"+VehicleNumber[i]+"Driver Name =>"+DriverName[i]+"Type Of Vehicle =>"+TypeOfVehicle[i]);
								}
								break;
							case 4:
								i=0;
								String k1;
								do {
									k1 = JOptionPane.showInputDialog("Enter Vehicle Number =>");
									for (int j = 0; j < VehicleNumber.length; j++) {
										if(k1.equals(VehicleNumber[j])) {
											i=1;
											break;
										}
										else {
											i=0;
										}
									}
								} while (i==1);
								int k2;
								i=0;
								do {
									k2 = Integer.parseInt(JOptionPane.showInputDialog("Enter Vehicle ID =>"));
									for (int j = 0; j < VehicleID.length; j++) {
										if(k2==VehicleID[j]) {
											i=1;
											break;
										}
										else {
											i=0;
										}
									}
								} while (i==1);
								for (int j = 0; j < VehicleNumber.length; j++) {
									if(VehicleNumber[j]==null) {
										VehicleID[j]=k2;
										VehicleNumber[j]=k1;
										DriverName[j]=JOptionPane.showInputDialog("Enter Driver Name =>");
										TypeOfVehicle[j]=JOptionPane.showInputDialog("Enter Type Of Vehicle =>");
										JOptionPane.showMessageDialog(null, "Vehicle added");
										break;
									}
								}
								
								
								break;
							case 5:
								AvailableVehicle av1 = new AvailableVehicle();
								switch (Integer.parseInt(JOptionPane.showInputDialog("1.Bus\n2.Rickshaw\nChoose Option =>"))) {
								case 1:
									av1.buses();
									
									break;
								case 2:
									av1.RickshawCost();
									break;

								default:
									break;
								}
								break;
							case 6:
								if(JOptionPane.showInputDialog("Enter PassWord => ").equals(UserPassword[p1.getI()])) {
									if(Integer.parseInt(JOptionPane.showInputDialog("Press 1 to Confirm =>"))==1) {
										UserID[p1.getI()]=-1;
										UserPassword[p1.getI()]=null;
										UserName[p1.getI()]=null;
										UserAddress[p1.getI()]=null;
										
									}
									else {
										JOptionPane.showMessageDialog(null, "Account is not Deleted");
									}
								}
								else {
									JOptionPane.showMessageDialog(null, "Wrong PassWord");
									
								}
								break;
							case 7:
								map();
								break;
							case 8:
								flag1=1;
								break;
								

							default:
								JOptionPane.showMessageDialog(null, "Wrong Option ....");
								break;
							}
						} while (flag1==0);
					}
					
					break;
				case 2:
					i=0;
					int s;
					do {
						s=Integer.parseInt(JOptionPane.showInputDialog("Enter A New ID=>"));
						for (int j = 0; j < UserID.length; j++) {
							if(s==UserID[j]) {
								i=1;
								break;
							}
							else {
								i=0;
							}
						}
						if(i==1)
							JOptionPane.showMessageDialog(null, "This Id Has been Taken.\nSorry......");
						
					} while (i==1);
					for (int j = 0; j < UserID.length; j++) {
						if(UserName[j]==null) {
							UserID[j]=s;
							UserPassword[j]=JOptionPane.showInputDialog("Enter a Password =>");
							UserName[j]=JOptionPane.showInputDialog("Enter Name =>");
							UserAddress[j]=JOptionPane.showInputDialog("Enter address=>");
							JOptionPane.showMessageDialog(null, "Account Has been Created...");
							break;
						}
					}
					break;

				default:
					JOptionPane.showMessageDialog(null, "Wrong Option....");
					break;
				}
				break;
			case 3:
				map();
				break;

			default:
				JOptionPane.showMessageDialog(null, "Wrong Option");
				break;
			}
			
			File a=new File("User.txt");
			FileWriter e1= new FileWriter(a);
			for (int j = 0; j < UserID.length; j++) {
				if(UserID[j]>=0&&UserAddress[j]!=null&&UserName[j]!=null&&UserPassword[j]!=null) {
					e1.write(UserID[j]+" ");
					e1.write(UserPassword[j]+" ");
					e1.write(UserName[j]+" ");
					e1.write(UserAddress[j]+" \n");
				}
			}
			e1.close();
			File b =new File("Vehicle.txt");
			FileWriter e2=new FileWriter(b);
			for (int j = 0; j < VehicleID.length; j++) {
				if(VehicleID[j]>=0&&VehicleNumber[j]!=null&&DriverName[j]!=null&&TypeOfVehicle[j]!=null) {
					e1.write(VehicleID[j]+" ");
					e1.write(VehicleNumber[j]+" ");
					e1.write(DriverName[j]+" ");
					e1.write(TypeOfVehicle[j]+" \n");
				}
			}
			e2.close();
			
		} while (Integer.parseInt(JOptionPane.showInputDialog("Enter 1 to Continue=>"))==1);
		
		

	}

	public static void map() {
		
	}
}
