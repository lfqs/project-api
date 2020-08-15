package com.lfq.api.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lfq.api.domain.ApiFile;
import com.lfq.api.service.ApiFileService;
import com.lfq.page.TableDataInfo;
import com.lfq.utils.DateUtils;
import com.lfq.utils.Result;
import com.lfq.utils.file.FileUploadUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/file")
@Api(tags = "图片管理")
public class FileController extends BaseController{

	@Autowired
	ApiFileService apiFileService;
	
	/**
	 * @param pageNum  当前记录起始索引
	 * @param pageSize 每页显示记录数
	 * @param orderByColumn  排序列
	 * @param isAsc 排序的方向 "desc" 或者 "asc".
	 * @return
	 */
    @PostMapping("/selectFile")
    @ApiOperation(value = "获取图片")
    public TableDataInfo a(int pageNum,int pageSize,String orderByColumn,String isAsc) {
    	startPage();
    	List<ApiFile> list = apiFileService.selectList();
        return getDataTable(list);
    }
	
    @PostMapping("/updateFile")
    @ApiOperation(value = "上传图片接口")
    public Result updateAvatar(@RequestParam("ufile") MultipartFile file) {
    	Result result = new Result();
    	ApiFile apiFile = new ApiFile();
        if (!file.isEmpty()) {
			try {
				String avatar =FileUploadUtils.upload(file);
				apiFile.setFileurl(avatar);
				apiFile.setRemark(DateUtils.getDate()+"上传了");
				apiFile.setCreatetime(new Date());
				apiFile.setUpdatetime(new Date());
				int count = apiFileService.insert(apiFile);
				if(count>0) {
					return result.setMessage("上传图片的地址为："+avatar);
				}else {
					return result.setMessage("上传图片的地址为："+avatar);
				}				
			} catch (IOException e) {
				e.printStackTrace();
			}           
        }
        return result.setMessage("上传图片的地址为null");
    }
    
//    @PostMapping("/updateFiles")
//    public Result updateAvatars(@RequestParam("ufile") MultipartFile file) {
//    	Result result = new Result();
//        if (!file.isEmpty()) {
//			try {
//				String avatar =FileUploadUtils.upload(SystemConfig.getProfile(), file);
//				return result.setMessage("上传图片的地址为："+avatar);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}           
//        }
//        return result.setMessage("上传图片的地址为null");
//    }
    
}
