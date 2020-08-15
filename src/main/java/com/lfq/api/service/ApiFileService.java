package com.lfq.api.service;

import java.util.List;

import com.lfq.api.domain.ApiFile;

public interface ApiFileService {

	List<ApiFile> selectList();
	
	int insert(ApiFile apiFile);
}
