package stream;

import stream.server.Server;
import stream.util.DataUtil;

import java.io.*;
import java.rmi.AccessException;
import java.util.Properties;


public class Main {
    public static Integer port;
    public static Integer batchSize;

    public static void main(String[] args) throws IOException {
        DataUtil.readPropertiesFile();
        Server server = new Server();
        server.start(port, batchSize);
    }

}
