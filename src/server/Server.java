package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import ChessLogic.*;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/getmove", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            System.out.println("anfrage");
            setOrigin(t);
            String query = t.getRequestURI().getQuery();
            Map<String,String> parameters = queryToMap(query);
            String strBoard = parameters.get("board");
            ValueCalculator.init();
            int[][] board = createBoard(strBoard);
            int valueWhite = ValueCalculator.getValueWhite(board);
            int valueBlack = ValueCalculator.getValueBlack(board);


            Status status = new Status(null, valueWhite, valueBlack);
            try{
                status = Engine.move(board,4,Board.BLACK,status);
            }catch(Exception e){
                e.printStackTrace();

            }

            System.out.println("Endguetig: "+status);
            Printer.printBaord(board);
            InputStream inputStream = t.getRequestBody();
            byte[] bytebody = new byte[300];

            inputStream.read(bytebody);

            String strBody = new String(bytebody);
            strBody = strBody.trim();
            System.out.println(strBody);
            Move move = status.move;

            String response = "x:"+move.fromX+"-y:"+move.fromY+"-"+"x:"+move.toX+"-y:"+move.toY;
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        static void setOrigin(HttpExchange httpExchange) throws IOException {
            httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");

            if (httpExchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
                httpExchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, OPTIONS");
                httpExchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type,Authorization");
                httpExchange.sendResponseHeaders(204, -1);
                return;
            }
        }
        static public Map<String, String> queryToMap(String query) {
            Map<String, String> result = new HashMap<>();
            for (String param : query.split("&")) {
                String[] entry = param.split("=");
                if (entry.length > 1) {
                    result.put(entry[0], entry[1]);
                }else{
                    result.put(entry[0], "");
                }
            }
            return result;
        }

        public static int[][] createBoard(String anfrage){
            String[] array = anfrage.split("-");
            int x = 0;
            int y = 0;
            int[][] board = new int[8][8];
            for(String strBelegung : array){
                int zahl = Integer.parseInt(strBelegung);
                board[x][y] = zahl;
                x++;
                if(x==8){
                    x=0;
                    y++;
                }
            }

            return board;
        }
    }



}
