package stream.util;

import stream.model.AverageTuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        int count = 0;
        Calculation calculation = new Calculation();
        while ((inputLine = in.readLine()) != null) {
            AverageTuple[] data = calculation.calculateAverage(FormatUtil.formatInputStream(inputLine));
            count++;
            if (count % 1000 == 0 && count != 0) {
                out.println(FormatUtil.formatOutputStream(data));
            }
        }
    }

//    public void stop() throws IOException {
//        in.close();
//        out.close();
//        clientSocket.close();
//        serverSocket.close();
//    }
}
