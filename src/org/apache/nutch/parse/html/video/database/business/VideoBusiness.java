package org.apache.nutch.parse.html.video.database.business;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.chilicat.m3u8.ParseException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.nutch.parse.html.video.database.dao.AreaCategoryTblMapper;
import org.apache.nutch.parse.html.video.database.dao.ContentSupplierTblMapper;
import org.apache.nutch.parse.html.video.database.dao.FirstlevelCategoryTblMapper;
import org.apache.nutch.parse.html.video.database.dao.OptTblMapper;
import org.apache.nutch.parse.html.video.database.dao.SecondlevelCategoryTblMapper;
import org.apache.nutch.parse.html.video.database.dao.VideoBaseinfoTblMapper;
import org.apache.nutch.parse.html.video.database.dao.VideoCrawlinfoTblMapper;
import org.apache.nutch.parse.html.video.database.dao.VideoPlayinfoTblMapper;
import org.apache.nutch.parse.html.video.database.dao.VideoScRefTblMapper;
import org.apache.nutch.parse.html.video.database.dao.VideoSourceinfoTblMapper;
import org.apache.nutch.parse.html.video.database.model.AreaCategoryTbl;
import org.apache.nutch.parse.html.video.database.model.AreaCategoryTblExample;
import org.apache.nutch.parse.html.video.database.model.ContentSupplierTblExample;
import org.apache.nutch.parse.html.video.database.model.ContentSupplierTblExample.Criteria;
import org.apache.nutch.parse.html.video.database.model.FirstlevelCategoryTbl;
import org.apache.nutch.parse.html.video.database.model.SecondlevelCategoryTbl;
import org.apache.nutch.parse.html.video.database.model.VideoBaseinfoTbl;
import org.apache.nutch.parse.html.video.database.model.VideoBaseinfoTblExample;
import org.apache.nutch.parse.html.video.database.model.VideoCrawlinfoTbl;
import org.apache.nutch.parse.html.video.database.model.VideoPlayinfoTbl;
import org.apache.nutch.parse.html.video.database.model.VideoScRefTbl;
import org.apache.nutch.parse.html.video.database.model.VideoSourceinfoTbl;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

public class VideoBusiness {	

	private static final Log LOG = LogFactory.getLog(VideoBusiness.class.getName());
	@Resource(name="ContentSupplierTblMapper")
	private ContentSupplierTblMapper csMapper;
	/*
	 * AreaCategoryTblMapper
	 *
	 * @Select("select ac_id from area_category_tbl where ac_name=#{area}")
    public Integer getAcIdByName(@Param("area") String area);
    
    @Select("select max(ac_id) from area_category_tbl")
    public Integer getLastAcId();
	 */
	@Resource(name="AreaCategoryTblMapper")
	private AreaCategoryTblMapper areaMapper;
	/*
	 * FirstlevelCategoryTblMapper
	 * @Select("select fc_id from firstlevel_category_tbl where fc_name=#{fcname}")
    public Integer getFcIdByName(@Param("fcname") String fcname);
    
    @Select("select max(fc_id) from firstlevel_category_tbl")
    public Integer getLastFcId();
	 */
	@Resource(name="FirstlevelCategoryTblMapper")
	private FirstlevelCategoryTblMapper flMapper;
	
	/*
	 * SecondlevelCategoryTblMapper
	 * @Select("select sc_id from secondlevel_category_tbl where sc_name=#{scname}")
    public Integer getScIdByName(@Param("scname") String scname);
    
    @Select("select max(sc_id) from secondlevel_category_tbl")
    public Integer getLastScId();
	 */
	@Resource(name="SecondlevelCategoryTblMapper")
	private SecondlevelCategoryTblMapper slMapper;
		
	/*
	 * VideoBaseinfoTblMapper
	 * @Select("select last_insert_id() from video_baseinfo_tbl")
    public Integer getLastVbId();
	 */
	@Resource(name="VideoBaseinfoTblMapper")
	private VideoBaseinfoTblMapper videoBaseInfoMapper;
	
