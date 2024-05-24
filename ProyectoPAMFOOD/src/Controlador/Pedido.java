package Controlador;

import org.json.JSONException;
import org.json.JSONObject;

public class Pedido {
	Client cliente;
	String id;
	public Pedido(JSONObject jsonObject) throws JSONException {
		this.id = jsonObject.getString("id");
		JSONObject cliente = jsonObject.getJSONObject("cliente");
		this.cliente = new Client(cliente);
	}
	public JSONObject toJSONObject() throws JSONException {
		JSONObject jsonPedido = new JSONObject();
		jsonPedido.put("id", this.id);
		jsonPedido.put("cliente", this.cliente);
		return jsonPedido;
	}
	public Pedido(Client cliente, String id) {
		super();
		this.cliente = cliente;
		this.id = id;
	}
	public Client getCliente() {
		return cliente;
	}
	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
