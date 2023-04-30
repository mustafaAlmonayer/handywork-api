package com.grad.handywork.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import lombok.SneakyThrows;

@Component
public class CloudinaryUtil {
	
	@Autowired
	private Cloudinary cloudinary;
	
	@Value("${DEFAULT_JOB_P_URL}")
	private String DEFAULT_JOB_P_URL;
	
    @SneakyThrows
    public String imageUpload(String base64Image) {
        byte imageBytes[] = Base64.getDecoder().decode(base64Image);
        return cloudinary.uploader().upload(imageBytes, ObjectUtils.emptyMap()).get("url").toString();
    }
    
	public List<String> imageUpload(List<String> base64Images) {
		List<String> urls = new ArrayList<>();
		base64Images.forEach((String base64Image) -> {
			try {
				urls.add(imageUpload(base64Image));
			} catch (RuntimeException e) {
			}
		});
		if (urls.isEmpty())
			urls.add(DEFAULT_JOB_P_URL);
		return urls;
	}
    
    public void deleteImage(String imageUrl) {
    	String publicId = extractPublicIdFromUrl(imageUrl);
    	try {
			cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
		} catch (IOException e) {}
    }
    
    private String extractPublicIdFromUrl(String imageUrl) {
    	final int START_INDEX = 61;
    	final int END_INDEX = 81;
    	return imageUrl.substring(START_INDEX, END_INDEX);
    }
    
}
