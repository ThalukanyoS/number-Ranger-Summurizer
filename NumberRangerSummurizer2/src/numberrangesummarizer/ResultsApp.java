package numberrangesummarizer;

import java.util.Collection;

public class ResultsApp {
    public static void main(String[] args) {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        // Create an instance of NumberRangeSummarizer
        NumberRangeSummarizer summarizer = new ImplementationNumberSummarizer();

        // Collect the numbers from the input string
        Collection<Integer> numbers = summarizer.collect(input);

        // Summarize the collection of numbers into ranges
        String result = summarizer.summarizeCollection(numbers);

        // Print the input and result
        System.out.println("Sample Input: " + input);
        System.out.println("Result: " + result);
    }
}

