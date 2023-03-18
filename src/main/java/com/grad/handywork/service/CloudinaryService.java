package com.grad.handywork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grad.handywork.util.CloudinaryUtil;

@Service
public class CloudinaryService {
	
	@Autowired
	CloudinaryUtil cloudinaryUtil;
	
	public String imageToUrl(String base64Image) {
		return cloudinaryUtil.imageUpload(base64Image);
	}
	
	public List<String> imageToUrl(List<String> base64Image) {
		return cloudinaryUtil.imageUpload(base64Image);
	}
	
	public void deleteImage(String imageUrl) {
		cloudinaryUtil.deleteImage(imageUrl);
	}

}
