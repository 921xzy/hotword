package hotword.print;

import java.util.List;

import hotword.bean.HotWord;
import hotword.dao.HotWordDaoImpl;

/**
 * ���ȴʽ���д�����ݿ�
 * @author Administrator
 *
 */
public class putInDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotWordDaoImpl wordDao = new HotWordDaoImpl();
		List<HotWord> hotwords = wordDao.load();
		String wordExplain = null;
		for(HotWord word : hotwords) {
			wordExplain = wordDao.getExplain(word.getName());
			word.setWordExplain(wordExplain);
			System.out.println("success-----------------------------");
			wordDao.update(word);
		}
		System.out.println("�ȴʽ����ѳɹ�д�����ݿ⣡");
	}
}
