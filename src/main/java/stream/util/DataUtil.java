package stream.util;

import stream.Main;
import stream.model.OutgoingTuple;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.AccessException;
import java.util.Properties;
import java.util.regex.Pattern;

/*
 * Utility data formatting class
 */
public class DataUtil {

    DataUtil(){
        throw new IllegalStateException("Utility class");
    }

    /**
     * Preparing average data array
     * zero value installation
     * @param data average data array
     * @return zero value array
     */
    public static OutgoingTuple[] prepareData(OutgoingTuple[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = new OutgoingTuple();
        }
        return data;
    }

    /**
     * Input stream formatting class
     * @param tuple string tuple patients information
     * @return array of integer  with patients information
     */
    public static Integer[] formatInputStream(String tuple) {
        String[] tupleSplit = tuple.split(Pattern.quote("|"));
        Integer[] tupleInt = new Integer[3];
        tupleInt[0] = Integer.parseInt(tupleSplit[0]);
        tupleInt[1] = Integer.parseInt(tupleSplit[1]);
        tupleInt[2] = Integer.parseInt(tupleSplit[2].replace("\\n", ""));
        return tupleInt;
    }

    /**
     * Output stream formatting class
     * @param tuples  array of average patients information
     * @return string tuple average patients information
     */
    public static String formatOutputStream(OutgoingTuple[] tuples) {
        StringBuilder output = new StringBuilder();
        for (OutgoingTuple tuple : tuples) {
            output.append(tuple.getCount() == 0 ?
                    "|" : String.valueOf(tuple.getSum() / tuple.getCount()) + "|");
        }
        return output.substring(0, output.length() - 1);
    }

    /**
     * Reading info from configuration file
     */
    public static void readPropertiesFile() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            String filename = "config.properties";
            input = DataUtil.class.getClassLoader().getResourceAsStream(filename);
            if (input != null) {
                prop.load(input);
            } else {
                throw new AccessException("cannot find properties for application");
            }
            Main.port = Integer.parseInt(prop.getProperty("port"));
            Main.batchSize = Integer.parseInt(prop.getProperty("batchSize"));

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
