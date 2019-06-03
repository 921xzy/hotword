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

public class Test2 {
    static String url="http://www.xinhuanet.com/info/index.htm";
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        // TODO Auto-generated method stub
        //BolgBody();
        //test();
        Blog();
        
    	//article();
        /*
         * Document doc = Jsoup.connect("http://www.oschina.net/")
         * .data("query", "Java") // 请求参数 .userAgent("I ’ m jsoup") // 设置
         * User-Agent .cookie("auth", "token") // 设置 cookie .timeout(3000) //
         * 设置连接超时时间 .post();
         */// 使用 POST 方法访问 URL

        /*
         * // 从文件中加载 HTML 文档 File input = new File("D:/test.html"); Document doc
         * = Jsoup.parse(input,"UTF-8","http://www.oschina.net/");
         */
    }

    /**
     * 获取指定HTML 文档指定的body
     * @throws IOException
     */
    private static void BolgBody() throws IOException {
        // 直接从字符串中输入 HTML 文档
        String html = "<html><head><title> 开源中国社区 </title></head>"
                + "<body><p> 这里是 jsoup 项目的相关文章 </p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.body());
        System.out.println("****************************************");
        
        // 从 URL 直接加载 HTML 文档
        Document doc2 = Jsoup.connect(url).get();
        String title = doc2.body().toString();
        System.out.println(title);
    }

    /**
     * 获取博客上的文章标题和链接
     */
    public static void article() {
        Document doc;
        try {
            doc = Jsoup.connect("http://www.cnblogs.com/zyw-205520/").get();
            Elements ListDiv = doc.getElementsByAttributeValue("class","postTitle");
            for (Element element :ListDiv) {
                Elements links = element.getElementsByTag("a");
                for (Element link : links) {
                    String linkHref = link.attr("href");
                    String linkText = link.text().trim();
                    System.out.println(linkHref);
                    System.out.println(linkText);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    /**
     * 获取指定博客文章的内容
     */
    public static void Blog() {
        Document doc,doc1;
        String keywords = "信息化";
        try {
        	for (int i = 1; i < 301; i++) {
        		//网页内选择按时间排序  Sequence=1
        		doc = Jsoup.connect("http://www.ofweek.com/newquery.action?type=1&subtype=0&keywords=" + keywords +"&pagenum=" + i + "&Sequence=1").get();
        		Elements ListDiv = doc.getElementsByAttributeValue("class","zixun").select("a");
        		for (Element element :ListDiv) {
	            	String linkHref = element.attr("href");
	            	String title = element.text();
	            	
	        		System.out.println("page"+ i+ "-------------------------------------");
	                System.out.println("----html()--" + element.html());
            		System.out.println("----text()--" + title);
	                System.out.println("***"+linkHref);
	                if("".equals(title) || title == null) { //获取到的是img标签
	                	//System.out.println("图片");
		              //  writeFileByLine("图片"+"\r\n", "E:\\爬取\\s标题.txt");
	                	continue;
	                }else {
		                writeFileByLine(title+"\r\n", "E:\\爬取\\s标题.txt");
	                }
	                

	                /*doc1 = Jsoup.connect(linkHref).get();
	                Elements ListDiv1 = doc1.getElementsByAttributeValue("class","article_con").select("p").removeAttr("img");
	                for (Element element1 :ListDiv1) {
	                	 System.out.println("-------------------------------------");
	                	System.out.println(element1.html());
	                	//将文字信息转换成文本文件存储在本地服务器中
	                	writeFileByLine(element1.html()+"\r\n", "E:\\s1热词.txt");
	                }*/
        		}
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
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
			
					
		/*//创建一个写入的文件
		file = new File(filePath);
		//获取输出文件流的对象
		writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
		//写入到文件内容中
		writer.print(content);
		//刷新同步一次
		writer.flush();*/
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(writer != null) {
				
			}
		}	
		
	}
	

}
