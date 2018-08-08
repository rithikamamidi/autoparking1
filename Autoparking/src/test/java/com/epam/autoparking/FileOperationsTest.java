package com.epam.autoparking;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
/** class to test FileOperations class.
 * @author Rithika_Mamidi
 *
 */
public class FileOperationsTest {
    /** creation of temporary folder.
     */
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    /** test read data from file method.
     * @throws IOException input output exception
     */
    @Test
    public void testReadDataFromFile() throws IOException {
        ArrayList<String[]> contentRead = new ArrayList<>();
        final File tempFile = temporaryFolder.newFile(
                "testtransaction.csv");
        tempFile.deleteOnExit();
        try (FileWriter fileWriter = new FileWriter(tempFile)) {
            fileWriter.write("AB12BB1234,2,10:00:00\n"
                    + "AB13BB1234,3,11:00:00\n");
        }
        FileOperations fileOperationsObject =
                new FileOperations();
        contentRead = fileOperationsObject.readDataFromFile(
                tempFile.getCanonicalPath().toString());
        assertEquals(2, contentRead.size());
    }
    /** method to test append to file method.
     * @throws IOException input output exception
     */
    @Test
    public void testAppendToFile() throws IOException {
        final int numberThree = 3;
        ArrayList<String[]> contentRead = new ArrayList<>();
        final File tempFile = temporaryFolder.newFile(
                "testtransaction.csv");
        tempFile.deleteOnExit();
        try (FileWriter fileWriter = new FileWriter(tempFile)) {
            fileWriter.write("AB12BB1234,2,10:00:00\n"
                    + "AB13BB1234,3,11:00:00\n");
        }
        FileOperations fileOperationsObject =
                new FileOperations();
        String filepath = tempFile.getCanonicalPath().toString();
        fileOperationsObject.appendToFile(filepath,
                "AB14BB1234,5,12:00:00");
        contentRead = fileOperationsObject.readDataFromFile(filepath);
        assertEquals(numberThree, contentRead.size());
    }
    /** method to test delete row from a file method.
     * @throws IOException input output exception
     */
    @Test
    public void deleteRowFromFile() throws IOException {
        ArrayList<String[]> contentRead = new ArrayList<>();
        final File tempFile = temporaryFolder.newFile(
                "testtransaction.csv");
        tempFile.deleteOnExit();
        try (FileWriter fileWriter = new FileWriter(tempFile)) {
            fileWriter.write("AB12BB1234,2,10:00:00\n"
                    + "AB13BB1234,3,11:00:00\n"
                    + "AB14BB1234,5,12:00:00\n");
        }
        FileOperations fileOperationsObject =
                new FileOperations();
        String filepath = tempFile.getCanonicalPath().toString();
        fileOperationsObject.deleteRowFromFile(filepath, "AB13BB1234");
        contentRead = fileOperationsObject.readDataFromFile(filepath);
        String[] deletedRow = {"AB13BB1234", "3", "11:00:00"};
        assertFalse(contentRead.contains(deletedRow));
        assertEquals(2, contentRead.size());
    }
    /** method to test write method.
     * @throws IOException input output exception
     */
    @Test
    public void testWrite() throws IOException {
        ArrayList<String[]> contentRead = new ArrayList<>();
        final File tempFile = temporaryFolder.newFile(
                "testtransaction.csv");
        tempFile.deleteOnExit();
        try (FileWriter fileWriter = new FileWriter(tempFile)) {
            fileWriter.write("AB12BB1234,2,10:00:00\n"
                    + "AB13BB1234,3,11:00:00\n"
                    + "AB14BB1234,5,12:00:00\n");
        }
        FileOperations fileOperationsObject =
                new FileOperations();
        String filepath = tempFile.getCanonicalPath().toString();
        String[] data = {"AB19BB1234", "2", "10:00:00"};
        ArrayList<String[]> dataToBeWritten = new ArrayList<>();
        dataToBeWritten.add(data);
        fileOperationsObject.write(filepath, dataToBeWritten);
        contentRead = fileOperationsObject.readDataFromFile(filepath);
        assertEquals(1, contentRead.size());
    }
    /** test method for exception.
     */
    @Test
    public void testAppendToWriteException() {
        FileOperations fileOp = new FileOperations();
        fileOp.appendToFile("C:\\Rithika\\abc.csv", "Rithika");
    }
    /** test method for exception.
     */
    @Test
    public void testReadDataFromFileException() {
        FileOperations fileOp = new FileOperations();
        fileOp.readDataFromFile("C:\\Rithika\\abc.csv");
    }
    /** test method for exception.
     */
    @Test
    public void testDeleteRowFromFileException() {
        FileOperations fileOp = new FileOperations();
        fileOp.deleteRowFromFile("C:\\Rithika\\abc.csv", "Rithika");
    }
    /** test method for exception.
     */
    @Test
    public void testWriteException() {
        FileOperations fileOp = new FileOperations();
        List<String[]> list = new ArrayList<String[]>();
        fileOp.write("C:\\Rithika\\abc.csv", list);
    }

}

