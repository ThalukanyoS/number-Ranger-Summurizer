package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ImplementationNumberSummarizer implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        // Parse the input string and add numbers to a list
        String[] numbers = input.split(",");
        List<Integer> numberList = new ArrayList<>();
        for (String number : numbers) {
            numberList.add(Integer.parseInt(number));
        }
        return numberList;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        // Sort the numbers in ascending order
        List<Integer> sortedNumbers = new ArrayList<>(input);
        Collections.sort(sortedNumbers);

        // Iterate through the sorted numbers and group sequential numbers into ranges
        StringBuilder result = new StringBuilder();
        int startRange = sortedNumbers.get(0);
        int prevNumber = sortedNumbers.get(0);
        for (int i = 1; i < sortedNumbers.size(); i++) {
            int currentNumber = sortedNumbers.get(i);
            if (currentNumber - prevNumber > 1) {
                // Not sequential, add the range or single number to the result
                if (startRange == prevNumber) {
                    result.append(startRange).append(", ");
                } else {
                    result.append(startRange).append("-").append(prevNumber).append(", ");
                }
                startRange = currentNumber;
            }
            prevNumber = currentNumber;
        }

        // Add the last range or single number to the result
        if (startRange == prevNumber) {
            result.append(startRange);
        } else {
            result.append(startRange).append("-").append(prevNumber);
        }

        return result.toString();
    }
}

