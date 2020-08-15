package com.lfq.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lfq.api.domain.ApiFile;
import com.lfq.api.mapper.ApiFileMapper;

@Service
public class ApiFileServiceImpl implements ApiFileService{

	@Autowired
	private ApiFileMapper apiFileMapper;
	
	@Override
	public List<ApiFile> selectList() {
		return apiFileMapper.selectList();
	}

	@Override
	public int insert(ApiFile apiFile) {
		return apiFileMapper.insert(apiFile);
	}

}
