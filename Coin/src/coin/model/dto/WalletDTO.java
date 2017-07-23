package coin.model.dto;

import java.util.ArrayList;

public class WalletDTO {
	private String mid;
	private ArrayList<WalletCoinDTO> walletCoins;
	
	public WalletDTO() {}
	public WalletDTO(String mid, ArrayList<WalletCoinDTO> walletCoins) {
		this.mid = mid;
		this.walletCoins = walletCoins;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public ArrayList<WalletCoinDTO> getWalletCoins() {
		return walletCoins;
	}
	public void setWalletCoins(ArrayList<WalletCoinDTO> walletCoins) {
		this.walletCoins = walletCoins;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WalletDTO [mid=");
		builder.append(mid);
		builder.append(", walletCoins=");
		builder.append(walletCoins);
		builder.append("]");
		return builder.toString();
	}
	
	
}
