package dev.lpa.handlers;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeFileHandler implements HttpResponse.BodyHandler<Path> {

    private final Path path;
    private static final Lock lock = new ReentrantLock();

    public ThreadSafeFileHandler(Path path) {
        this.path = path;
    }

    @Override
    public HttpResponse.BodySubscriber<Path> apply(HttpResponse.ResponseInfo responseInfo) {
        return HttpResponse.BodySubscribers.mapping(
                HttpResponse.BodySubscribers.ofString(
                Charset.defaultCharset()
        ), value -> {
            lock.lock();
            try {
                Files.writeString(path, value + "\r", StandardOpenOption.APPEND);
                return path;
            } catch (IOException e) {
                throw new RuntimeException("Failed to write response", e);
            } finally {
                lock.unlock();
            }
        });
    }
}
