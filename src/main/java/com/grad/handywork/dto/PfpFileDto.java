package com.grad.handywork.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PfpFileDto {
	
	@NotNull(message = "Image Cannot Be Empty")
	private String pfpFile;
	
	private String pfpUrl;

}
