package com.dshck.dphl.nitro.nsbtx;

import com.dshck.dphl.CartridgeMemory;
import com.dshck.dphl.CartridgeStructure;

public class NitroTexturePaletteSection implements CartridgeStructure {

	private final CartridgeMemory memory;
	
	private final int address;
	
	public NitroTexturePaletteSection( CartridgeMemory memory, int address ) {
		this.memory = memory;
		this.address = address;
	}
	
	@Override
	public void reload() {
		
	}

	@Override
	public void save() {
		
	}

	
}
