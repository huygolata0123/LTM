/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipaddress;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Bong
 */
public class GetFreePort {
 private boolean isPortAvailable(int port) {
        boolean portAvailable = true;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch(Exception e) {
            portAvailable = false;
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch(Exception e) {
                    e.printStackTrace();
                };
            }
        }
        return portAvailable;
    }
    
    public int getFreePort() {
        int port = 15000;
        while (true) {
            if (isPortAvailable(port) == true) {
                break;
            } else {
                port++;
            }
        }
        return port;
    }
}
