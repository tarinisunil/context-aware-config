package com.adarsh.aem.guides.cntxtaware.core.config;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(label = "Cntxtaware Project Sling Context Aware Configuration", description = "Cntxtaware Project Sling Context Aware Configuration")
public @interface CntxtConfig {

	 @Property(label = "token", description = "This property contains the value of token")
	    String token();
}
