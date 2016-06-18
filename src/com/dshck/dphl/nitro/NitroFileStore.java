package com.dshck.dphl.nitro;

import java.nio.file.FileStore;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.HashMap;
import java.util.Map;

import com.dshck.dphl.CartridgeMemory;
import com.dshck.dphl.CartridgeStructure;

/**
 * 
 * @author Phillip Groves
 *
 */
public abstract class NitroFileStore extends FileStore implements CartridgeStructure {
	
	/**  */
	protected final CartridgeMemory memory;
	
	/**  */
	protected final int address;
	
	/**  */
	protected final NitroFileHeader header;
	
	/**  */
	protected final Map<String, Object> attributes;
	
	/**
	 * 
	 * @param memory
	 * @param address
	 */
	protected NitroFileStore( CartridgeMemory memory, int address, Map<String, Object> attributes ) {
		this.memory = memory;
		this.address = address;
		this.header = new NitroFileHeader( memory, address );
		this.attributes = attributes == null ? new HashMap<String, Object>() : attributes;
	}
	
	/**
	 * 
	 * @param memory
	 * @param address
	 */
	protected NitroFileStore( CartridgeMemory memory, int address ) {
		this ( memory, address, null );
	}

	/**
	 * @Returns Null if attribute is not found.
	 */
	@Override
	public Object getAttribute(String attribute) {
		if ( attributes.containsKey( attribute ) )
			return attributes.get( attribute );
		return null;
	}
	
	/**
	 * 
	 * @Deprecated Not yet implemented
	 */
	@Deprecated
	@Override
	public <V extends FileStoreAttributeView> V getFileStoreAttributeView( Class<V> type ) {
		return null;
	}

	/**
	 * 
	 */
	@Override
	public long getTotalSpace() {
		return header.getFileSize();
	}

	/**
	 * 
	 * @Deprecated Not yet implemented
	 */
	@Deprecated
	@Override
	public long getUnallocatedSpace() {
		return 0;
	}

	/**
	 * 
	 * @Deprecated Not yet implemented
	 */
	@Deprecated
	@Override
	public long getUsableSpace() {
		return 0;
	}

	/**
	 * 
	 * @Deprecated Not yet implemented
	 */
	@Deprecated
	@Override
	public boolean isReadOnly() {
		return false;
	}

	/**
	 * 
	 * @Deprecated Not yet implemented
	 */
	@Deprecated
	@Override
	public String name() {
		return null;
	}

	@Override
	public String type() {
		return memory.getString( address, 4 );
	}
	
	/**
	 * 
	 * @Deprecated Not yet implemented
	 */
	@Deprecated
	@Override
	public boolean supportsFileAttributeView( Class<? extends FileAttributeView> type ) {
		return false;
	}

	/**
	 * 
	 * @Deprecated Not yet implemented
	 */
	@Deprecated
	@Override
	public boolean supportsFileAttributeView( String name ) {
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public NitroFileHeader getHeader() {
		return header;
	}
}
