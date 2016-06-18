package com.dshck.dphl.nitro.nsbtx;

import com.dshck.dphl.CartridgeMemory;
import com.dshck.dphl.nitro.NitroFileStore;

/**
 * 
 * @author Phillip Groves
 *
 */
public final class NitroTexture extends NitroFileStore {
	
	private final NitroTexturePixelSection pixelSection;
	
	private final NitroTexturePaletteSection paletteSection;
	
	private final NitroTextureImageSection imageSection;
	
	private String stamp;
	
	private int textureDataSize;
	
	private int textureInfoOffset;
	
	private int textureDataOffset;
	
	private int compressedTextureDataSize;
	
	private int compressedTextureInfoOffset;
	
	private int compressedTextureDataOffset;
	
	private int compressedTextureInfoDataOffset;
	
	private int paletteDataSize;
	
	private int paletteInfoSize;
	
	private int paletteDataOffset;
	
	protected NitroTexture( CartridgeMemory memory, int address ) {
		super( memory, address );
		this.pixelSection = null;
		this.paletteSection = null;
		this.imageSection = null;
	}

	@Override
	public void reload() {
		
	}

	@Override
	public void save() {
		
	}

}
