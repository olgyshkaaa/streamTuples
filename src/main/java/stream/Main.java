package stream;

import stream.util.Server;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(5001);
    }
}
