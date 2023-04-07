package com.grad.handywork.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PfpFileDto {
	
	@NotEmpty
	private String pfpFile;
	
	private String pfpUrl;

}
