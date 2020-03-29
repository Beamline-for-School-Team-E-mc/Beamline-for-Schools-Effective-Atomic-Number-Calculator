package code;
import java.awt.*;
import javax.swing.*;
public class EffectiveAtomicNumberRegolith extends JPanel{
	
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
	
	public static double ofEda(double[] atoms, double[] rates) {
		double alpha = 0;
		for (int i = 0; i < atoms.length; i++) {
			alpha += atoms[i] * rates[i];
		}
		return alpha;
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		EffectiveAtomicNumberRegolith rects = new EffectiveAtomicNumberRegolith();
	    JFrame frame = new JFrame("Rectangles");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(rects);
	    frame.setSize(800, 720);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);		
	    double[][] percentages = new double[17][2];
		double[][] elementRate = new double[12][2];
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
		{35, 0}};
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
			{79.904, 0}};
			
			
		
		
		
		for (int i = 0; i < 12; i++) {
			elementRate[i][0] = numbers[i][0]*molecules[i][0] / (numbers[i][0]*molecules[i][0] + numbers[i][1]*molecules[i][1]);
			elementRate[i][1] = numbers[i][1]*molecules[i][1] / (numbers[i][0]*molecules[i][0] + numbers[i][1]*molecules[i][1]);
		}
		double[] simulantCompoundAtomicNumber = new double[12];
		for (int i = 0; i < 12; i++) {
			simulantCompoundAtomicNumber[i] = ofCompounds(molecules[i], elementRate[i]);
		}
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
		
		for (int i = 0; i < 17; i++) {
			percentages[i][0] = numbers[i][0]*molecules[i][0] / (numbers[i][0]*molecules[i][0] + numbers[i][1]*molecules[i][1]);
			percentages[i][1] = numbers[i][1]*molecules[i][1] / (numbers[i][0]*molecules[i][0] + numbers[i][1]*molecules[i][1]);
		}
		double[] regolithCompoundsAtomicNumber = new double[17];
		
		System.out.println("Effective Atomic Numbers For Compounds: ");
		for (int i = 0; i < 17; i++) {
			regolithCompoundsAtomicNumber[i] = ofCompounds(molecules[i], percentages[i]);
			System.out.println(regolithCompoundsAtomicNumber[i]);
		}
		System.out.println("\n");
		
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
		
		System.out.println("Percentages According To Number Of Molecules: ");
		for (int i = 0; i < 17; i++) {
			double h = regolithCompoundPercentages[i]*100;
			System.out.println(h + "%");
		}
		System.out.println("\n");
		double a = ofEda(regolithCompoundsAtomicNumber, regolithCompoundPercentages);
		double f = ofGeneral(regolithCompoundsAtomicNumber, regolithCompoundPercentages);
		
		System.out.println("Eda regolith: ");
		System.out.println(a);
		System.out.println("Zanyar regolith: ");
		System.out.println(f);
		System.out.println("Zanyar simulant: ");
		System.out.println(ofGeneral(simulantCompoundAtomicNumber, simulantCompoundPercentages));
		System.out.println("Eda simulant: ");
		System.out.println(ofEda(simulantCompoundAtomicNumber, simulantCompoundPercentages));
		System.out.println("Zanyar uncertainty: ");
		System.out.println((ofGeneral(simulantCompoundAtomicNumber, simulantCompoundPercentages) - f )/ f);
		System.out.println("Eda uncertainty: ");
		System.out.println((ofEda(simulantCompoundAtomicNumber, simulantCompoundPercentages) - a)/a);
				

	}
	
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
