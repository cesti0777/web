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

	// ��� ��Ʈ���� ���� ��ȯ
	public static ArrayList<BtcDTO> getAllBtc() throws SQLException{
		return BtcDAO.getAllBtc();
	}
	
	// ��¥�� ��Ʈ���� �˻�
	public static BtcDTO getBtc(String date) throws SQLException, NotExistException{
		BtcDTO btc = BtcDAO.getBtc(date);
		if(btc == null){
			throw new NotExistException("�����Ͻ� ��¥�� ������ �����ϴ�.");
		}
		return btc;
	}
	
	// �������� ����
	public static boolean addBtc(BtcDTO btc) throws SQLException{
		return BtcDAO.addBtc(btc);
	}

	// �������� ����
	public static boolean addEth(EthDTO eth) throws SQLException {
		return EthDAO.addEth(eth);
	}

	// �������� ����
	public static boolean addLtc(LtcDTO ltc) throws SQLException {
		return LtcDAO.addLtc(ltc);
	}

	// �������� ����
	public static boolean addEtc(EtcDTO etc) throws SQLException {
		return EtcDAO.addEtc(etc);
	}

	// �������� ����
	public static boolean addXrp(XrpDTO xrp) throws SQLException {
		return XrpDAO.addXrp(xrp);
	}

	// �������� ����
	public static boolean addDash(DashDTO dash) throws SQLException {
		return DashDAO.addDash(dash);
	}
}
