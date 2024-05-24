package Modelo;
import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class CreateFileJSON {
   /*public static void main(String args[]) throws JSONException {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("ID", "1");
      jsonObject.put("First_Name", "Shikhar");
      jsonObject.put("Last_Name", "Dhawan");
      jsonObject.put("Date_Of_Birth", "1981-12-05");
      jsonObject.put("Place_Of_Birth", "Delhi");
      jsonObject.put("Country", "India");
      Object name = "Maria";
      System.out.println(new Gson().toJson(name));
      try {
         FileWriter file = new FileWriter("C:\\Users\\maria\\OneDrive - UPB\\UPB\\3 SEMESTRE\\Estructuras de Datos\\Proyecto Integrador\\OperadoresPaMFood\\output.json");
         file.write(new Gson().toJson(name));
         file.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      //System.out.println("JSON file created: "+jsonObject);
   }*/
	public void leerJSON() {
		JsonParser jsonParser = new JsonParser();
		try {
			FileReader reader = new FileReader("clientes.json");
			Object obj = jsonParser.parse(reader);
			JsonObject objectJSON = (JsonObject) obj;
			System.out.println(objectJSON);
			Object nombre = (Object) objectJSON.get("nombre");
			Object direccion = (Object) objectJSON.get("direccion");
			System.out.println("Nombre: " + nombre);
			System.out.println("Direccion " + direccion);
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}
	public static void main(String[] args) {
		CreateFileJSON json = new CreateFileJSON();
		json.leerJSON();
	}
}