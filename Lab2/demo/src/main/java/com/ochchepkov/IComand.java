package com.ochchepkov;

import java.util.List;

@FunctionalInterface
public interface IComand {
    String apply(StringBuilder path, List<String> value);
}
