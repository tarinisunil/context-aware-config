
package com.adarsh.aem.guides.cntxtaware.core.models;

import javax.annotation.PostConstruct;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import com.adarsh.aem.guides.cntxtaware.core.config.CntxtConfig;
import com.day.cq.wcm.api.Page;

@Model(adaptables = SlingHttpServletRequest.class)
public class ConfigurationModel {

	private String message;

	@ScriptVariable
	private Page currentPage;

	@Self
	private SlingHttpServletRequest slingRequest;

	@PostConstruct
	protected void init() {

		try {
			ResourceResolver resourceResolver;
			resourceResolver = slingRequest.getResourceResolver();
			Resource contentResource = resourceResolver.getResource(currentPage.getPath());
			if (contentResource != null) {
				ConfigurationBuilder configurationBuilder = contentResource.adaptTo(ConfigurationBuilder.class);
				if (configurationBuilder != null) {
					CntxtConfig myProjeCAConfig = configurationBuilder.as(CntxtConfig.class);
					String adminEmail = myProjeCAConfig.adminemail();
					message = adminEmail;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getMessage() {
		return message;
	}
}
