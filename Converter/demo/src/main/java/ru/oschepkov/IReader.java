package ru.oschepkov;

import ru.oschepkov.converterexeption.ReadFileException;

public interface IReader {
    Object read(String path) throws ReadFileException;
}
