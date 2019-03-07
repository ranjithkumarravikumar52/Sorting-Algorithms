package com.sortingalgorithm.config;

import com.sortingalgorithm.sortalgorithms.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.sortingalgorithm")
@EnableAspectJAutoProxy
public class AppConfig {
	@Bean
	public SortAlgorithm<Integer> bubbleSort() {
		return new BubbleSort();
	}

	@Bean
	public SortAlgorithm<Integer> insertionSort() {
		return new InsertionSort();
	}

	@Bean
	public SortAlgorithm<Integer> mergeSort() {
		return new MergeSort();
	}

	@Bean
	public SortAlgorithm<Integer> quickSort() {
		return new QuickSort();
	}

	@Bean
	public SortAlgorithm<Integer> selectionSort() {
		return new SelectionSort();
	}

	@Bean
	public SortAlgorithm<Integer> shellSort() {
		return new ShellSort();
	}

	@Bean(name = "getAllSortClasses")
	public SortAlgorithm[] getAllSortClasses() {
		return new SortAlgorithm[]{new BubbleSort(), new InsertionSort(), new MergeSort(), new QuickSort(), new SelectionSort(), new ShellSort()};
	}
}
