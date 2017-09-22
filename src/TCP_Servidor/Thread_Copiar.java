package TCP_Servidor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Thread_Copiar implements Runnable {
	Socket cliente;
	File file;
	InputStream in;
	OutputStream out;
		
	public Thread_Copiar(Socket cliente,File file,InputStream in,OutputStream out) {
		this.cliente = cliente;
		this.file = file;
		this.in = in;
		this.out = out;
	}
		
	@Override
	public void run() {
		try {  
			System.out.println("Conexão iniciada pelo: " + cliente);  
	        BufferedReader input = new BufferedReader(new InputStreamReader(cliente.getInputStream()));  
	        String path = input.readLine();  
	        System.out.println("Solicitar arquivo: "+path);  
	        file = new File(path);  

	            in = new FileInputStream(file);  
	            out = cliente.getOutputStream();  

	            byte[] buf = new byte[1024];  
	            int len;  
	            while ((len = in.read(buf)) > 0) {  
	                out.write(buf, 0, len);  
	            }  
	            cliente.close();  
	        } catch (IOException ex) {  
	            ex.printStackTrace(System.err);  
	        } finally {  
	            try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}  
	        }  
		}
		
}

