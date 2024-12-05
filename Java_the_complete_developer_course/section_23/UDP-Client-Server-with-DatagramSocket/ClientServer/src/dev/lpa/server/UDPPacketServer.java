package dev.lpa.server;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPPacketServer {

    private static final int PORT = 5000;
    private static final int PACKET_SIZE = 1024;

    public static void main(String[] args) {

        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {

            byte[] buffer = new byte[PACKET_SIZE];

            System.out.println("Waiting for client to connect...");
            DatagramPacket clientPacket = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(clientPacket);
            String audioFileName = new String(buffer, 0, clientPacket.getLength());
            System.out.println("Client requested to listen to: " + audioFileName);

            try {
                File audioFile = new File(audioFileName);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
                System.out.println(audioInputStream.getFormat());

            } catch (UnsupportedAudioFileException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
