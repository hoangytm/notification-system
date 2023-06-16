package com.hoangyth.util;

import java.io.*;

public class SplitFile {

    public static final String INPUT_FILE = "D:\\me\\projects\\input\\file\\path.txt";
    public static final int NUMBER_OF_OUTPUT_FILES = 30;
    public static final String FILE_SUFFIX = ".txt";

    /**
     * split file
     *
     * @throws Exception
     */
    static void splitFile() throws Exception {

        File inputFile = new File(INPUT_FILE + "_Splits");
        inputFile.mkdir();

        RandomAccessFile raf = new RandomAccessFile(INPUT_FILE, "r");

        long sourceSize = raf.length();
        long bytesPerSplit = sourceSize / NUMBER_OF_OUTPUT_FILES;
        long remainingBytes = sourceSize % NUMBER_OF_OUTPUT_FILES;

        int maxReadBufferSize = 8 * 1024; // 8KB
        for (int destIx = 1; destIx <= NUMBER_OF_OUTPUT_FILES; destIx++) {
            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(INPUT_FILE + "_Splits\\split." + destIx + FILE_SUFFIX));
            if (bytesPerSplit > maxReadBufferSize) {
                long numReads = bytesPerSplit / maxReadBufferSize;
                long numRemainingRead = bytesPerSplit % maxReadBufferSize;
                for (int i = 0; i < numReads; i++) {
                    readWrite(raf, bw, maxReadBufferSize);
                }
                if (numRemainingRead > 0) {
                    readWrite(raf, bw, numRemainingRead);
                }
            } else {
                readWrite(raf, bw, bytesPerSplit);
            }
            bw.close();
        }
        if (remainingBytes > 0) {
            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("split." + NUMBER_OF_OUTPUT_FILES + 1));
            readWrite(raf, bw, remainingBytes);
            bw.close();
        }
        raf.close();
    }

    /**
     * join file
     *
     * @throws Exception
     */
    static void joinFiles() throws Exception {
        int maxReadBufferSize = 8 * 1024;

        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(INPUT_FILE + "_Splits\\fullJoin" + FILE_SUFFIX));
        File inputFileDir = new File(INPUT_FILE + "_Splits");
        RandomAccessFile raf = null;
        if (inputFileDir.isDirectory()) {
            for (File file : inputFileDir.listFiles()) {
                raf = new RandomAccessFile(file, "r");
                long numReads = raf.length() / maxReadBufferSize;
                long numRemainingRead = raf.length() % maxReadBufferSize;
                for (int i = 0; i < numReads; i++) {
                    readWrite(raf, bw, maxReadBufferSize);
                }
                if (numRemainingRead > 0) {
                    readWrite(raf, bw, numRemainingRead);
                }
                raf.close();
            }
        }
        bw.close();
    }

    public static void mergeFiles() {

        File[] files = new File[NUMBER_OF_OUTPUT_FILES];
        for (int i = 1; i <= NUMBER_OF_OUTPUT_FILES; i++) {
            files[i - 1] = new File(INPUT_FILE + "_Splits\\split." + i + FILE_SUFFIX);
        }

        String mergedFilePath = INPUT_FILE + "_Splits\\fullJoin" + FILE_SUFFIX;


        File mergedFile = new File(mergedFilePath);

        mergeFiles(files, mergedFile);
    }

    public static void mergeFiles(File[] files, File mergedFile) {

        FileWriter fstream = null;
        BufferedWriter out = null;
        try {
            fstream = new FileWriter(mergedFile, true);
            out = new BufferedWriter(fstream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        for (File f : files) {
            System.out.println("merging: " + f.getName());
            FileInputStream fis;
            try {
                fis = new FileInputStream(f);
                BufferedReader in = new BufferedReader(new InputStreamReader(fis));

                String aLine;
                while ((aLine = in.readLine()) != null) {
                    out.write(aLine);
                    out.newLine();
                }

                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void readWrite(RandomAccessFile raf, BufferedOutputStream bw, long numBytes) throws IOException {
        byte[] buf = new byte[(int) numBytes];
        int val = raf.read(buf);
        if (val != -1) {
            bw.write(buf);
        }
    }
}