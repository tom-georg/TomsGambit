package server;

import java.io.IOException;

public class ServerSocket {
	
	private java.net.ServerSocket mServerSocket;
	
	public ServerSocket(int port) throws IOException {
			mServerSocket = new java.net.ServerSocket(port);
	}
	public Socket accept() throws IOException {

			Socket mSocket = new Socket(mServerSocket.accept());
			return mSocket;
	}
	
	public void close() throws IOException{
			mServerSocket.close();
	}

}
