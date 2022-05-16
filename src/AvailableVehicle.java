import java.io.*;
import java.util.*;

import javax.swing.*;

public class AvailableVehicle implements TravelingCost {
public AvailableVehicle() {
		
	}
	public void RickshawCost() {
		switch (Integer.parseInt(JOptionPane.showInputDialog("1.A-BLOCK\n2.B-BLOCK\n3.C-BLOCK\n4.D-BLOCK\n5.G-BlOCK\n6.H-BLOCK\n7.I-BLOCK\n8.Distace\nChoose Option => "))) {
		case 1:
		case 2:
		case 3:
			JOptionPane.showMessageDialog(null, "The Cost is => "+TravelingCost.BLOCK_A_B_C);
			break;
		case 4:
		case 5:
			JOptionPane.showMessageDialog(null, "The Cost is => "+ TravelingCost.BLOCK_D_E);
			break;
		case 6:
		case 7:
			JOptionPane.showMessageDialog(null, "The Cost is => "+TravelingCost.BLOCK_H_I);
			break;
		case 8:
			JOptionPane.showMessageDialog(null,"The Cost is => "+ Integer.parseInt(JOptionPane.showInputDialog("Enter Distance"))*TravelingCost.Distance);
			
			break;
			

		default:
			JOptionPane.showMessageDialog(null, "Wrong Option");
			break;
		}
		
	}
	public void buses() {
		Scanner r = null;
		try {
			r=new Scanner(new File("Buses.txt"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		while (r.hasNext()) {
			JOptionPane.showMessageDialog(null,r.next()+"\n");
		}
	}

}
