package TCP_Cliente;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import TCP_Servidor.TCP_Servidor;

	  
// @param ip_server = IP do TCP_Servidor
	 
//@param path_server = caminho do arquivo no TCP_Servidor 
	 
//@param path_client = caminho utilizado para salvar o arquivo copiado do servidor no TCP_Cliente
	  
//@param file_name = coloca o arquivo no destino usando o path_client
	  

	public class Thread_app {

		public static void main(String[] args) throws IOException {
			
			int opcao;
			String ip_server="";
			String path_client="H:\\";
			String path_server="H:/";
			String file_name="";
			
			
			Scanner sc=new Scanner(System.in);	
			
			do{
				System.out.println("******************************************");
				System.out.println("Digite o número referente a opção desejada");
				System.out.println("1 - Iniciar Cliente TCP");
				System.out.println("2 - Configurações");
				System.out.println("9 - Sair");
				System.out.println("******************************************");
				
				opcao=sc.nextInt();
				switch (opcao){
				case 1:
					if(ip_server==""){
						System.out.println("Digite o IP do Servidor: ");
						ip_server=sc.next();
					}
				
					System.out.println("Insira o nome do arquivo:");
					file_name = sc.next();
					
					
					
					File pasta_do_arquivo = new File(path_client);  //path destino
			        if(!pasta_do_arquivo.exists()) {  
			            pasta_do_arquivo.mkdirs();  //irá criar uma pasta para colar o file no cliente
			        }  
					
			        TCP_Cliente cli= new TCP_Cliente(ip_server);
					
					if(cli.copiarArquivo(path_server+file_name,pasta_do_arquivo.getAbsolutePath()+File.separator+"copyOf_"+file_name)==true){
						System.out.println("Arquivo copiado!");
					}
					break;
				case 2:
					System.out.println("Configurações");
					System.out.println("Digite o IP do Servidor: ");
					ip_server=sc.next();
					
					break;
				case 0:
					System.out.println("Fim");
					break;
				default:
					
				}

			}while(opcao!=0);
			sc.close();

		}

	}

