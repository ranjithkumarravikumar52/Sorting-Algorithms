package com.sortingalgorithm.service.model.pojo;

import com.sortingalgorithm.service.model.metric.MetricMeasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DataAnalysis {
	private String sortAlgorithmName;
	private int dataSize;
	private MetricMeasure metricMeasure;

	public DataAnalysis(String sortAlgorithmName, int dataSize, MetricMeasure metricMeasure) {
		this.sortAlgorithmName = sortAlgorithmName;
		this.dataSize = dataSize;
		this.metricMeasure = metricMeasure;
	}

}
