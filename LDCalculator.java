package sample;

public class LDCalculator {

    public int calculate(String one, String two) {

        int indexOne;
        int indexTwo;
        char instanceChar_StringOne;
        char instanceChar_StringTwo;
        int cost;

        int lengthOne = one.length();
        int lengthTwo = two.length();

        if (lengthOne == 0 || lengthTwo == 0) {
            return 0;
        }
        int distanceMatrix[][] = new int[lengthOne + 1][lengthTwo + 1];

        for (indexOne = 0; indexOne <= lengthOne; indexOne++) {
            distanceMatrix[indexOne][0] = indexOne;
        }

        for (indexTwo = 0; indexTwo <= lengthTwo; indexTwo++) {
            distanceMatrix[0][indexTwo] = indexTwo;
        }

        for (indexOne = 1; indexOne <= lengthOne; indexOne++) {
            instanceChar_StringOne = one.charAt(indexOne - 1);
            for (indexTwo = 1; indexTwo <= lengthTwo; indexTwo++) {
                instanceChar_StringTwo = two.charAt(indexTwo - 1);
                if (instanceChar_StringOne == instanceChar_StringTwo) {
                    cost = 0;
                } else {
                    cost = 1;
                }
                distanceMatrix[indexOne][indexTwo] = getMinimumValue(distanceMatrix[indexOne - 1][indexTwo] + 1, distanceMatrix[indexOne][indexTwo - 1] + 1, distanceMatrix[indexOne - 1][indexTwo - 1] + cost);
            }
        }
        return distanceMatrix[lengthOne][lengthTwo];
    }

    private int getMinimumValue(int a, int b, int c) {
        int minimum;
        minimum = a;
        if (b < minimum) {
            minimum = b;
        }
        if (c < minimum) {
            minimum = c;
        }
        return minimum;
    }

}
