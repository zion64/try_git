package com.liferay.test.porlet;

import java.util.Date;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class VaadinPortletApplication extends Application {

	private static final long serialVersionUID = -7946115242793862150L;

	/**
	 * Default constructor.
	 */
	public VaadinPortletApplication() {
	}

	public void init() {
		final Window mainWindow = new Window("My First Vaadin Application, title modified");
		Label label = new Label("Hello Vaadin user, Vaadin is cool, changed, again!");
		mainWindow.addComponent(label);
		mainWindow.addComponent(

		new Button("What is the time, now, pal?", new Button.ClickListener() {
			private static final long serialVersionUID = 766296968621305962L;

			public void buttonClick(ClickEvent event) {
				mainWindow.showNotification("The time is now, ehh  " + new Date());
			}
		}));
		setMainWindow(mainWindow);
	}
}