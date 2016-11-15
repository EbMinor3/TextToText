package com.evanbelcher.TextToText;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.util.Vector;
import javax.swing.JComponent;

public final class ComponentImage implements RenderedImage {
	
	private final JComponent comp;
	private final ColorModel colorModel;
	private final SampleModel sampleModel;
	
	public ComponentImage(JComponent comp) {
		this.comp = comp;
		this.colorModel = comp.getColorModel();
		this.sampleModel = this.colorModel.createCompatibleWritableRaster(1, 1).getSampleModel();
	}
	
	@Override
	public ColorModel getColorModel() {
		return this.comp.getColorModel();
	}
	
	@Override
	public SampleModel getSampleModel() {
		return this.sampleModel;
	}
	
	@Override
	public Raster getData(Rectangle rect) {
		final WritableRaster raster = this.colorModel.createCompatibleWritableRaster(rect.width, rect.height);
		
		final Raster result = raster.createChild(0, 0, rect.width, rect.height, rect.x, rect.y, null);
		
		final BufferedImage img = new BufferedImage(colorModel, raster, true, null);
		
		final Graphics2D g2d = img.createGraphics();
		g2d.translate(-rect.x, -rect.y);
		this.comp.paintAll(g2d);
		g2d.dispose();
		
		return result;
		
	}
	
	@Override
	public Vector<RenderedImage> getSources() {
		return null;
	}
	
	@Override
	public Object getProperty(String name) {
		return null;
	}
	
	@Override
	public String[] getPropertyNames() {
		return null;
	}
	
	@Override
	public int getWidth() {
		return 0;
	}
	
	@Override
	public int getHeight() {
		return 0;
	}
	
	@Override
	public int getMinX() {
		return 0;
	}
	
	@Override
	public int getMinY() {
		return 0;
	}
	
	@Override
	public int getNumXTiles() {
		return 0;
	}
	
	@Override
	public int getNumYTiles() {
		return 0;
	}
	
	@Override
	public int getMinTileX() {
		return 0;
	}
	
	@Override
	public int getMinTileY() {
		return 0;
	}
	
	@Override
	public int getTileWidth() {
		return 0;
	}
	
	@Override
	public int getTileHeight() {
		return 0;
	}
	
	@Override
	public int getTileGridXOffset() {
		return 0;
	}
	
	@Override
	public int getTileGridYOffset() {
		return 0;
	}
	
	@Override
	public Raster getTile(int tileX, int tileY) {
		return null;
	}
	
	@Override
	public Raster getData() {
		return null;
	}
	
	@Override
	public WritableRaster copyData(WritableRaster raster) {
		return null;
	}
}