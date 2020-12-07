package server;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    public void run(){

    }

    private void serverloop() throws IOException {
        ServerSocket serverSocket = new ServerSocket(4005);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        while(true){
            try{
                Socket socket = serverSocket.accept();
                threadPoolExecutor.submit(() -> handleClient(socket));
            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }

    private void handleClient(Socket socket) {
        try{
            String line="";
            String content="";
            while(line!=null){
                line= socket.readLine();
                content+=line+"\n";
            }
            System.out.println(content);
        }catch(Exception e){
            e.printStackTrace();;
        }

    }
}
