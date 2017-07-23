package coin.model;

import java.sql.SQLException;
import java.util.ArrayList;

import coin.exception.MessageException;
import coin.exception.NotExistException;
import coin.model.dto.MemberDTO;
import coin.model.dto.WalletCoinDTO;
import coin.model.dto.WalletDTO;


public class MemberService {

	//Member - CRUD
	public static void notExistMember(String memberId) throws NotExistException, SQLException{
		MemberDTO member = MemberDAO.getMember(memberId);
		if(member == null){
			throw new NotExistException("�˻��ϴ� ȸ���� �� �����մϴ�.");
		}
	}
	public static boolean addMember(MemberDTO member) throws MessageException{
		boolean result = false;
		try{
			result = MemberDAO.addMember(member);
			MemberDAO.getMember(member.getId()).setWallet(new WalletDTO(member.getId(), getWalletCoin(member.getId())));
		}catch(SQLException s){
			throw new MessageException("�̹� �����ϴ� ID�Դϴ�. �ٽ� �õ� �ϼ���.");
		}
		return result;
	}
	
	// id�� ȸ�� ��ȸ
	public static MemberDTO getMember(String memberId) throws SQLException, NotExistException{
		MemberDTO member = MemberDAO.getMember(memberId);
		if(member == null){
			throw new NotExistException("�������� �ʴ� ID �Դϴ�.");
		}
		return member;
	}
	
	// ��� ������ ���� ��ȸ
	public static ArrayList<WalletCoinDTO> getWalletCoin(String memberId) throws SQLException{
		return MemberDAO.getWalletCoin(memberId);
	}
	
	// �����̸����� ������ ���� ��ȸ
	public static WalletCoinDTO getCoinInfo(String memberId, String coinName) throws SQLException{
		ArrayList<WalletCoinDTO> walletCoin = MemberDAO.getWalletCoin(memberId);
		WalletCoinDTO coinInfo = null;
		for(int i = 0; i<walletCoin.size() ; i++){
			coinInfo = walletCoin.get(i);
			if(coinInfo.getCoinName().equals(coinName)){
				return coinInfo;
			}
		}
		return null;
	}
	// �����̸����� ������ ��� ���� ��ȸ
	public static ArrayList<Integer> getAllCoinInfo(String memberId) throws SQLException{
		ArrayList<Integer> allCoinInfo = MemberDAO.getAllWalletData(memberId);
		return allCoinInfo;
	}
	
	// �� ���� ���� ������Ʈ
	public static boolean updateCoin(String memberId, String cName, String updateType,int updateAmount, int updatePrice) throws SQLException, NotExistException{		
		WalletCoinDTO coinInfo = getCoinInfo(memberId, cName);
		int amount = coinInfo.getAmount() , price = coinInfo.getPrice();
		if(updateType.equals("buy")){
			amount += updateAmount;
			price += updatePrice;
		}else if(updateType.equals("sell")){
			amount -= updateAmount;
			if(amount == 0){
				price = 0;
			}else{
				price -= updatePrice;
			}
			if(price<0){
				price = 0;
			}
		}
		
		boolean result = MemberDAO.updateCoin(memberId, cName, amount, price); 
		if(!result){
			throw new NotExistException("���� ���� ���� ����");
		}
		return result;
	}
}
