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
			throw new NotExistException("검색하는 회원이 미 존재합니다.");
		}
	}
	public static boolean addMember(MemberDTO member) throws MessageException{
		boolean result = false;
		try{
			result = MemberDAO.addMember(member);
			MemberDAO.getMember(member.getId()).setWallet(new WalletDTO(member.getId(), getWalletCoin(member.getId())));
		}catch(SQLException s){
			throw new MessageException("이미 존재하는 ID입니다. 다시 시도 하세요.");
		}
		return result;
	}
	
	// id로 회원 조회
	public static MemberDTO getMember(String memberId) throws SQLException, NotExistException{
		MemberDTO member = MemberDAO.getMember(memberId);
		if(member == null){
			throw new NotExistException("존재하지 않는 ID 입니다.");
		}
		return member;
	}
	
	// 모든 내코인 정보 조회
	public static ArrayList<WalletCoinDTO> getWalletCoin(String memberId) throws SQLException{
		return MemberDAO.getWalletCoin(memberId);
	}
	
	// 코인이름으로 내코인 정보 조회
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
	// 코인이름으로 내코인 모든 정보 조회
	public static ArrayList<Integer> getAllCoinInfo(String memberId) throws SQLException{
		ArrayList<Integer> allCoinInfo = MemberDAO.getAllWalletData(memberId);
		return allCoinInfo;
	}
	
	// 내 코인 정보 업데이트
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
			throw new NotExistException("코인 정보 수정 실패");
		}
		return result;
	}
}
