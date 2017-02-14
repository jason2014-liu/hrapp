/**
* TODO
* @Project: hrapp
* @Title: RegionServiceImpl.java
* @Package com.lmstudio.hr.service
* @author jason
* @Date 2017年2月14日 下午2:54:47
* @Copyright
* @Version 
*/
package com.lmstudio.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmstudio.hr.model.Region;
import com.lmstudio.hr.repository.RegionRepository;

/**
* TODO
* @ClassName: RegionServiceImpl
* @author jason
*/
@Service
public class RegionServiceImpl implements RegionService {
	
	@Autowired
	private RegionRepository regionRepository;

	@Override
	public List<Region> getAllRegions() {
		// TODO Auto-generated method stub
		return regionRepository.getAllRegion();
	}

}
