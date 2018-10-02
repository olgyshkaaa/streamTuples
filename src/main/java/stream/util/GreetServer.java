package stream.util;

import stream.model.AverageTuple;
import stream.model.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class GreetServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    public final static int AGE_INTERVALS = 8;
    private static Map<Integer, Tuple> patients = new HashMap<Integer, Tuple>();

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        AverageTuple[] data = FormatUtil.prepareData(new AverageTuple[AGE_INTERVALS]);
        int count = 0;
        while ((inputLine = in.readLine()) != null) {
            FormatUtil.formatInputStream(inputLine, patients, data);
            count++;
            if (count % 1000 == 0) {
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