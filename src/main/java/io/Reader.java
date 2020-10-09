package io;

import java.util.Map;

public interface Reader<T> {

    Map<String, T> read(String path);

}
