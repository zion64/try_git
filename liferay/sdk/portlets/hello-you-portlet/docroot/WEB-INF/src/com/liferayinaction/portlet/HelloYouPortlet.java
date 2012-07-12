package com.liferayinaction.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class HelloYouPortlet extends GenericPortlet {
	protected String editJSP;
	protected String viewJSP;
	private static Log _log = LogFactoryUtil.getLog(HelloYouPortlet.class);

	public void init() {
		this.editJSP = getInitParameter("edit-jsp");
		this.viewJSP = getInitParameter("view-jsp");
	}

	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		renderResponse.setContentType("text/html");

		PortletURL addNameURL = renderResponse.createActionURL();
		addNameURL.setParameter("addName", "addName");
		renderRequest.setAttribute("addNameURL", addNameURL.toString());
		include(this.editJSP, renderRequest, renderResponse);
	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences prefs = renderRequest.getPreferences();
		String username = prefs.getValue("name", "no");
		if (username.equalsIgnoreCase("no"))
			username = "<b>[USERNNAME not yet defined]!</b>";
		else {
			username = "<b>" + username + "</b>";
		}
		if (_log.isDebugEnabled()) {
			_log.debug("Preference name=[" + username + "]");
		}
		renderRequest.setAttribute("userName", username);
		include(this.viewJSP, renderRequest, renderResponse);
	}

	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		String addName = actionRequest.getParameter("addName");
		if (addName != null) {
			PortletPreferences prefs = actionRequest.getPreferences();
			prefs.setValue("name", actionRequest.getParameter("username"));
			prefs.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		}
	}

	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher == null)
			_log.error(path + " is not a valid include");
		else
			portletRequestDispatcher.include(renderRequest, renderResponse);
	}
}