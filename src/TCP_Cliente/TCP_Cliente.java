package TCP_Cliente;
import java.net.*;  
import java.io.*;  

 
// @param ip_server = IP do TCP_Servidor
  
//@param path_server = caminho do arquivo no TCP_Servidor 
  
//@param path_client = caminho utilizado para salvar o arquivo copiado do servidor no TCP_Cliente
  

public class TCP_Cliente {
	private String ip_server; 
	
	public TCP_Cliente(String ip_server){
		super();
		this.ip_server = ip_server;
	}
	
    public boolean copiarArquivo(String path_server,String path_client) {  
        path_server += "\n";  
        path_client = new File(path_client).getPath();  
        FileOutputStream fos = null;  
  
        try {  
            Socket socket = new Socket(ip_server, 6789);  
            OutputStream out = socket.getOutputStream();  
            InputStream in = socket.getInputStream();  
  
            out.write(path_server.getBytes());  
  
            fos = new FileOutputStream(path_client);  
  
  
            byte[] buf = new byte[1024];  
  
            while (true) {  
                int len = in.read(buf);  
                if (len == -1) {  
                    break;  
                }  
                fos.write(buf, 0, len);  
            }  
            socket.close();  
            fos.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return true;
    } 
    
    

}  
