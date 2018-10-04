package com.arindam.library.adapter;

import android.graphics.drawable.Drawable;

public class NavigationArinItemAdapter {

	public String title;
	public int counter;
	public int icon;
	public Drawable dIcon;
	public boolean isHeader;
    public int colorSelected = 0;
	public boolean isVisible = true;
	public boolean checked = false;
    public boolean removeSelector = false;

	public NavigationArinItemAdapter(String title, int icon, boolean header, int counter, int colorSelected, boolean removeSelector, boolean isVisible) {
		this.title = title;
		this.icon = icon;
		this.isHeader = header;
		this.counter = counter;
		this.isVisible = isVisible;
        this.colorSelected = colorSelected;
        this.removeSelector = removeSelector;
	}

	public NavigationArinItemAdapter(String title, Drawable icon, boolean header, int counter, int colorSelected, boolean removeSelector, boolean isVisible) {
		this.title = title;
		this.dIcon = icon;
		this.isHeader = header;
		this.counter = counter;
		this.isVisible = isVisible;
		this.colorSelected = colorSelected;
		this.removeSelector = removeSelector;
	}

    public NavigationArinItemAdapter(String title, int icon, boolean header, int counter) {
        this.title = title;
        this.icon = icon;
        this.isHeader = header;
        this.counter = counter;
		this.isVisible = true;
    }
}
