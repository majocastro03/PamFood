package Modelo;

import Controlador.Client;
import Listas.LinkedList;
import java.io.*;
import com.google.gson.Gson;

public class UserFile {
	private String fileName;

	public UserFile(String fileName) {
		this.fileName = fileName;
	}

	public void addUser(String cliente) throws IOException {
		FileWriter fileWriter = new FileWriter(this.fileName, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(cliente);
		bufferedWriter.newLine();
		bufferedWriter.close();
	}

	public Client getUsers() throws IOException {
		FileReader fileReader = new FileReader(this.fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		LinkedList<Client> Pasajeros;
		Client client;
		line = bufferedReader.readLine();
		client = (Client) new Gson().fromJson(line, Object.class);
		bufferedReader.close();
		return client;
	}

	public void eliminarUser() {
		try {
			FileWriter fileWriter = new FileWriter(this.fileName);
			fileWriter.write("");
			fileWriter.close();
			System.out.println("Todos los datos han sido eliminados del archivo " + this.fileName);
		} catch (IOException e) {
			System.err.println("Ha ocurrido un error al eliminar los datos del archivo " + this.fileName);
			e.printStackTrace();
		}
	}

}
