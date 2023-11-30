package ru.oschepkov;

import java.io.IOException;

public interface IWriter {
    void write(String path, Object obj) throws IOException;
}
