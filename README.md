# Siec Neuronowa - WTA

**Pseudo kod Metody Widrowa-Hoffa uczenia neuronu**

    class NeuralNetwork
    	Neuronek[] network
    	int p;
    	//konstruktor. p := wymiar
    	NeuralNetwork(int p) {
    		network = new Neuronek[p]
    	}
    
    	/* learning_set = [x1 x2 x3 ... xr]. r := liczba przykladow
    	/* x1=[x11 x12 x13 x14]'
    	train(learning_set, epoch, learning_rate) {
    		for (i=0;i<epoch; i++) {
    			foreach (el in learning_set) {
    				s=neural_feed(el) //s=[s1 s2 s3]'
    				id_winner=find_winner_neuron(s) //id=m
    				learn_winner(id_winner, el, learning_rate)			
    			}
    		}
    	}
    
    	neural_feed(x) {
    		float[] s = new flost[p]
    		int i=0;
    		foreach(neron in network) {
    			s[i++]=neuron.feed(x)
    		}
    		return s
    	}
    	
    	neural_respond(x) {
    		int[] respond = new int[p]		
    		s = neural_feed(x)
    		id_winner=find_winner_neuron(s)
    		fill_with_zeros(respond)
    		respond[id_winner]=1;
    		return respond
    	}
    	
    	learn_winner(id_winner, el, learning_rate) {
    		network[id_winner].update_weight(el, learning_rate)
    	}
    end
