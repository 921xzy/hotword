package hotword.fenci;

import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;

import hotword.bean.HotWord;
import hotword.dao.HotWordDaoImpl;
import hotword.spider.fenleiPa;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("首次编译运行时，HanLP会自动构建词典缓存，请稍候……\n");
        //第一次运行会有文件找不到的错误但不影响运行，缓存完成后就不会再有了
        System.out.println("标准分词：");
        System.out.println(HanLP.segment("你好，欢迎使用HanLP！"));
        System.out.println("\n");

      /*  List<Term> termList = NLPTokenizer.segment("国产代替 MCU成最大突破口\r\n");
        System.out.println("NLP分词：");
        System.out.println(termList);
        System.out.println("\n");
        */
        
        
        String shichangPre = "https://www.ofweek.com/CATList-8400-SHICHANGYUANJIU-";
    	String qushiPre = "https://www.ofweek.com/CATListNew-25000-8000-";
    	String redianPre = "https://www.ofweek.com/CATListNew-25000-10000-";
    	String shidianPre = "https://www.ofweek.com/CATList-8500-BIANJISHIDIAN-";
    	String caijingPre = "https://finance.ofweek.com/finance/75011/100/100/";
    	String jishuPre = "https://www.ofweek.com/CATListNew-73000-0-";
        
    	//提取并直接写入数据库
        System.out.println("关键字提取：");
        getMainIdea("市场",shichangPre);
        getMainIdea("趋势",qushiPre );
        getMainIdea("热点",redianPre );
        getMainIdea("视点",shidianPre );
        getMainIdea("财经",caijingPre );
        getMainIdea("技术",jishuPre );
        System.out.println("\n");
	}

	
	/**
	 * 关键字提取
	 */
	public static void getMainIdea(String type,String typeURL) {
		
		fenleiPa paqu = new fenleiPa();
		
		String content = paqu.Blog(type,typeURL);	
        List<String> keywordList = HanLP.extractKeyword(content, 25);
        System.out.println(keywordList); 
        HotWord hotWord = new HotWord();
        hotWord.setType(type);
        for(String keyword : keywordList) {
        	if(keyword.length() > 1) {//关键字长度大于1就写入数据库
        		HotWordDaoImpl wordDao = new HotWordDaoImpl();
        		hotWord.setName(keyword);
        		wordDao.add(hotWord);
                System.out.println(keyword);
        	}
        }
        
        
    }
}
