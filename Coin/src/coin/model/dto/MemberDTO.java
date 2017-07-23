package coin.model.dto;

public class MemberDTO {
	private String id;
	private String name;
	private String pw;
	private String email;
	private WalletDTO wallet;
	public MemberDTO() {}
	public MemberDTO(String id, String name, String pw, String email) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.email = email;
	}
	public MemberDTO(String id, String name, String pw, String email, WalletDTO wallet) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.wallet = wallet;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public WalletDTO getWallet() {
		return wallet;
	}
	public void setWallet(WalletDTO wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", pw=");
		builder.append(pw);
		builder.append(", email=");
		builder.append(email);
		builder.append(", wallet=");
		builder.append(wallet);
		builder.append("]");
		return builder.toString();
	}
}
