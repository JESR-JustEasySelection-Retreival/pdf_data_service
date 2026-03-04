package com.w.callum.pdf_service_data;

import com.w.callum.pdf_service_data.extraction.HashKeyPage;
import com.w.callum.pdf_service_data.util.ImageHashing;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;

class PdfServiceDataApplicationTests {
    @Test
    void TestHashingFile1() {
        File file = new File("src/test/java/com/w/callum/pdf_service_data/EncodedImageExample1.txt");
        String result = "";
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] data = fileInputStream.readAllBytes();
            String encodedData = new String(data, StandardCharsets.UTF_8);
            byte[] rawBytes = Base64.getDecoder().decode(encodedData);

            ImageHashing hash = new ImageHashing();
            long i = hash.ConvertByteArrToNumberFNV1A(rawBytes);
            long hashedNumber = hash.Hash64shift(i);
            result = hash.ConvertHashToString(hashedNumber);
            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("BOKEAeQ48cL", result);
    }

    @Test
    void TestHashingFile2() {
        File file = new File("src/test/java/com/w/callum/pdf_service_data/EncodedImageExample2.txt");
        String result = "";
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] data = fileInputStream.readAllBytes();
            String encodedData = new String(data, StandardCharsets.UTF_8);
            byte[] rawBytes = Base64.getDecoder().decode(encodedData);

            ImageHashing hash = new ImageHashing();
            long i = hash.ConvertByteArrToNumberFNV1A(rawBytes);
            long hashedNumber = hash.Hash64shift(i);
            result = hash.ConvertHashToString(hashedNumber);
            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("Mf0zt0s3a", result);
    }

    @Test
    void TestHashingFile3() {
        File file = new File("src/test/java/com/w/callum/pdf_service_data/EncodedImageExample3.txt");
        String result = "";
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] data = fileInputStream.readAllBytes();
            String encodedData = new String(data, StandardCharsets.UTF_8);
            byte[] rawBytes = Base64.getDecoder().decode(encodedData);

            ImageHashing hash = new ImageHashing();
            long i = hash.ConvertByteArrToNumberFNV1A(rawBytes);
            long hashedNumber = hash.Hash64shift(i);
            result = hash.ConvertHashToString(hashedNumber);
            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("6WMIm2KskNj", result);
    }

}