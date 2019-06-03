package hotword.spider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class fenleiPa {
    static String url="http://www.xinhuanet.com/info/index.htm";
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	/**
    	 * 爬取网站  https://www.ofweek.com/
    	 * 分类按照新闻网站上的分：包含
    	 * 市场、趋势、热点、视点、财经、技术 
    	 * 目前6个
    	 */
    	
    	
    	 /**
         * 网址前缀：
         * 市场分类  "https://www.ofweek.com/CATList-8400-SHICHANGYUANJIU-"
         * 趋势分类 "https://www.ofweek.com/CATListNew-25000-8000-"
         * 热点分类 "https://www.ofweek.com/CATListNew-25000-10000-"
         * 视点分类 "https://www.ofweek.com/CATList-8500-BIANJISHIDIAN-"
         * 财经分类 "https://finance.ofweek.com/finance/75011/100/100/"
         * 技术分类 "https://www.ofweek.com/CATListNew-73000-0-"
         */
  
    	String shichangPre = "https://www.ofweek.com/CATList-8400-SHICHANGYUANJIU-";
    	String qushiPre = "https://www.ofweek.com/CATListNew-25000-8000-";
    	String redianPre = "https://www.ofweek.com/CATListNew-25000-10000-";
    	String shidianPre = "https://www.ofweek.com/CATList-8500-BIANJISHIDIAN-";
    	String caijingPre = "https://finance.ofweek.com/finance/75011/100/100/";
    	String jishuPre = "https://www.ofweek.com/CATListNew-73000-0-";
			
       String content = Blog("市场",shichangPre );
       /* Blog("趋势",qushiPre );
        Blog("热点",redianPre );
        Blog("视点",shidianPre );
        Blog("财经",caijingPre );
        Blog("技术",jishuPre );*/
       System.out.println(content);
        
    }

    /**
     * 获取指定博客文章的内容
     */
    public static String Blog(String type,String typeURL) {
        Document doc,doc1;
       String content = "";
        try {
        	if(type == "财经") {
        		System.out.println("财经----");
        		for (int i = 1; i < 2; i++) { //每个分类爬取的页数
	        		doc = Jsoup.connect(typeURL + i + ".html").get();
	        		Elements ListDiv = doc.getElementsByAttributeValue("class","model_right model_right2").select("h3");
	        		for (Element element :ListDiv) {
		            	String title = element.text();
		            	
		        		System.out.println(type + "-page"+ i+ "-------------------------------------");
		                System.out.println("----html()--" + element.html());
	            		System.out.println("----text()--" + title);
	            		
	            		content += (title +"\n");
	            		//写入文件
			           // writeFileByLine(title+"\r\n", "E:\\爬取\\" + type + ".txt");
	        		}
	            }
        		
        	}else {
        	
	        	for (int i = 1; i < 2; i++) { //每个分类爬取的页数
	        		doc = Jsoup.connect(typeURL + i + ".html").get();
	        		Elements ListDiv = doc.getElementsByAttributeValue("class","wen").select("h3");
	        		for (Element element :ListDiv) {
		            	String title = element.text();
		            	
		        		System.out.println(type + "-page"+ i+ "-------------------------------------");
		                System.out.println("----html()--" + element.html());
	            		System.out.println("----text()--" + title);
		            
	            		content += (title +"\n");
	            		//写入文件
			          //  writeFileByLine(title+"\r\n", "E:\\爬取\\" + type + ".txt");
		                
		              
	        		}
	            }
        	}
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return content;
    }
    
    
    /**
	 * 将内容一行行写入到文件中
	 * @param content 内容
	 * @param filePath 文件路径
	 * @return void 无
	 */
	public static void writeFileByLine(String content,String filePath) {
		File file = null;
		PrintWriter writer = null;
		
		try {
			 //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer1 = new FileWriter(filePath, true);
            writer1.write(content);
            writer1.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(writer != null) {
				
			}
		}	
		
	}
	

}
