package com.dshck.dphl.nitro.narc;

import com.dshck.dphl.CartridgeMemory;
import com.dshck.dphl.CartridgeStructure;

/**
 * 
 * @author Phillip Groves
 *
 */
public class NitroNameSection implements CartridgeStructure {
	
	public NitroNameSection(CartridgeMemory memory, int address ) {
		reload();
	}

	@Override
	public void reload() {
		
	}

	@Override
	public void save() {
		
	}
}
