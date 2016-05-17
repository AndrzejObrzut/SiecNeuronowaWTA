import java.util.ArrayList;

public class WTA {

	private int n;
	private Neuron network[];
	
	public WTA(int n) {
		this.n = n;
		network = new Neuron[n];
		for (int i = 0; i < n; i++) {
			network[i] = new Neuron(n);
		}
	}
	
	double[] feed(double[] x) {
		double[] respond = new double[n];
		
		for(int i = 0; i < n; i++) {
			respond[i] = network[i].fead(x);
		}
		
		return respond;
	}
	
	int find_winner(double[] respond) {
		int winner = 0;
		for (int i = 1; i < n; i++) {
			if (respond[winner] < respond[i]) {
				winner = i;
			}
		}
		
		return winner;
	}
	
	int[] network_respond(double[] x) {
		int[] output = new int[n];
		
		double[] respond = feed(x);
		output[find_winner(respond)] = 1;
		
		return output;
	}
	
	void learn_network(ArrayList<double[]> learningSet, int ep, double theta) {
		for (int i = 0; i < ep; i++) {
			for (int j = 0; j < learningSet.size(); j++) {
				double[] respond = feed(learningSet.get(j));
				int winner_id = find_winner(respond);
				learn_winner(winner_id, learningSet.get(j), theta);
				}
		}
	}
	
	private void learn_winner(int winner_id, double[] learnignSet, double theta) {
		network[winner_id].update_weight(learnignSet, theta);
	}
	
}
