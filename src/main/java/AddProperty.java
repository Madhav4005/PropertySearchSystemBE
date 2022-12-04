import com.app.PropertySearchSystem.entity.Property;
import com.app.PropertySearchSystem.entity.Tax;

public class AddProperty {
	private Tax tax;
	private Property property;
	public Tax getTax() {
		return tax;
	}
	public void setTax(Tax tax) {
		this.tax = tax;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public AddProperty(Tax tax, Property property) {
		super();
		this.tax = tax;
		this.property = property;
	}
	
	

}
