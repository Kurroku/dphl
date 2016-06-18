package com.dshck.dphl.nitro.nsbmd;

import com.dshck.dphl.CartridgeMemory;
import com.dshck.dphl.nitro.NitroFileStore;

/**
 * 
 * @author Phillip Groves
 *
 */
public final class NitroModel extends NitroFileStore {
	
	/**
	 * 
	 * @param memory
	 * @param address
	 */
	public NitroModel( CartridgeMemory memory, int address ) {
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
