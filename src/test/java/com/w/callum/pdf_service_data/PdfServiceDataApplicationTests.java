package com.w.callum.pdf_service_data;

import com.sun.jna.Native;
import com.w.callum.pdf_service_data.controller.BasicRoutes;
import com.w.callum.pdf_service_data.model.request.PostMetaRequest;
import com.w.callum.pdf_service_data.model.response.PostMetaResponse;
import com.w.callum.pdf_service_data.util.ImageHashing;
import com.w.callum.pdf_service_data.util.ImageHashingGoLangBindings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;

@Import(TestcontainersConfiguration.class)
//@SpringBootTest
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

    /*
     * For example, ++, --, +, -, *, ==, !=, << all work the same regardless of signess (i.e. give the same answer). for >> you can substitue >>>
     * It is the /, %, >, >=, <, <= and printing functions which assume signed values, but you should be able to work around these (if you use these).
     */
}