package johnnoonan.sketchFrameExporter;


import java.text.SimpleDateFormat;
import java.util.Date;

import processing.core.*;

/**
 * This is a template class and can be used to start a new processing Library.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own Library naming convention.
 * 
 * (the tag example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 * @example Hello 
 */

public class SketchFrameExporter {
	
	// myParent is a reference to the parent sketch
	PApplet myParent;
	/*
	 * Types of files that can be rendered
	 */
	public enum FileType {
		PNG,
		TIF,
		TGA,
		JPG
	}
		
	private String outFolder;
	private FileType fileType = FileType.PNG;
	private String ext = "png";
	private boolean performRender = false;
	
	private int frameNum = 0;
	private String take;
	private SimpleDateFormat dateFormat; 
	
	
	public final static String VERSION = "##library.prettyVersion##";

	/**
	 * a Constructor called in the setup
	 * @param theParent the parent PApplet
	 */
	public SketchFrameExporter(PApplet theParent) {
		this(theParent, "data");
	}
	
	/**
	 * A Constructor called in the setup
	 * @param theParent the parent PApplet
	 * @param outFolder base folder to render out to
	 */
	public SketchFrameExporter(PApplet theParent, String outFolder) {
		this.outFolder = outFolder;
		myParent = theParent;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	}
	
	/**
	 * Set the base output folder
	 * @param newOutFolder base folder to render out to
	 */
	public void setOutFolder(String newOutFolder) {
		outFolder = newOutFolder;
	}
	
	/**
	 * Set the output file type
	 * @param newType Type of file to render out as 
	 */
	public void setExtension(FileType newType) {
		switch(newType) {
			case JPG:
				ext = "jpg";
				break;
			case PNG:
				ext = "png";
				break;
			case TGA:
				ext = "tga";
				break;
			case TIF:
				ext = "tif";
				break;
			default:
				throw new IllegalArgumentException("Cannot set extension type to given value");
		}
		fileType = newType;
	}
	
	/**
	 * Start a new render into a new take with the current time stamp
	 */
	public void startRender() {
		performRender = true;
		take = dateFormat.format(new Date());
	}
	
	/**
	 * Stop the current render for this take
	 */
	public void stopRender() {
		performRender = false;
		frameNum = 0;
	}
	
	/**
	 * Render the current frame. This should be called after all work in draw() has been finished.
	 * if startRender() has not been called this will not produce an image
	 */
	public void renderFrame() {
		if (performRender) {
			myParent.saveFrame(String.format("%s/%s/%06d.%s", outFolder, take, frameNum, ext));
			frameNum++;
		}
	}
	
	/**
	 * Get whether there is a current render take happening
	 * @return whether calling renderFrame() will produce a frame
	 */
	public boolean isRendering() {
		return performRender;
	}
	
	
	/**
	 * return the version of the Library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

}

