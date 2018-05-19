package TicTacToe;

import java.net.Socket;

public class ChatClient {
	private String name;
	private Socket socket;
	private ConnectThread chatThread;
	
	public ChatClient() {
		
	};
	public ChatClient(String name, Socket socket, ConnectThread chatThread) {
		super();
		this.name = name;
		this.socket = socket;
		this.chatThread = chatThread;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public ConnectThread getChatThread() {
		return chatThread;
	}
	public void setChatThread(ConnectThread chatThread) {
		this.chatThread = chatThread;
	}
    
    
}
