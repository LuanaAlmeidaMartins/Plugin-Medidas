package model.metrics;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import model.information.Dependency;
import model.information.MetricsInformation;
import model.information.Node;
import model.information.Propagation;

public class CSC_ConcernSensitiveCoupling extends Metrics {

	public CSC_ConcernSensitiveCoupling(HashMap<String, ArrayList<Dependency>> codeFragments) {
		super(codeFragments);
		metricFeature = new ArrayList<MetricsInformation>();
		calculate();
		metricSystem.add(new MetricsInformation("Concern Sensitive Coupling (CSC)", metricFeature, Node.NON_LEAF,
				Propagation.AVERAGE));
	}

	public void calculate() {
		int contarDP = 0;
		for (Entry<String, ArrayList<Dependency>> entry : code.entrySet()) {
			metricComponent = new ArrayList<MetricsInformation>();

			if (entry.getValue().size() > 1) {
				ArrayList<String> dependencies = new ArrayList<>();

				for (int i = 0; i < entry.getValue().size(); i++) {
					dependencies.add(entry.getValue().get(i).getClasseName());
				}
				for (int i = 0; i < entry.getValue().size(); i++) {
					contarDP = 0;
					for (int j = 0; j < dependencies.size(); j++) {
						if (entry.getValue().get(i).getClasseName() != dependencies.get(j)) {
							if (entry.getValue().get(i).getDependencias().contains(dependencies.get(j))) {
								contarDP++;
							}
						}
					}
					metricComponent
							.add(new MetricsInformation(entry.getValue().get(i).getClasseName(), contarDP, Node.LEAF));
				}
			} else {
				for (int i = 0; i < entry.getValue().size(); i++) {
					metricComponent.add(new MetricsInformation(entry.getValue().get(i).getClasseName(), 0, Node.LEAF));
				}
			}

			metricFeature
					.add(new MetricsInformation(entry.getKey(), metricComponent, Node.NON_LEAF, Propagation.AVERAGE));
		}
	}
}
