package dev.lpa;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.Scanner;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

public class WebSocketClient {

    public static void main(String[] args) throws URISyntaxException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to join chat: ");
        String name = scanner.nextLine();

        HttpClient client = HttpClient.newHttpClient();
        WebSocket webSocket = client.newWebSocketBuilder()
                .buildAsync(new URI("ws://localhost:8080?name=%s"
                                .formatted(name)),
                        new WebSocket.Listener() {
                            @Override
                            public CompletionStage<?> onText(WebSocket webSocket,
                                                             CharSequence data,
                                                             boolean last) {
                                System.out.println(data);
                                return WebSocket.Listener.super.onText(webSocket,
                                        data, last);
                            }
                        }).join();

        while (true) {
            String input = scanner.nextLine();
            if ("bye".equalsIgnoreCase(input)) {
                try {
                    webSocket.sendClose(WebSocket.NORMAL_CLOSURE,
                            "User left normally").get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
                break;
            } else {
                webSocket.sendText(input, true);
            }
        }
    }
}
