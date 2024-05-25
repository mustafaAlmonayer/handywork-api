package com.grad.handywork.dto;

public class RatingsDto {

	private float asListerRating;

	private float asProfessionalRating;

	public RatingsDto(float asListerRating, float asProfessionalRating) {
		this.asListerRating = asListerRating;
		this.asProfessionalRating = asProfessionalRating;
	}

	public RatingsDto() {
	}

	public static RatingsDtoBuilder builder() {
		return new RatingsDtoBuilder();
	}

	public float getAsListerRating() {
		return this.asListerRating;
	}

	public float getAsProfessionalRating() {
		return this.asProfessionalRating;
	}

	public void setAsListerRating(float asListerRating) {
		this.asListerRating = asListerRating;
	}

	public void setAsProfessionalRating(float asProfessionalRating) {
		this.asProfessionalRating = asProfessionalRating;
	}

	public boolean equals(final Object o) {
		if (o == this) return true;
		if (!(o instanceof RatingsDto)) return false;
		final RatingsDto other = (RatingsDto) o;
		if (!other.canEqual((Object) this)) return false;
		if (Float.compare(this.getAsListerRating(), other.getAsListerRating()) != 0) return false;
		if (Float.compare(this.getAsProfessionalRating(), other.getAsProfessionalRating()) != 0) return false;
		return true;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof RatingsDto;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		result = result * PRIME + Float.floatToIntBits(this.getAsListerRating());
		result = result * PRIME + Float.floatToIntBits(this.getAsProfessionalRating());
		return result;
	}

	public String toString() {
		return "RatingsDto(asListerRating=" + this.getAsListerRating() + ", asProfessionalRating=" + this.getAsProfessionalRating() + ")";
	}

	public static class RatingsDtoBuilder {
		private float asListerRating;
		private float asProfessionalRating;

		RatingsDtoBuilder() {
		}

		public RatingsDtoBuilder asListerRating(float asListerRating) {
			this.asListerRating = asListerRating;
			return this;
		}

		public RatingsDtoBuilder asProfessionalRating(float asProfessionalRating) {
			this.asProfessionalRating = asProfessionalRating;
			return this;
		}

		public RatingsDto build() {
			return new RatingsDto(this.asListerRating, this.asProfessionalRating);
		}

		public String toString() {
			return "RatingsDto.RatingsDtoBuilder(asListerRating=" + this.asListerRating + ", asProfessionalRating=" + this.asProfessionalRating + ")";
		}
	}
}
