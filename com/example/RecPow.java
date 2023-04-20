package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Calcs powers sequence.
 *
 * @author Mr. Riscalas
 * @version 1.0
 * @since 2023-04-20
 */
public final class RecPow {
    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecPow() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * This is the RecPow method.
    *
    * @param base //base
    * @param exp // exp
    * @return num
    */
    public static int recPow(final int base, final int exp) {
        // Checks if exponent equals 0 then return 1
        if (exp == 0) {
            return 1;
        } else {
            return recPow(base, exp - 1) * base;
        }
    }

    /**
    * This is the main method.
    *
    * @param args //unused
    */
    public static void main(final String[] args) {
        // Set the input and output file paths
        final String inputFilePath = "input.txt";
        final String outputFilePath = "output.txt";

        // Read input from file using Scanner
        try (Scanner scanner = new Scanner(new File(inputFilePath));
            FileWriter writer = new FileWriter(outputFilePath)) {
            /* Read each line from the input file and calc the
            * power of it using recursions
            */
            while (scanner.hasNextLine()) {
                final String[] line = scanner.nextLine().split(" ");
                final int answer = recPow(Integer.parseInt(line[0]),
                                                Integer.parseInt(line[1]));

                // Write the answer to the output file
                writer.write(line[0] + " ^ " + line[1] + " = " + answer + "\n");
            }
        } catch (FileNotFoundException error) {
            System.err.println("File not found: " + error.getMessage());
        } catch (IOException error) {
            System.err.println("Error writing to file: " + error.getMessage());
        }
    }
}
