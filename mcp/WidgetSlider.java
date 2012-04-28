package net.minecraft.src;

import de.matthiasmann.twl.ValueAdjusterFloat;
import de.matthiasmann.twl.model.FloatModel;

/**
 * This is a simple extension of ValueAdjusterFloat so that it always updates
 * the setting. Used internally.
 * 
 * @author lahwran
 */
public class WidgetSlider extends ValueAdjusterFloat {
	/**
	 * This is the basic constructor. It just calls the ValueAdjusterFloat
	 * constructor, as well as adding an option to allow editing the value with text.
	 * 
	 * @param f
	 *            The FloatModel to use.
	 */
	public WidgetSlider(FloatModel f) {
		super(f);
	}
	
	private boolean canEdit = false;;
	
	public void setCanEdit(boolean value)
	{
		canEdit = value;
	}
	
	public boolean getCanEdit()
	{
		return canEdit;
	}

	@Override
	public void startEdit() {
		if(!getCanEdit())
		{
			cancelEdit();
		}
		else
		{
			super.startEdit();
		}
	}
	
	@Override
	protected String onEditStart()
	{
		return Float.toString(getValue());
	}
}
