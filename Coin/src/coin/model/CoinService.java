package coin.model;

import java.sql.SQLException;
import java.util.ArrayList;

import coin.exception.NotExistException;
import coin.model.dto.BtcDTO;
import coin.model.dto.DashDTO;
import coin.model.dto.EtcDTO;
import coin.model.dto.EthDTO;
import coin.model.dto.LtcDTO;
import coin.model.dto.XrpDTO;
public class CoinService {

	// 모든 비트코인 정보 반환
	public static ArrayList<BtcDTO> getAllBtc() throws SQLException{
		return BtcDAO.getAllBtc();
	}
	
	// 날짜로 비트코인 검색
	public static BtcDTO getBtc(String date) throws SQLException, NotExistException{
		BtcDTO btc = BtcDAO.getBtc(date);
		if(btc == null){
			throw new NotExistException("선택하신 날짜의 코인이 없습니다.");
		}
		return btc;
	}
	
	// 코인정보 저장
	public static boolean addBtc(BtcDTO btc) throws SQLException{
		return BtcDAO.addBtc(btc);
	}

	// 코인정보 저장
	public static boolean addEth(EthDTO eth) throws SQLException {
		return EthDAO.addEth(eth);
	}

	// 코인정보 저장
	public static boolean addLtc(LtcDTO ltc) throws SQLException {
		return LtcDAO.addLtc(ltc);
	}

	// 코인정보 저장
	public static boolean addEtc(EtcDTO etc) throws SQLException {
		return EtcDAO.addEtc(etc);
	}

	// 코인정보 저장
	public static boolean addXrp(XrpDTO xrp) throws SQLException {
		return XrpDAO.addXrp(xrp);
	}

	// 코인정보 저장
	public static boolean addDash(DashDTO dash) throws SQLException {
		return DashDAO.addDash(dash);
	}
}
