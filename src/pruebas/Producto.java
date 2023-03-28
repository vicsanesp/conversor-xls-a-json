package pruebas;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Producto {
	//product|type|class|unit|market|commpos|date
	private String product;
	private String family;
	private String type;
	private String _class;
	private String unit;
	private String market;
	private String commpos;
	private String date;
	
	public Producto(String product, String family,String type, String _class, String unit, String market, String commpos, String date) {
		this.product = product;
		this.family = family;
		this.type = type;
		this._class = _class;
		this.unit = unit;
		this.market = market;
		this.commpos = commpos;
		this.date = date;
	}
	
	
	
	public String getProduct() {
		return product;
	}



	public void setProduct(String product) {
		this.product = product;
	}
	
	

	public String getFamily() {
		return family;
	}



	public void setFamily(String family) {
		this.family = family;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String get_class() {
		return _class;
	}



	public void set_class(String _class) {
		this._class = _class;
	}



	public String getUnit() {
		return unit;
	}



	public void setUnit(String unit) {
		this.unit = unit;
	}



	public String getMarket() {
		return market;
	}



	public void setMarket(String market) {
		this.market = market;
	}



	public String getCommpos() {
		return commpos;
	}



	public void setCommpos(String commpos) {
		this.commpos = commpos;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}

	public static List<String> linesFromFile(String file) {
		List<String> r = null;
		try {
			r = Files.readAllLines(Paths.get(file), Charset.defaultCharset());
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"No se ha encontrado el fichero " + file);
		}
		return r;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(_class, commpos, date, family, market, product, type, unit);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(_class, other._class) && Objects.equals(commpos, other.commpos)
				&& Objects.equals(date, other.date) && Objects.equals(family, other.family)
				&& Objects.equals(market, other.market) && Objects.equals(product, other.product)
				&& Objects.equals(type, other.type) && Objects.equals(unit, other.unit);
	}



	@Override
	public String toString() {
		return "{\"product :" + " \""+product+"\"" +", \"family\" :"+" \""+family+"\""+ ", \"type\" :" + " \""+type+"\"" + ", \"_class\" :" + " \""+_class+"\"" + ", \"unit\" :" + " \""+unit+"\"" + ", \"market\" :"
				+ " \""+market+"\"" + ", \"commpos\" :" + " \""+commpos+"\"" + ", \"date\" :" + " \""+date+"\"" + "}";
	}



	public static void main(String[] args) {
		Producto prueba = new Producto("producto", "familia","tipo", "clase", "unidad", "mercado", "compos", "fecha");
		System.out.println(prueba.toString());

	}

}
