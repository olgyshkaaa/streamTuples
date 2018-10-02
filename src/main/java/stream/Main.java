package stream;

import stream.model.AverageTuple;
import stream.model.Tuple;
import stream.util.FormatUtil;
import stream.util.GreetServer;

import java.io.*;
import java.net.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        GreetServer server = new GreetServer();
        server.start(5001);


    }
}
