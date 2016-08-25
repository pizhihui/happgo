import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DealLogFile {
	
	private static final String filePath = "demo.log";
	
	public static void main(String[] args) {
		File file = new File(filePath);
        try (FileReader fr=new FileReader(file);BufferedReader reader = new BufferedReader(fr);){
            
            String tempString = null;
            Map<String,String> map = new LinkedHashMap<String,String>();
            List<String> list = new LinkedList<String>();
            list.parallelStream().collect(Collectors.groupingBy(s -> Utility))
            while ((tempString = reader.readLine()) != null) {
            	String[] split = tempString.split(" ");
            	map.put(split[3], split[3].substring(split[3].indexOf(":")+1));
            	list.add(split[3].substring(split[3].indexOf(":")+1));
            	//System.out.println(split[3] + "..." + split[3].substring(split[3].indexOf(":")+1));
            }
           
            for(int i=0;i<list.size();i++){
            	String lastVal = formatTimeToMs(list.get(i+1));
            	String currVal = formatTimeToMs(list.get(i)); 
            	if(Integer.valueOf(currVal)-Integer.valueOf(lastVal) > 30*3600)
            	//formatTimeToMs(list.get(i))
            	
            	//if((list.get(i+1)-list.get(i))>)
            	
            }
            
            for(Map.Entry<String, String> entry:map.entrySet()){
            	String lastVal = formatTimeToMs(entry.getValue());
            	System.out.println();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public static String formatTimeToMs(String time ){
	    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	    Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return String.valueOf(date.getTime());
	    
	}
	
	
	
}
