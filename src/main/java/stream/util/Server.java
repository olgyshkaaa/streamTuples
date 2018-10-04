package stream.util;

import stream.model.AverageTuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Connection implementation class
 */
public class Server {
    /**
     * Start application connection
     * @param port application port connection
     * @param batchSize  number of tuples per batch to send
     */
    public void start(int port, Integer batchSize) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        int count = 0;
        Calculation calculation = new Calculation();
        while ((inputLine = in.readLine()) != null) {
            AverageTuple[] data = calculation.calculateAverage(DataUtil.formatInputStream(inputLine));
            count++;
            if (count % batchSize == 0) {
                out.println(DataUtil.formatOutputStream(data));
            }
        }
    }
}
