package com.grad.handywork.dto;

import jakarta.validation.constraints.NotNull;

public class PfpFileDto {

	@NotNull(message = "Image Cannot Be Empty")
	private String pfpFile;

	private String pfpUrl;

	public PfpFileDto(@NotNull(message = "Image Cannot Be Empty") String pfpFile, String pfpUrl) {
		this.pfpFile = pfpFile;
		this.pfpUrl = pfpUrl;
	}

	public PfpFileDto() {
	}

	public static PfpFileDtoBuilder builder() {
		return new PfpFileDtoBuilder();
	}

	public @NotNull(message = "Image Cannot Be Empty") String getPfpFile() {
		return this.pfpFile;
	}

	public String getPfpUrl() {
		return this.pfpUrl;
	}

	public void setPfpFile(@NotNull(message = "Image Cannot Be Empty") String pfpFile) {
		this.pfpFile = pfpFile;
	}

	public void setPfpUrl(String pfpUrl) {
		this.pfpUrl = pfpUrl;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof PfpFileDto)) return false;
		final PfpFileDto other = (PfpFileDto) o;
		if (!other.canEqual((Object) this)) return false;
		final Object this$pfpFile = this.getPfpFile();
		final Object other$pfpFile = other.getPfpFile();
		if (this$pfpFile == null ? other$pfpFile != null : !this$pfpFile.equals(other$pfpFile)) return false;
		final Object this$pfpUrl = this.getPfpUrl();
		final Object other$pfpUrl = other.getPfpUrl();
		if (this$pfpUrl == null ? other$pfpUrl != null : !this$pfpUrl.equals(other$pfpUrl)) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof PfpFileDto;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $pfpFile = this.getPfpFile();
		result = result * PRIME + ($pfpFile == null ? 43 : $pfpFile.hashCode());
		final Object $pfpUrl = this.getPfpUrl();
		result = result * PRIME + ($pfpUrl == null ? 43 : $pfpUrl.hashCode());
		return result;
	}

	public String toString() {
		return "PfpFileDto(pfpFile=" + this.getPfpFile() + ", pfpUrl=" + this.getPfpUrl() + ")";
	}

	public static class PfpFileDtoBuilder {
		private @NotNull(message = "Image Cannot Be Empty") String pfpFile;
		private String pfpUrl;

		PfpFileDtoBuilder() {
		}

		public PfpFileDtoBuilder pfpFile(@NotNull(message = "Image Cannot Be Empty") String pfpFile) {
			this.pfpFile = pfpFile;
			return this;
		}

		public PfpFileDtoBuilder pfpUrl(String pfpUrl) {
			this.pfpUrl = pfpUrl;
			return this;
		}

		public PfpFileDto build() {
			return new PfpFileDto(this.pfpFile, this.pfpUrl);
		}

		public String toString() {
			return "PfpFileDto.PfpFileDtoBuilder(pfpFile=" + this.pfpFile + ", pfpUrl=" + this.pfpUrl + ")";
		}
	}
}
