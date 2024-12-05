package dev.lpa.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPAudioClient {

    private static final int SERVER_PORT = 5000;
    private static final int PACKET_SIZE = 1024;

    public static void main(String[] args) {

        try (DatagramSocket clientSocket = new DatagramSocket()) {

            byte[] audioFileName = "AudioClip.wav".getBytes();
            DatagramPacket packet1 = new DatagramPacket(audioFileName,
                    audioFileName.length, InetAddress.getLocalHost(), SERVER_PORT);
            clientSocket.send(packet1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
