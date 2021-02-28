package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosController {
	public ProcessosController() {
	super();
	}

	
	
	
	public String SoReader() {
		String os = System.getProperty("os.name");
		return os;
			}
	
	
	
	
	public void ListaProcessosPorSo (String os) {
		String process = "";
		if (os.contains("Windows")) {
			process = "TASKLIST /FO TABLE";
		}
		else {
			process = "ps -ef";
		}
		ReadProcess(process);	
	}
	
	
	
	
	
		public void ReadProcess (String process) {
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);	
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		public void MataProcessoPorSo(String os , String namePid) {
			String processName = "";
			String processPID = "";
			if (os.contains("Windows")) {
				processName = "TASKKILL /IM";
				processPID = "TASKKILL /PID";
			}
			else {
				processName = "pkill -f";
				processPID = "kill -9";
			}
			String finaliza = KillProcess (processName , processPID, namePid);
			try {
				Runtime.getRuntime().exec(finaliza);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
			public String KillProcess(String processName , String processPID, String namePid) {
				int pid = 0;
				StringBuffer buffer = new StringBuffer();
				try {
				pid = Integer.parseInt(namePid);
				buffer.append(processPID);
				buffer.append(" ");
				buffer.append(pid);
				} catch (NumberFormatException e) {
					buffer.append(processName);
					buffer.append(" ");
					buffer.append(namePid);
				}
				return buffer.toString();
				
			}
	}
	
	


