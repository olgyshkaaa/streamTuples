package stream;

import stream.util.DataUtil;
import stream.util.Server;

import java.io.*;
import java.rmi.AccessException;
import java.util.Properties;


public class Main {
    static Integer  port;
    static Integer batchSize;

    public static void main(String[] args) throws IOException {
        readPropertiesFile();
        Server server = new Server();
        server.start(port, batchSize);
    }

    /**
     * Reading info from configuration file
     */
    private static void readPropertiesFile() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            String filename = "config.properties";
            input = Main.class.getClassLoader().getResourceAsStream(filename);
            if (input != null) {
                prop.load(input);
            } else {
                throw new AccessException("cannot find properties for application");
            }
            port = Integer.parseInt(prop.getProperty("port"));
            batchSize = Integer.parseInt(prop.getProperty("batchSize"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