	@Resource(name="VideoScRefTblMapper")
	private VideoScRefTblMapper videoScMapper;
	
	@Resource(name="VideoCrawlinfoTblMapper")
	private VideoCrawlinfoTblMapper videoCrawlinfoMapper;

	@Resource(name="VideoSourceinfoTblMapper")
	private VideoSourceinfoTblMapper vsinfoMapper;
	
	@Resource(name="VideoPlayinfoTblMapper")
	private VideoPlayinfoTblMapper vpinfoMapper;
	
	@Resource(name="OptTblMapper")
	private OptTblMapper optMapper;
	
	int addAreainfo(String area){
		Integer id = optMapper.getAcIdByNameFromAcTbl(area);
		if (id == null){
			AreaCategoryTbl record = new AreaCategoryTbl();
			record.setAcName(area);
			areaMapper.insertSelective(record);
			Integer ret = optMapper.getLastId();
			if (ret == null)
				return -1;
			LOG.info("insert into video_areainfo_tbl value("
					+ret
					+","+area
					+")"
				);
			return ret;
		}
		else
			return id;
	}
	
	int addFc(String fcname){
		Integer id = optMapper.getFcIdByNameFromFcTbl(fcname);
		if (id == null){
			FirstlevelCategoryTbl record = new FirstlevelCategoryTbl();
			record.setFcName(fcname);
			flMapper.insertSelective(record);;
			Integer ret = optMapper.getLastId();
			if (ret == null)
				return -1;
			LOG.info("insert into FirstlevelCategoryTbl value("
					+ret
					+","+fcname
					+")"
				);
			return ret;
		}
		else
			return id; 
	}
	
	int addSc(short fcid,String scname){
		Integer id = optMapper.getScIdByNameFromScTbl(scname);
		if (id == null){
			SecondlevelCategoryTbl record = new SecondlevelCategoryTbl();
			record.setScName(scname);
			record.setFcId(fcid);
			slMapper.insertSelective(record);
			Integer ret = optMapper.getLastId();
			if (ret == null)
				return -1;
			LOG.info("insert into SecondlevelCategoryTbl value("
					+ret
					+","+fcid
					+","+scname
					+")"
				);
			return ret;
		}
		else
			return id;
	}
	
	void addScVideo(short[] sl, int vbid){
		Integer id = optMapper.getIdByVbidFromScRefTbl(vbid);
		if (id != null){
			return;
		}
		for(int i=0;i<sl.length;i++){
			VideoScRefTbl record = new VideoScRefTbl();
			record.setScId(sl[i]);
			record.setVbId(vbid);
			videoScMapper.insertSelective(record);
			LOG.info("insert into VideoScRefTbl value("
					+","+sl[i]
					+","+vbid
					+")"
				);
		}
	}
	
	int addVideoBaseinfo(VideoBaseinfoTbl info){
//		VideoBaseinfoTblExample example = new VideoBaseinfoTblExample();
//		VideoBaseinfoTblExample.Criteria con = example.createCriteria();
//		con.andFcIdEqualTo(info.getFcId());
//		con.andVbYearEqualTo(info.getVbYear());
//		con.andVbNameEqualTo(info.getVbName());
		Integer vbid=-1;
		if (info.getVbYear()!=null){
			vbid=optMapper.getVbIdByTypeYearTitleFromVbTbl(info.getFcId(),info.getVbYear(),info.getVbName());
		}else{
			vbid=optMapper.getVbIdByTypeTitleFromVbTbl(info.getFcId(),info.getVbName());
		}
		if (vbid == null){
			videoBaseInfoMapper.insertSelective(info);
			Integer ret = optMapper.getLastId();
			if (ret == null)
				return -1;
			LOG.info("insert into video_baseinfo_tbl value("
					+ret
					+","+info.getFcId()
					+","+info.getAcId()
					+","+info.getVbName()
					+","+info.getVbActor()
					+","+info.getVbDirector()
					+")"
				);
			return ret;
		}else{
			info.setVbId(vbid);
			videoBaseInfoMapper.updateByPrimaryKeySelective(info);
			LOG.info("update video_baseinfo_tbl value("
					+vbid
					+","+info.getFcId()
					+","+info.getAcId()
					+","+info.getVbName()
					+","+info.getVbActor()
					+","+info.getVbDirector()
					+")"
				);
			return vbid;
		}
	}
	
