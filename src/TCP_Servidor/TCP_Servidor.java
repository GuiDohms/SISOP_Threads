package TCP_Servidor;
import java.io.*;  
import java.net.*; 

public class TCP_Servidor {
	public static void main(String[] arr) throws IOException, InterruptedException {  
		  
        ServerSocket ss = new ServerSocket(6789);  
        File file = null;  
        System.out.println("Servidor iniciado, na espera de uma conexão:");
        while (true) {  
            InputStream in = null;  
            OutputStream out = null;  
            Socket cliente = ss.accept();
            Thread_Copiar tc = new Thread_Copiar(cliente,file,in,out);
            Thread copiar = new Thread(tc);
            copiar.start();
            copiar.sleep(2000);
     }
	}
}
