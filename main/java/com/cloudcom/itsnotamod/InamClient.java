package com.cloudcom.itsnotamod;

import java.io.File;

public class InamClient extends InamCommon {

	@Override
	public void preInit(File configFile) {
		super.preInit(configFile);
		System.out.println("pre init côté client");
	}

	@Override
	public void init() {
		super.init();
	}

}
