package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        long result = 0;
        try {
            result = Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        return result;
    }

    public void putEntry(Entry entry) {
        try {
            OutputStream fileOutputStream = Files.newOutputStream(path);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(entry);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        if (getFileSize() == 0) {
            return null;
        }
        try {
            InputStream fileInputStream = Files.newInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Entry) objectInputStream.readObject();
        } catch (Exception e) {
            ExceptionHandler.log(e);
            return null;
        }
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
