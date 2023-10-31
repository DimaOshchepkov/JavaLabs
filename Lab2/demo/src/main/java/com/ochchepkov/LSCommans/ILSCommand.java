package com.ochchepkov.LSCommans;

@FunctionalInterface
public interface ILSCommand {
    public String apply(String path);
}
