package com.epam.autoparking;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/** contains methods to perform operations on file.
 * @author Rithika_Mamidi
 */
public class FileOperations {
    /** appends the content to a file.
     * @param fileName filename to append to
     * @param content content to be appended to file
     */
    public void appendToFile(final String fileName, final String content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(fileName, true))) {
            bufferedWriter.write(content);
            bufferedWriter.newLine();
             bufferedWriter.flush();
           } catch (IOException e) {
              System.out.println("Io exception!");
           }
    }
    /** reads data from file and sends it in the form of
     *  string array array list.
     * @param fileName file name to read from
     * @return read data from file.
     */
    public ArrayList<String[]> readDataFromFile(final String fileName) {
        ArrayList<String[]> contentRead = new ArrayList<String[]>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] data = currentLine.split(",");
                contentRead.add(data);
            }
        } catch (IOException exception) {
            System.out.println("Io exception!");
        }
        return contentRead;
    }
    /** deletes a row from the file.
     * @param fileName file name to perform operation
     * @param carNumber vehicle number of the row to be deleted
     */
    public void deleteRowFromFile(final String fileName,
            final String carNumber) {
        List<String[]> contentOfFile = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] data = currentLine.split(",");
                contentOfFile.add(data);
            }
            for (Iterator<String[]> iterator = contentOfFile.iterator();
                    iterator.hasNext();) {
                String[] stringArrayRead = iterator.next();
                if (carNumber.equals(stringArrayRead[0].trim())) {
                    contentOfFile.remove(stringArrayRead);
                    break;
                }
            }
            write(fileName, contentOfFile);
        } catch (IOException e) {
            System.out.println("Io exception!");
        }
    }
    /** This method writes the entire file after the vehicle
     *  exits the parking lot.
     * @param fileName file name to write to
     * @param contentOfFile content which has to written to the file
     *  after the vehicle leaves the parking lot.
     */
    public void write(final String fileName,
            final List<String[]> contentOfFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(fileName))) {
           for (Iterator<String[]> iterator = contentOfFile.iterator();
                        iterator.hasNext();) {
                String[] stringArrayRead = iterator.next();
                String joinedString = String.join(",",
                        stringArrayRead[0],
                        stringArrayRead[1], stringArrayRead[2]);
                bufferedWriter.write(joinedString);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Io exception!");
        }
    }


}
