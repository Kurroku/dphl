package com.dshck.dphl.nitro.ncgr;

import com.dshck.dphl.CartridgeMemory;
import com.dshck.dphl.nitro.NitroFileStore;

/**
 * 
 * @author Phillip Groves
 *
 */
public final class NitroCharacterGraphic extends NitroFileStore {
	
	public NitroCharacterGraphic( CartridgeMemory memory, int address ) {
		super( memory, address );
		reload();
	}

	@Override
	public void reload() {
		
	}

	@Override
	public void save() {
		
	}
}
