package coin.model.dto;

public class WalletCoinDTO {
	private String coinName;
	private int amount;
	private int price;
	
	public WalletCoinDTO() {}
	public WalletCoinDTO(String coinName, int amount, int price) {
		this.coinName = coinName;
		this.amount = amount;
		this.price = price;
	}
	
	public String getCoinName() {
		return coinName;
	}
	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WalletCoinDTO [coinName=");
		builder.append(coinName);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
	
	
}
