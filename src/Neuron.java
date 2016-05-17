import java.util.ArrayList;
import java.util.Random;


public class Neuron {
	
	private double[] w;
	private double[] deltaW;
	private int n;
	
	public Neuron(int n) {
		this.n = n;
		w = new double[n];
		deltaW = new double[n];		
		setWeight();
	}
	
	double fead(double x[]) {
		double result = 0.0;
		for (int i = 0; i < n; i++) {
			result += w[i] *x[i];
		}
		return result;
	}
	
	void learn(int iloscEpok, ArrayList<double[]> xUcz, double[] dOcz, double theta ) {
		for (int i = 0; i < iloscEpok; i++) {
			for (int j = 0; j < xUcz.size(); j++) {
				double y = fead(xUcz.get(j));
				double e = dOcz[j] - y;
				for (int k = 0; k < xUcz.get(j).length; k++) {
					deltaW[k] = theta * e * xUcz.get(j)[k];
				}
				
				for (int k = 0; k < w.length; k++) {
					w[k] += deltaW[k];
				}
			}
		}
	}
	
	void update_weight(double[] learningSet, double theta) {
		for (int i = 0; i < n; i++) {
			w[i] = (learningSet[i] - w[i]) * theta;
		}
	}
	
	private void setWeight() {
		for (int i = 0; i < n; i++) {
			w[i] = rand();
		}
	}
	
	private double rand() {
		double min = -1;
		double max = 1;
		Random rand = new Random();
		double result = rand.nextDouble() * ((max - min) + 1 )+ min;
		if (result == 0) {
			result = rand();
		}
		return result;
	}
}
