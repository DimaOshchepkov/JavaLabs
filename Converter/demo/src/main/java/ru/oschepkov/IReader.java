package ru.oschepkov;

import java.io.IOException;


public interface IReader {
    Object read(String path) throws IOException;
}
