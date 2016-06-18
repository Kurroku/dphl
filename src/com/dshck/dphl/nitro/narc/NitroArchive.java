package com.dshck.dphl.nitro.narc;

import java.util.Map;

import com.dshck.dphl.CartridgeMemory;
import com.dshck.dphl.nitro.NitroFileStore;

/**
 * 
 * @author Phillip Groves
 *
 */
public final class NitroArchive extends NitroFileStore {
	
	/**  */
	private final NitroAllocationSection allocationBlock;
	
	/**  */
	private final NitroNameSection nameBlock;
	
	/**
	 * 
	 * @param memory
	 * @param address
	 * @param attributes
	 */
	public NitroArchive( CartridgeMemory memory, int address, Map<String, Object> attributes ) {
		super ( memory, address, attributes );
		this.allocationBlock = new NitroAllocationSection( memory, address + header.getHeaderSize() );
		this.nameBlock = new NitroNameSection( memory, address + header.getHeaderSize() + ( allocationBlock.getFileCount() * 8 ) );
	}
	
	@Override
	public void reload() {
		
	}
	
	@Override
	public void save() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public NitroAllocationSection getAllocationSection() {
		return allocationBlock;
	}
	
	/**
	 * 
	 * @return
	 */
	public NitroNameSection getNameSection() {
		return nameBlock;
	}
}
