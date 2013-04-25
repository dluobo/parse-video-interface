package org.apache.nutch.parse.html.video.webservice;

import javax.jws.WebService;

import org.apache.nutch.parse.html.video.database.business.VideoBusiness;
import org.apache.nutch.parse.html.video.database.model.AreaCategoryTbl;
import org.apache.nutch.parse.html.video.util.BeanUtil;
import org.apache.nutch.parse.html.video.webservice.data.Test;

import java.util.ArrayList;
import java.util.List;

@WebService
public class VideoWebservice {
	private VideoBusiness videoinfoBean;
    
    public int addNumbers(int number1, int number2) throws VideoException {
        if (number1 < 0 || number2 < 0) {
            throw new VideoException("Negative number cant be added!",
                "Numbers: " + number1 + ", " + number2);
        }
        return number1 + number2;
    }

    public ArrayList<Test> getList() throws VideoException {
         
            ArrayList<Test> ret = new ArrayList<Test>();
            Test t1 = new Test();
            t1.id = 5;
            t1.desc = "hello";
            ret.add(t1);
            Test t2 = new Test();
            t2.id = 67;
            t2.desc = "hello 67";
            ret.add(t2);
            
            return ret;
   }
    
    public List<AreaCategoryTbl> getAreaInfo()throws VideoException {
    	videoinfoBean = (VideoBusiness) BeanUtil.getBean("VideoBusiness");
    	return videoinfoBean.getAreaInfo();
    }
}
