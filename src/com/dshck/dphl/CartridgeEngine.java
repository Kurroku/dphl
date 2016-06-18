package com.dshck.dphl;

import java.io.File;
import java.nio.file.Path;

import com.dshck.dphl.nitro.NitroFileStore;
import com.dshck.dphl.nitro.NitroFileSystemProvider;

/**
 * 
 * @author Phillip Groves
 *
 */
public class CartridgeEngine {

	/**  */
	private final CartridgeHeader header;
	
	/**  */
	private final NitroFileSystemProvider fsProvider;
	
	/**  */
	private final CartridgeMemory memory;
	
	/**
	 * 
	 * @param rom
	 */
	public CartridgeEngine( File file ) {
		this.memory = new CartridgeMemory( file );
		
		this.header = new CartridgeHeader( memory );
		this.fsProvider = new NitroFileSystemProvider( memory );
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public NitroFileStore getFileStore( Path path ) {
		return fsProvider.getFileStore( path );
	}
	
	/**
	 * 
	 * @return
	 */
	public NitroFileSystemProvider getFileSystemProvider() {
		return fsProvider;
	}
	
	/**
	 * 
	 * @return
	 */
	public CartridgeHeader getHeader() {
		return header;
	}
	
	/**
	 * 
	 * @return
	 */
	public CartridgeMemory getMemory() {
		return memory;
	}
}
