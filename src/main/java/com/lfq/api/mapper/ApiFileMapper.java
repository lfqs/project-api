package com.lfq.api.mapper;

import java.util.List;

import com.lfq.api.domain.ApiFile;

public interface ApiFileMapper {

	List<ApiFile> selectList();
	
	int insert(ApiFile apiFile);
}
