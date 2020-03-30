package code;
import java.awt.*;
import javax.swing.*;
public class EffectiveAtomicNumberRegolith extends JPanel{
	
	//writing useful functions to calculate Efective Atomic Number of Regolith
	//here is the link to a useful resource https://en.wikipedia.org/wiki/Effective_atomic_number
	public static double ofCompounds(double[] atoms, double[] rates) {
		double alpha = 0;
		for (int i = 0; i < atoms.length; i++) {
			alpha = alpha + Math.pow(atoms[i], 2.94) * rates[i];
		}
		return Math.pow(alpha, 0.340136054421769);
	}
	
	public static double ofGeneral(double[] atoms, double[] rates) {
		double alpha = 0;
		for (int i = 0; i < atoms.length; i++) {
			alpha += Math.pow(atoms[i], 2.94) * rates[i];
		}
		return Math.pow(alpha, 0.340136054421769);

	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		//for graphics and barcharts needed to visulize the data
		EffectiveAtomicNumberRegolith rects = new EffectiveAtomicNumberRegolith();
	    JFrame frame = new JFrame("Rectangles");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(rects);
	    frame.setSize(800, 720);
	    frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		//percentages array holds percentages from the proposal of the oxides and elelements of the regolith and simulant
		double[][] percentages = new double[17][2];
		//the rate of the electrons of the element in a copound  over the total electron number of the compound
		double[][] elementRate = new double[12][2];
		//numbers array for the subscripts of the elements( for SiO2 it is 1 and 2)
		double[][] numbers = new double[][] {
			{1, 2},
			{1, 2},
			{2, 3},
			{2, 3},
			{2, 3},
			{1, 1},
			{1, 1},
			{1, 1},
			{2, 1},
			{2, 1},
			{2, 5},
			{1, 3},
			{1, 1},
			{1, 0},
			{1, 0},
			{1, 0},
			{1, 0}
		};
		//molecules array contains the atomic number of the elements in a compound
		//for SiO2 it becomes 14 and 8 because Si because atomic number of Si is 14 and atomic number of O is 8
		double [][] molecules = new double[][] {
		{14, 8},
		{22, 8},
		{13, 8},
		{24, 8},
		{26, 8},
		{25, 8},
		{12, 8},
		{20, 8},
		{11, 8},
		{19, 8},
		{15, 8},
		{16, 8},
		{26, 8},
		{17, 0},
		{28, 0},
		{30, 0},
		{35, 0}
		};
		//molecules3 is an array holding the atomic mass units of the elements at each compound
		//for SiO2 because atomic mass unit of Si is 28.085 amu and atomic mass unit of O is 15.999 amu
		double [][] molecules3 = new double[][] {
			{28.085, 15.999},
			{47.857, 15.999},
			{26.982, 15.999},
			{51.996, 15.999},
			{55.845, 15.999},
			{54.938, 15.999},
			{24.305, 15.999},
			{40.078, 15.999},
			{22.990, 15.999},
			{39.098, 15.999},
			{30.974, 15.999},
			{32.06, 15.999},
			{55.845, 15.999},
			{35.45, 0},
			{58.693, 0},
			{65.38, 0},
			{79.904, 0}
		};
		//fill the element rate array that is priviously defined by the equation (electron number of the element * the number of the element in the compound)/total electron number of the compound
		for (int i = 0; i < 12; i++) {
			elementRate[i][0] = numbers[i][0]*molecules[i][0] / (numbers[i][0]*molecules[i][0] + numbers[i][1]*molecules[i][1]);
			elementRate[i][1] = numbers[i][1]*molecules[i][1] / (numbers[i][0]*molecules[i][0] + numbers[i][1]*molecules[i][1]);
		}
		//We define an array containing the efective atomic numbers for every compound in the simulant
		double[] simulantCompoundAtomicNumber = new double[12];
		//We fill the array with the equation stated in  https://en.wikipedia.org/wiki/Effective_atomic_number
		for (int i = 0; i < 12; i++) {
			simulantCompoundAtomicNumber[i] = ofCompounds(molecules[i], elementRate[i]);
		}
		//From the proposal we get the percentages of the compounds in the simulant
		double[] simulantCompoundPercentages = new double[12];
		simulantCompoundPercentages[0] = 0.4557;
		simulantCompoundPercentages[1] = 0.0030;
		simulantCompoundPercentages[2] = 0.0943;
		simulantCompoundPercentages[3] = 0.0012;
		simulantCompoundPercentages[4] = 0.1685;
		simulantCompoundPercentages[5] = 0.0010;
		simulantCompoundPercentages[6] = 0.1650;
		simulantCompoundPercentages[7] = 0.0403;
		simulantCompoundPercentages[8] = 0.0366;
		simulantCompoundPercentages[9] = 0.0043;
		simulantCompoundPercentages[10] = 0.0037;
		simulantCompoundPercentages[11] = 0.0263;
		//the percentage of the electrons of the element in a copound  over the total electron number of the compound
		for (int i = 0; i < 17; i++) {
			percentages[i][0] = numbers[i][0]*molecules[i][0] / (numbers[i][0]*molecules[i][0] + numbers[i][1]*molecules[i][1]);
			percentages[i][1] = numbers[i][1]*molecules[i][1] / (numbers[i][0]*molecules[i][0] + numbers[i][1]*molecules[i][1]);
		}
		// we define an array that will contain regolith compounds atomic number
		double[] regolithCompoundsAtomicNumber = new double[17];
		// filling and printing the Efective Atomic Number of the compounds array
		System.out.println("Effective Atomic Numbers For Compounds: ");
		for (int i = 0; i < 17; i++) {
			regolithCompoundsAtomicNumber[i] = ofCompounds(molecules[i], percentages[i]);
			System.out.println(regolithCompoundsAtomicNumber[i]);
		}
		System.out.println("\n");
		//From the proposal we get the percentages of the compounds in the Martian regolith and add tem to an array
		double[] regolithCompoundPercentages = new double[17];
		regolithCompoundPercentages[0] = 0.4652;
		regolithCompoundPercentages[1] = 0.0087;
		regolithCompoundPercentages[2] = 0.1047;
		regolithCompoundPercentages[3] = 0.0036;
		regolithCompoundPercentages[4] = 0.042;
		regolithCompoundPercentages[5] = 0.0033;
		regolithCompoundPercentages[6] = 0.0893;
		regolithCompoundPercentages[7] = 0.0627;
		regolithCompoundPercentages[8] = 0.0302;
		regolithCompoundPercentages[9] = 0.0041;
		regolithCompoundPercentages[10] = 0.0083;
		regolithCompoundPercentages[11] = 0.0490;
		regolithCompoundPercentages[12] = 0.1218;
		regolithCompoundPercentages[13] = 0.0061;
		regolithCompoundPercentages[14] = 0.000544;
		regolithCompoundPercentages[15] = 0.000204;
		regolithCompoundPercentages[16] = 0.000049;
		//setting a variable called total to 0
		double total = 0;

		for (int i = 0; i < 17; i++) {
			regolithCompoundPercentages[i] = (regolithCompoundPercentages[i] / (molecules3[i][0] + molecules3[i][1]));
			total = total + regolithCompoundPercentages[i];
		}
		 for (int i = 0; i < 17; i++) {
			 regolithCompoundPercentages[i] = regolithCompoundPercentages[i]/total;
		 }
		 double total2 = 0;
		 for (int i = 0; i < 12; i++) {
				simulantCompoundPercentages[i] = (simulantCompoundPercentages[i] / (molecules3[i][0] + molecules3[i][1]));
				total2 = total2 + simulantCompoundPercentages[i];
			}
			 for (int i = 0; i < 12; i++) {
				 simulantCompoundPercentages[i] = simulantCompoundPercentages[i]/total2;
			 }
		//printing the regolith compound percentages array
		System.out.println("Percentages According To Number Of Molecules: ");
		for (int i = 0; i < 17; i++) {
			double h = regolithCompoundPercentages[i]*100;
			System.out.println(h + "%");
		}
		System.out.println("\n");
		
		double f = ofGeneral(regolithCompoundsAtomicNumber, regolithCompoundPercentages);
		//Printing the calculated regolith efective atomic number
		System.out.println("Regolith: ");
		System.out.println(f);
		//Printing the calculated simulant efective atomic number
		System.out.println("Simulant: ");
		System.out.println(ofGeneral(simulantCompoundAtomicNumber, simulantCompoundPercentages));
		//Printing the calculated uncertainty between the two result
		System.out.println("Uncertainty: ");
		System.out.println((ofGeneral(simulantCompoundAtomicNumber, simulantCompoundPercentages) - f )/ f);
	}
	
