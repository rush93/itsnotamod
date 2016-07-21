package com.cloudcom.itsnotamod;

import java.io.File;

public class InamServer extends InamCommon {
	@Override
	public void preInit(File configFile) {
		super.preInit(configFile);
		System.out.println("pre init côté serveur");
	}

	@Override
	public void init() {
		super.init();
	}
}