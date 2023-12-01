package ru.oschepkov;

import ru.oschepkov.converterexeption.WriteFileException;

public interface IWriter {
    void write(String path, Object obj) throws WriteFileException;
}