	//this part is used to visualize the results. 
	//the graphs are represented in an order 
	public void paint(Graphics g) {
		
		super.paint(g);
		double[] gamma = new double[] {11.560672349518445,
				18.495973225046892,
				11.140346367616699,
				21.047943407513895,
				22.9631687402759,
				22.83377793739839,
				10.738644148101958,
				17.99984821177265,
				10.357766516525976,
				17.90424997767269,
				11.997562648439828,
				12.449129707141383,
				23.81002684030239,
				17.000000000000036,
				28.00000000000007,
				30.000000000000078,
				35.00000000000009};
		double max = 0;
		int ind = 0;
		for (int i = 0; i < gamma.length; i++) {
			if(gamma[i] >= max) {
				max = gamma[i];
				ind = i;
			}
		}
		Graphics2D g2d = (Graphics2D) g;
		
	    g2d.setColor(new Color(212,0, 0));
	    for (int i = 0; i < gamma.length; i++) {
	    	g2d.setColor(new Color(255-Double.valueOf(255*gamma[i]/max).intValue(),0 , Double.valueOf(255*gamma[i]/max).intValue()));
	    	g2d.fillRect(i*36+80, 80, 36, Double.valueOf(560*gamma[i]/max).intValue());
	    }
	    


	    
	}
	
}
