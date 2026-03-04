package com.w.callum.pdf_service_data.extraction;

import java.io.IOException;
import java.io.Writer;

public class StringWriter extends Writer {
    public StringWriter() {
        super();
    }

    @Override
    public void write(char[] cbuf, int off, int len) {
    }

    @Override
    public void write(String str) throws IOException {
        System.out.println("StringWriter | Str: " + str);
    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void close() throws IOException {
        System.out.println("CLOSED");
    }
}