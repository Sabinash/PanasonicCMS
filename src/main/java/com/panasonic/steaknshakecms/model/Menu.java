package com.panasonic.steaknshakecms.model;

import org.springframework.data.annotation.Id;

public class Menu {
	@Id
	private String label;
	private String imageUrl;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Menu [label=" + label + ", imageUrl=" + imageUrl + "]";
	}
}
