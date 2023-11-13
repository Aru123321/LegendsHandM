// this class has attributes used by all items in the market
package items;
public abstract class Items{
	protected String name;
	protected int cost;
	protected int reqLevel;
	// constructor
	public Items(String name, int price, int reqLevel){
		this.name = name;
		this.cost = price;
		this.reqLevel = reqLevel;
	}
	public String getName(){
		return name;
	}
	public int getCost(){
		return cost;
	}
	public int getReqLevel(){
		return reqLevel;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setCost(int cost){
		this.cost = cost;
	}
	public void setLevel(int reqLevel){
		this.reqLevel = reqLevel;
	}

}