package com.ochchepkov;

@FunctionalInterface
public interface ICommand {
    void apply(String path) throws IllegalArgumentException;
}