	void addCrawlinfo(VideoCrawlinfoTbl info){
		int vbid = info.getVbId();
		Integer id = optMapper.getIdByVbidFromVcTbl(vbid);
		if (id == null){
			videoCrawlinfoMapper.insertSelective(info);
			Integer ret = optMapper.getLastId();
			LOG.info("insert into video_crawlinfo_tbl value("
					+ret
					+","+info.getCsId()
					+","+info.getVbId()
					+","+info.getVcOrifc()
					+","+info.getVcOrisc()
					+","+info.getVcVid()
					+","+info.getVcSettotal()
					+","+info.getVcDetailurl()
					+","+info.getVcCrawldate()
					+")"
				);
		}else{
			info.setId(id);
			videoCrawlinfoMapper.updateByPrimaryKeySelective(info);
			LOG.info("update video_crawlinfo_tbl value("
					+","+info.getId()
					+","+info.getCsId()
					+","+info.getVbId()
					+","+info.getVcOrifc()
					+","+info.getVcOrisc()
					+","+info.getVcVid()
					+","+info.getVcSettotal()
					+","+info.getVcDetailurl()
					+","+info.getVcCrawldate()
					+")"
				);
		}
	}
	
	void addSourceinfo(VideoSourceinfoTbl info) {
		String subid = info.getVsSubvid();
		Integer id = optMapper.getIdBySubvidFromVsTbl(subid);
		if (id == null){
			vsinfoMapper.insertSelective(info);
			Integer ret = optMapper.getLastId();
			LOG.info("insert into video_sourceinfo_tbl value("
					+ret
					+","+info.getCsId()
					+","+info.getVbId()
					+","+info.getVsSubvid()
					+","+info.getVsSubtitle()
					+","+info.getVsSetnumber()
					+","+info.getVsSourceurl()
					+")"
				);
		}else{
			info.setId(id);
			vsinfoMapper.updateByPrimaryKeySelective(info);
			LOG.info("update video_sourceinfo_tbl value("
					+id
					+","+info.getCsId()
					+","+info.getVbId()
					+","+info.getVsSubvid()
					+","+info.getVsSubtitle()
					+","+info.getVsSetnumber()
					+","+info.getVsSourceurl()
					+")"
				);
		}
	}
	
	void addPlayinfo(VideoPlayinfoTbl info) {
		String subid = info.getVsSubvid();
		Short def = info.getVpDefinition();
		Integer id = optMapper.getIdBySubvidDefFromVpTbl(subid,def);
		if (id == null){
			vpinfoMapper.insertSelective(info);
			Integer ret = optMapper.getLastId();
			LOG.info("insert into video_playinfo_tbl value("
					+ret
					+","+info.getVsSubvid()
					+","+info.getVpDefinition()
					+","+info.getVpPlayurl()
					+")"
				);
		}else{
			info.setId(id);
			vpinfoMapper.updateByPrimaryKeySelective(info);
			LOG.info("update video_playinfo_tbl value("
					+id
					+","+info.getVsSubvid()
					+","+info.getVpDefinition()
					+","+info.getVpPlayurl()
					+")"
				);
		}
	}
	
	public List<AreaCategoryTbl> getAreaInfo() {
		return areaMapper.selectByExample(null);
	}
}