package com.liferay.test.porlet;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class VaadinPortletApplication extends Application {

	private static final long serialVersionUID = -7946115242793862150L;

	/**
	 * Default constructor.
	 */
	public VaadinPortletApplication() {
	}

	public void init() {
		Window window = new Window("My First Vaadin Application");
		setMainWindow(window);
		window.addComponent(new Label("Beginning Vaadin Testing!"));
	}

}
