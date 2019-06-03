package hotword.print;

import java.util.List;

import hotword.bean.HotWord;
import hotword.dao.HotWordDaoImpl;

/**
 * 把热词解释写入数据库
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
		System.out.println("热词解释已成功写入数据库！");
	}
}
